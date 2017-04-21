package com.fi.mynlpapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by smpathak on 4/20/17.
 */
public class ProcessingTask extends AsyncTask<Void, Void, Void> {

    private Activity screen;
    private String input;
    private String[] outputs;

    public ProcessingTask(Activity activity, String question) {
        this.screen = activity;
        this.input = question;
    }

    @Override
    protected Void doInBackground(Void... params) {
        outputs = new SentenceDetectorUtil(screen.getApplicationContext()).getSentences(input);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        if (outputs != null && outputs.length >= 0) {
            for (String each:outputs){
                Log.d("DEBUG_LOG", ">" + each + "<");
                ((MainActivity)screen).updateScreen("Last : " + each.toUpperCase());
            }
        }

    }
}

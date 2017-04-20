package com.fi.mynlpapp;

import android.app.Activity;
import android.os.AsyncTask;

/**
 * Created by smpathak on 4/20/17.
 */
public class ProcessingTask extends AsyncTask<Void, Void, Void> {

    private Activity screen;
    private String input;

    public ProcessingTask(Activity activity, String question) {
        this.screen = activity;
        this.input = question;
    }

    @Override
    protected Void doInBackground(Void... params) {
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        ((MainActivity)screen).updateScreen(input.toUpperCase());
    }
}

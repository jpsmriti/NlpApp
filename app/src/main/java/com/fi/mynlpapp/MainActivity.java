package com.fi.mynlpapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.ButterKnife;

public class MainActivity extends Activity {

    //@Bind(R.id.qestion)
    protected EditText question;
    //@Bind(R.id.answer)
    protected EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        question = (EditText)findViewById(R.id.qestion);
        answer = (EditText)findViewById(R.id.answer);

        ((Button)findViewById(R.id.ask)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askQuestion(v);
            }
        });
    }

    //@OnClick(R.id.ask)
    protected void askQuestion(View v){
        new ProcessingTask(MainActivity.this, question.getText().toString()).execute();
    }


    public void updateScreen(String response){
        answer.setText(response);
    }
}
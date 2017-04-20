package com.fi.mynlpapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.qestion)
    protected EditText question;
    @Bind(R.id.answer)
    protected EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.ask)
    protected void ask(View v){
        new ProcessingTask(MainActivity.this, question.getText().toString()).execute();
    }


    public void updateScreen(String response){
        answer.setText(response);
    }
}
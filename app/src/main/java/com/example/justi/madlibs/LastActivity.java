package com.example.justi.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        TextView mTextView = (TextView) findViewById(R.id.story);
        mTextView.setText("test");
    }

    public void goToSecond(View view){

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        finish();
    }
}

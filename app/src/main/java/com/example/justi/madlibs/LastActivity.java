package com.example.justi.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class LastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        TextView mTextView = (TextView) findViewById(R.id.story);
        mTextView.setText("test");

        try{
            InputStream is = getAssets().open("madlib0_simple.txt");
        } catch (IOException ex){
            ex.printStackTrace();
        }


    }

    public void goToSecond(View view){

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        finish();
    }
}

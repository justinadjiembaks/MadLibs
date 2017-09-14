package com.example.justi.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        String receivedstring = intent.getStringExtra("number");
    }

    public void goToLast(View view){

        Intent intent = new Intent(this,LastActivity.class);
        startActivity(intent);
        finish();
    }
}

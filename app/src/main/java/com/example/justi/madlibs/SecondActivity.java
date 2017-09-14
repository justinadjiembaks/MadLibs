package com.example.justi.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    public void goToThirdsimple(View view){

        Intent intent = new Intent(this,ThirdActivity.class);
        intent.putExtra("1",1);
        startActivity(intent);
        finish();
    }
    public void goToThirdtarzan(View view){

        Intent intent = new Intent(this,ThirdActivity.class);
        intent.putExtra("2",2);
        startActivity(intent);
        finish();
        }

    public void goToThirduniversity(View view){

        Intent intent = new Intent(this,ThirdActivity.class);
        intent.putExtra("3",3);
        startActivity(intent);
        finish();
    }

    public void goToThirddance(View view){

        Intent intent = new Intent(this,ThirdActivity.class);
        intent.putExtra("4",4);
        startActivity(intent);
        finish();
    }

    public void goToThirdclothes(View view){

        Intent intent = new Intent(this,ThirdActivity.class);
        intent.putExtra("5",5);
        startActivity(intent);
        finish();
    }
    public void goToThirdrandom(View view){

        Intent intent = new Intent(this,ThirdActivity.class);
        intent.putExtra("6",6);
        startActivity(intent);
        finish();
        }

}

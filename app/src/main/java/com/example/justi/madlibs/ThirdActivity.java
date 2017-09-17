package com.example.justi.madlibs;

import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ThirdActivity extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        String receivedstring = intent.getStringExtra("number");

        text = (TextView)findViewById(R.id.story);
        //text.setText(receivedstring);

        String data = "";
        StringBuffer sbuffer = new StringBuffer();

        InputStream is = null;

        if (receivedstring == "simple"){
            is = this.getResources().openRawResource(R.raw.madlib0_simple);
        }
        else if (receivedstring == "tarzan"){
            is = this.getResources().openRawResource(R.raw.madlib1_tarzan);
        }
        else if (receivedstring == "university"){
            is = this.getResources().openRawResource(R.raw.madlib2_university);
        }
        else if (receivedstring == "clothes"){
            is = this.getResources().openRawResource(R.raw.madlib3_clothes);
        }
        else if (receivedstring == "dance"){
            is = this.getResources().openRawResource(R.raw.madlib4_dance);
        }
        else {
            is = this.getResources().openRawResource(R.raw.madlib1_tarzan);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        if (is != null){

            try{
                while((data = reader.readLine()) != null){
                    sbuffer.append(data + " ");
                }
                text.setText(sbuffer);
                is.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    public void goToLast(View view){

        Intent intent = new Intent(this,LastActivity.class);
        startActivity(intent);
        finish();
    }
}

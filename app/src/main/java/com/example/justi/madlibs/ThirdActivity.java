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
import java.util.Random;

public class ThirdActivity extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        int receivedint = intent.getIntExtra("number",0);

        text = (TextView)findViewById(R.id.story);


        String data = "";
        StringBuffer sbuffer = new StringBuffer();

        InputStream is = null;

        if (receivedint != 1 || receivedint != 2|| receivedint != 3|| receivedint != 4|| receivedint != 5){

            Random rand = new Random();
            int randomnumber = rand.nextInt(5);
            receivedint = randomnumber;

        }
        if (receivedint == 1){
            is = this.getResources().openRawResource(R.raw.madlib0_simple);
        }
        else if (receivedint == 2){
            is = this.getResources().openRawResource(R.raw.madlib1_tarzan);
        }
        else if (receivedint == 3){
            is = this.getResources().openRawResource(R.raw.madlib2_university);
        }
        else if (receivedint == 4){
            is = this.getResources().openRawResource(R.raw.madlib3_clothes);
        }
        else {
            is = this.getResources().openRawResource(R.raw.madlib4_dance);
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

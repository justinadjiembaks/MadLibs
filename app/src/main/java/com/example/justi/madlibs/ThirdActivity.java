package com.example.justi.madlibs;

import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import com.example.justi.madlibs.Story;


import static com.example.justi.madlibs.R.id.button;
import static com.example.justi.madlibs.R.id.hintje;
import static com.example.justi.madlibs.R.id.storytext;
import static com.example.justi.madlibs.R.id.wordsleft;

public class ThirdActivity extends AppCompatActivity {

    TextView text;
    Story inputstream;
    EditText hint;
    TextView words;
    int counter = 1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        final Intent intent = getIntent();
        int receivedint = intent.getIntExtra("number", 0);

        text = (TextView) findViewById(storytext);
        hint = (EditText) findViewById(hintje);
        words = (TextView) findViewById(wordsleft);
        btn = (Button) findViewById(button);


        InputStream is = null;

        if (receivedint != 1 && receivedint != 2 && receivedint != 3 && receivedint != 4 && receivedint != 5) {

            Random rand = new Random();
            int randomnumber = rand.nextInt(5);
            receivedint = randomnumber;

        }
        if (receivedint == 1) {
            inputstream = new Story(this.getResources().openRawResource(R.raw.madlib0_simple));
        } else if (receivedint == 2) {
            inputstream = new Story(this.getResources().openRawResource(R.raw.madlib1_tarzan));
        } else if (receivedint == 3) {
            inputstream = new Story(this.getResources().openRawResource(R.raw.madlib2_university));
        } else if (receivedint == 4) {
            inputstream = new Story(this.getResources().openRawResource(R.raw.madlib4_dance));
        } else if (receivedint == 5) {
            inputstream = new Story(this.getResources().openRawResource(R.raw.madlib3_clothes));
        } else {
            inputstream = null;
            is = null;
        }


        String hinttext = inputstream.getNextPlaceholder();
        hint.setHint(hinttext);

        counter = inputstream.getPlaceholderCount();
        words.setText(String.valueOf(counter) + " word(s) left");

        String test = inputstream.toString();
        text.setText(test);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String new_word = hint.getText().toString();
                inputstream.fillInPlaceholder(new_word);

                String hinttext = inputstream.getNextPlaceholder();
                hint.setHint(hinttext);
                hint.setText("");

                counter = inputstream.getPlaceholderRemainingCount();
                words.setText(String.valueOf(counter) + " word(s) left");

                String test = inputstream.toString();
                text.setText(test);

                if (counter == 0) {


                    Intent intent = new Intent(this, LastActivity.class);
                    startActivity(intent);
                }
            }
        });
    }





}


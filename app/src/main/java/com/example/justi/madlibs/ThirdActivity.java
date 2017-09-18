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
import java.io.OutputStream;
import java.util.Random;
import com.example.justi.madlibs.Story;


import static com.example.justi.madlibs.R.id.button;
import static com.example.justi.madlibs.R.id.hintje;
import static com.example.justi.madlibs.R.id.storytext;
import static com.example.justi.madlibs.R.id.wordsleft;

public class ThirdActivity extends AppCompatActivity {

    TextView text;
    Story story;
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
            story = new Story(this.getResources().openRawResource(R.raw.madlib0_simple));
        } else if (receivedint == 2) {
            story = new Story(this.getResources().openRawResource(R.raw.madlib1_tarzan));
        } else if (receivedint == 3) {
            story = new Story(this.getResources().openRawResource(R.raw.madlib2_university));
        } else if (receivedint == 4) {
            story = new Story(this.getResources().openRawResource(R.raw.madlib4_dance));
        } else if (receivedint == 5) {
            story = new Story(this.getResources().openRawResource(R.raw.madlib3_clothes));
        } else {
            story = null;
            is = null;
        }


        String hinttext = story.getNextPlaceholder();
        hint.setHint(hinttext);

        counter = story.getPlaceholderCount();
        words.setText(String.valueOf(counter) + " word(s) left");

        String test = story.toString();


        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String new_word = hint.getText().toString();
                new_word.toLowerCase();
                story.fillInPlaceholder(new_word);

                String hinttext = story.getNextPlaceholder();
                hint.setHint(hinttext);
                hint.setText("");

                counter = story.getPlaceholderRemainingCount();
                words.setText(String.valueOf(counter) + " word(s) left");

                String test = story.toString();


                if (counter == 0) {

                    Intent intent = new Intent(ThirdActivity.this, LastActivity.class);
                    intent.putExtra("completestory",test);
                    startActivity(intent);
                    finish();


                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putSerializable("makingstory",story);

        int counter = story.getPlaceholderRemainingCount();
        outState.putInt("counter", counter);

    }
    @Override
    public void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);

        story = (Story)inState.getSerializable("makingstory");

        int madecounter = inState.getInt("counter",0);
        words.setText(String.valueOf(madecounter) + " word(s) left");



    }




}


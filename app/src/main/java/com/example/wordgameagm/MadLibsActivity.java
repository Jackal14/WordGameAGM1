package com.example.wordgameagm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Debug;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MadLibsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_libs);
        Intent intent = getIntent();
        //Get all the data
        gatherData(intent);
    }


    private void gatherData(Intent intent)
    {
        //Arrays of text views and strings to get written text
        TextView[] textViews = {
                findViewById(R.id.adj1),
                findViewById(R.id.adj2),
                findViewById(R.id.no1),
                findViewById(R.id.no2),
                findViewById(R.id.exc1),
                findViewById(R.id.exc2),
                findViewById(R.id.col1),
                findViewById(R.id.col2)
        };
        String[] string = {
                "adjective1",
                "adjective2",
                "noun1",
                "noun2",
                "exclamation1",
                "exclamation2",
                "color1",
                "color2"
        };
        for(int i = 0; i < textViews.length; i++)
        {
            String intentString = string[i];
            string[i] = intent.getStringExtra(intentString);

            //Converts our content into a spannable string that we want to display
            String originContent = string[i];
            SpannableString content = new SpannableString(originContent);

            //Set Colors and underline
            ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#C70000"));
            content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
            content.setSpan(colorSpan, 0, content.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            textViews[i].setText(content);
        }
    }

}
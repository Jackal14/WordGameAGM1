package com.example.wordgameagm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public boolean fieldsEntered = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void startMadLibs(View view) {
        Intent intent = new Intent(this, MadLibsActivity.class);
        //Reset bool everytime we click
        fieldsEntered = true;

        //Collect data from text views
        CollectData(intent);

        //Input validation before starting intent
        if(fieldsEntered)
        {
            startActivity(intent);
        }
    }

    //Function to collect data and put into the intent
    void CollectData(Intent intent)
    {
        //Arrays of edit texts and strings to get written text
        EditText[] editTexts = {
                findViewById(R.id.adjective1),
                findViewById(R.id.adjective2),
                findViewById(R.id.noun1),
                findViewById(R.id.noun2),
                findViewById(R.id.exclamation1),
                findViewById(R.id.exclamation2),
                findViewById(R.id.color1),
                findViewById(R.id.color2)
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

        //For every edit text, get the typed string, if empty throw an error, else, put the string into the intent
        for(int i = 0; i < editTexts.length; i++)
        {
            String intentString = string[i];
            string[i] = editTexts[i].getText().toString();
            if(string[i].isEmpty())
            {
                editTexts[i].setError("Field is required");
                fieldsEntered = false;
            }
            else
            {
                intent.putExtra(intentString, string[i]);
            }
        }
    }
}
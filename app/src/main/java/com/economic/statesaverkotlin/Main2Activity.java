package com.economic.statesaverkotlin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.evernote.android.state.State;
import com.evernote.android.state.StateSaver;

public class Main2Activity extends AppCompatActivity {

    @State
    public String testStateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StateSaver.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_main2);

        if (testStateString == null) {
            Log.d("STATE", "testStateString is null");
            testStateString = "Alive";
        } else {
            Log.d("STATE", "testStateString is " + testStateString);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        StateSaver.saveInstanceState(this, outState);
    }
}

package com.economic.statesaverkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.evernote.android.state.State
import com.evernote.android.state.StateSaver

class MainActivity : AppCompatActivity() {

    @State var testNullableStateString: String? = null

    @State var testNonNullStateString: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StateSaver.restoreInstanceState(this, savedInstanceState)
        setContentView(R.layout.activity_main)


        // Testing nullable test string
        if (testNullableStateString == null) {
            Log.d("STATE", "testNullableStateString is null")
            testNullableStateString = "Alive"
        } else {
            Log.d("STATE", "testNullableStateString is ${testNullableStateString.toString()}")
        }

        // Testing non-null test string
        if (testNonNullStateString.isBlank()) {
            Log.d("STATE", "testNonNullStateString is blank")
            testNonNullStateString = "Alive"
        } else {
            Log.d("STATE", "testNonNullStateString is $testNonNullStateString")
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        StateSaver.saveInstanceState(this, outState ?: Bundle())
    }
}

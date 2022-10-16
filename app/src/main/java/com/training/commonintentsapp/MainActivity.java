package com.training.commonintentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.training.commonintentsapp.alarm.AlarmActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Yoke.MainActivity";

    Button btnAlarmActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG, "@onCreate()");

        btnAlarmActivity = findViewById(R.id.btnAlarmActivity);

        btnAlarmActivity.setOnClickListener(v -> launchAlarmActivity());
    }

    private void launchAlarmActivity() {
        Intent intentAlarmActivity = new Intent(this, AlarmActivity.class);
        startActivity(intentAlarmActivity);
    }
}
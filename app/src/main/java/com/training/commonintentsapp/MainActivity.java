package com.training.commonintentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.training.commonintentsapp.alarm.AlarmActivity;
import com.training.commonintentsapp.calendar.CalendarActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Yoke.MainActivity";

    Button btnAlarmActivity;
    Button btnCalendarActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG, "@onCreate()");

        btnAlarmActivity = findViewById(R.id.btnAlarmActivity);
        btnCalendarActivity = findViewById(R.id.btnCalendarActivity);

        btnAlarmActivity.setOnClickListener(v -> launchAlarmActivity());
        btnCalendarActivity.setOnClickListener(v -> launchCalendarActivity());
    }

    private void launchAlarmActivity() {
        Intent intentAlarmActivity = new Intent(this, AlarmActivity.class);
        startActivity(intentAlarmActivity);
    }

    private void launchCalendarActivity() {
        Intent intentCalendarActivity = new Intent(this, CalendarActivity.class);
        startActivity(intentCalendarActivity);
    }
}
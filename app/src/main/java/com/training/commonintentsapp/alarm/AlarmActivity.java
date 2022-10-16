package com.training.commonintentsapp.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.widget.Button;

import com.training.commonintentsapp.R;

public class AlarmActivity extends AppCompatActivity {

    private static final String TAG = "Yoke.AlarmActivity";

    Button btnCreateAlarm;
    Button btnCreateTimer;
    Button btnShowAlarms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Log.e(TAG, "@onCreate()");

        btnCreateAlarm = findViewById(R.id.btnCreateAlarm);
        btnCreateTimer = findViewById(R.id.btnCreateTimer);
        btnShowAlarms = findViewById(R.id.btnShowAlarms);

        btnCreateAlarm.setOnClickListener(v -> createAlarm());
        btnCreateTimer.setOnClickListener(v -> createTimer());
        btnShowAlarms.setOnClickListener(v -> showAllAlarms());
    }

    private void createAlarm() {
        createAlarm("Test Alarm", 1, 2);
    }

    public void createAlarm(String message, int hour, int minutes) {
        Log.e(TAG, "@createAlarm()");
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void createTimer() {
        startTimer("Test Timer", 30);
    }

    public void startTimer(String message, int seconds) {
        Log.e(TAG, "@startTimer()");
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds);
//                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void showAllAlarms() {
        Log.e(TAG, "@showAllAlarms()");
        Intent intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
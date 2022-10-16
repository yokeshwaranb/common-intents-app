package com.training.commonintentsapp.calendar;

import static android.provider.CalendarContract.EXTRA_EVENT_ALL_DAY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.Button;

import com.training.commonintentsapp.R;

public class CalendarActivity extends AppCompatActivity {

    Button btnAddCalendarEvnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        btnAddCalendarEvnt = findViewById(R.id.btnAddCalendarEvnt);

        btnAddCalendarEvnt.setOnClickListener(v -> createCalendarEvent());
    }

    private void createCalendarEvent() {
        addEvent("Test Event", "Location1", 123, 234);
    }

    //Add Event is not working
    public void addEvent(String title, String location, long begin, long end) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                .putExtra(EXTRA_EVENT_ALL_DAY, true);
//                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
//                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
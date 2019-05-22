package com.assignment.duy.assignmentes;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.TimePicker;
import android.app.Activity;
import android.content.Context;
import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.support.v4.app.FragmentManager;
import android.os.Handler;
import android.os.Message;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.content.Context.ALARM_SERVICE;


public class ExerciseAndDiet extends Fragment /*implements  TimePickerDialog.OnTimeSetListener*/ {

    private static int timeHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    private static int timeMinute = Calendar.getInstance().get(Calendar.MINUTE);
    private static int timeHour2 = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    private static int timeMinute2 = Calendar.getInstance().get(Calendar.MINUTE);
    TextView mTextView,mTextView2;
    Context mContext;
    Button buttonTimePicker, buttonCancelAlarm,buttonTimepicker2,buttonCancelAlarm2;
    public Activity mainActivity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext=context;
        if (context instanceof Activity){
            mainActivity =(Activity) context;
        }
    }




    //AlarmManager alarmManager = (AlarmManager) mainActivity.getSystemService(ALARM_SERVICE);
    //Intent intent = new Intent(mainActivity, ExerciseAndDiet_Broadcast.class);
    //PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 1, intent, 0);
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.exercise_layout, container, false);

        mTextView = view.findViewById(R.id.textView);
        buttonTimePicker = view.findViewById(R.id.button_timepicker);
        buttonTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("time_hour", timeHour);
                bundle.putInt("time_minute", timeMinute);
                DialogFragment timePicker = new TimePickerFragment(new MyHandler());
                timePicker.setArguments(bundle);
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(timePicker, "time_picker");
                transaction.commit();
                //timePicker.show(getActivity().getSupportFragmentManager(), "time picker");

            }
        });

        buttonCancelAlarm = view.findViewById(R.id.button_cancel);
        buttonCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });
        mTextView2 = view.findViewById(R.id.textView2);
        buttonTimepicker2 = view.findViewById(R.id.button_timepicker2);
        buttonTimepicker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("time_hour", timeHour2);
                bundle.putInt("time_minute", timeMinute2);
                DialogFragment timePicker = new TimePickerFragment(new MyHandler2());
                timePicker.setArguments(bundle);
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(timePicker, "time_picker");
                transaction.commit();
                //timePicker.show(getActivity().getSupportFragmentManager(), "time picker");

            }
        });

        buttonCancelAlarm2 = view.findViewById(R.id.button_cancel2);
        buttonCancelAlarm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm2();
            }
        });

        return view;
    }

    //    public void onViewCreated(View view,Bundle savedInstanceState){}
/*    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);

        updateTimeText(c);
        startAlarm(c);
    }*/
    private void updateTimeText(Calendar c) {
        String timeText = "Alarm set for: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        mTextView.setText(timeText);
    }
    private void updateTimeText2(Calendar c) {
        String timeText = "Alarm set for: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        mTextView2.setText(timeText);
    }

    private void startAlarm() {

        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, timeHour);
        c.set(Calendar.MINUTE, timeMinute);
        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }
        updateTimeText(c);

        //alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
    }
    private void startAlarm2() {

        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, timeHour2);
        c.set(Calendar.MINUTE, timeMinute2);
        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }
        updateTimeText2(c);

        //alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
    }

    private void cancelAlarm() {
        /*AlarmManager alarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getActivity(), ExerciseAndDiet_Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, 1, intent, 0);*/

        //alarmManager.cancel(pendingIntent);
        mTextView.setText("Alarm canceled");
    }
    private void cancelAlarm2() {
        /*AlarmManager alarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getActivity(), ExerciseAndDiet_Broadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, 1, intent, 0);*/

        //alarmManager.cancel(pendingIntent);
        mTextView2.setText("Alarm canceled");
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            timeHour = bundle.getInt("time_hour");
            timeMinute = bundle.getInt("time_minute");
            mTextView.setText(timeHour + ":" + timeMinute);
            startAlarm();
        }

    }
    class MyHandler2 extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            timeHour2 = bundle.getInt("time_hour");
            timeMinute2 = bundle.getInt("time_minute");
            mTextView.setText(timeHour2 + ":" + timeMinute2);
            startAlarm2();
        }

    }
}

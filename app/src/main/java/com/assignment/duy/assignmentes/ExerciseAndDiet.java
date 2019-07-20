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
import android.app.TimePickerDialog.OnTimeSetListener;
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

    public static TextView mTextView,mTextView2;
    private Button buttonTimePicker, buttonCancelAlarm,buttonTimepicker2,buttonCancelAlarm2,buttonPrac,buttonSleep,buttonBack;
    public static ExerciseAndDietListener listener;
    public interface ExerciseAndDietListener{
        void startAlarm(Calendar c);
        void cancelAlarm();
        void startAlarm2(Calendar c);
        void cancelAlarm2();
    }


    @Override

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ExerciseAndDietListener) {
            listener = (ExerciseAndDietListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement Exercise Diet Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.exercise_layout, container, false);

        mTextView = view.findViewById(R.id.textView);
        buttonTimePicker = view.findViewById(R.id.button_timepicker);
        buttonPrac=view.findViewById(R.id.button_practice);
        buttonCancelAlarm = view.findViewById(R.id.button_cancel);
        buttonTimepicker2 = view.findViewById(R.id.button_timepicker2);
        buttonCancelAlarm2 = view.findViewById(R.id.button_cancel2);
        buttonSleep=view.findViewById(R.id.button_sleep);
        buttonBack=view.findViewById(R.id.button_back);
        buttonPrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPrac.setVisibility(View.GONE);
                buttonSleep.setVisibility(View.GONE);
                buttonBack.setVisibility(View.VISIBLE);
                buttonTimePicker.setVisibility(View.VISIBLE);
                buttonCancelAlarm.setVisibility(View.VISIBLE);
                mTextView.setVisibility(View.VISIBLE);
                buttonCancelAlarm.setVisibility(View.VISIBLE);

            }
        });
        buttonSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPrac.setVisibility(View.GONE);
                buttonSleep.setVisibility(View.GONE);
                buttonBack.setVisibility(View.VISIBLE);
                buttonTimepicker2.setVisibility(View.VISIBLE);
                buttonCancelAlarm2.setVisibility(View.VISIBLE);
                mTextView2.setVisibility(View.VISIBLE);
                buttonCancelAlarm2.setVisibility(View.VISIBLE);
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPrac.setVisibility(View.VISIBLE);
                buttonSleep.setVisibility(View.VISIBLE);
                buttonTimepicker2.setVisibility(View.INVISIBLE);
                buttonCancelAlarm2.setVisibility(View.INVISIBLE);
                buttonTimePicker.setVisibility(View.INVISIBLE);
                buttonCancelAlarm.setVisibility(View.INVISIBLE);
                buttonBack.setVisibility(View.INVISIBLE);
                mTextView.setVisibility(View.INVISIBLE);
                mTextView2.setVisibility(View.INVISIBLE);
                buttonCancelAlarm.setVisibility(View.INVISIBLE);
                buttonCancelAlarm2.setVisibility(View.INVISIBLE);
            }
        });
        buttonTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getActivity().getSupportFragmentManager(), "time_picker");
            }
        });

        buttonCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.cancelAlarm();
            }
        });

        mTextView2 = view.findViewById(R.id.textView2);
        buttonTimepicker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment2();
                timePicker.show(getActivity().getSupportFragmentManager(), "time picker 2");

            }
        });
        buttonCancelAlarm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.cancelAlarm2();
            }
        });

        return view;
    }


    public static void setAlarm(Calendar c) {
        listener.startAlarm(c);
    }
    public static void setAlarm2(Calendar c) {
        listener.startAlarm2(c);
    }
    public static void updateTimeText(Calendar c) {
        String timeText = "Practice time: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        mTextView.setText(timeText);
    }
    public static void updateTimeText2(Calendar c) {
        String timeText = "Sleep time: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        mTextView2.setText(timeText);
    }

}

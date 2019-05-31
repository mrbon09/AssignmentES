package com.assignment.duy.assignmentes;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TimePicker;
import java.util.Calendar;
import android.os.Handler;
import android.os.Message;



@SuppressLint("ValidFragment")
public class TimePickerFragment extends DialogFragment {
    private int timeHour;
    private int timeMinute;
    private Handler handler;


    public TimePickerFragment(Handler handler){
        this.handler=handler;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle bundle=getArguments();
        timeHour = bundle.getInt("time_hour");
        timeMinute = bundle.getInt("time_minute");
        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                timeHour = hourOfDay;
                timeMinute = minute;
                Bundle b = new Bundle();
                b.putInt("time_hour", timeHour);
                b.putInt("time_minute", timeMinute);
                Message msg = new Message();
                msg.setData(b);
                handler.sendMessage(msg);
            }
        };
        return new TimePickerDialog(getActivity(), listener, timeHour, timeMinute, false);
    }
    /*@NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        TimePickerDialog T = new TimePickerDialog(getActivity(), (TimePickerDialog.OnTimeSetListener) getActivity(), hour, minute, DateFormat.is24HourFormat(getActivity()));
        //TimePickerDialog T=new  TimePickerDialog(getActivity(), this, hour, minute, true);
        return T;
    }*/


}

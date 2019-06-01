package com.assignment.duy.assignmentes;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.v4.app.NotificationCompat;


public class NotificationHelper extends ContextWrapper {
    public static final String channel1ID = "channelID";
    public static final String channel1Name = "Channel Name";
    public static final String channel2ID = "channel2ID";
    public static final String channel2Name = "Channel2 Name";

    private NotificationManager mManager;

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannels();
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannels() {
        NotificationChannel channel = new NotificationChannel(channel1ID, channel1Name, NotificationManager.IMPORTANCE_HIGH);

        NotificationChannel channel2 = new NotificationChannel(channel2ID, channel2Name, NotificationManager.IMPORTANCE_DEFAULT);

        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);
        manager.createNotificationChannel(channel2);

    }

    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return mManager;
    }

    public NotificationCompat.Builder getChannelNotification() {
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID).setContentTitle("Time to Exercise ").setContentText("Try to move around and do some workout").setSmallIcon(R.drawable.exercise);
    }
    public NotificationCompat.Builder getChannelNotification2() {
        return new NotificationCompat.Builder(getApplicationContext(), channel2ID).setContentTitle("Sleep Time ").setContentText("Its late, try to get some rest").setSmallIcon(R.drawable.timer);
    }
}
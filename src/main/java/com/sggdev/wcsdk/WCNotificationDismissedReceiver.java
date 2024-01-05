package com.sggdev.wcsdk;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class WCNotificationDismissedReceiver extends BroadcastReceiver {
    public final static String WC_SKIP = "com.sggdev.wcsdk.ACTION_SKIP";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(WC_SKIP)) {
            WCHTTPResync.restartWCHTTPBackgroundWork(context);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            int notify_id = intent.getIntExtra(WCHTTPResync.EXTRA_NOTIFICATION_ID, WCHTTPResync.notificationId);
            notificationManager.cancel(notify_id);
        }
    }
}
/*
 * Copyright (c) 2015-2017 Uli Bubenheimer. All rights reserved.
 */

package org.bubenheimer.fgsvcbpbug;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public final class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        final NotificationManager notificationManager = getSystemService(NotificationManager.class);
        if (notificationManager == null) {
            throw new AssertionError();
        }
        notificationManager.createNotificationChannel(new NotificationChannel(
                getString(R.string.notification_channel_id), "Standard Notifications",
                NotificationManager.IMPORTANCE_DEFAULT));
    }
}

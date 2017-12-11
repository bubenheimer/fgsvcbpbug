package org.bubenheimer.fgsvcbpbug;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/** The foreground service */
public class FGService extends Service {
    @Override
    public void onCreate() {
        //Put a breakpoint on the next line
        startForeground(12345,
                new Notification.Builder(this, getString(R.string.notification_channel_id))
                        .setSmallIcon(android.R.drawable.stat_notify_sync)
                        .build());
    }

    @Override
    public IBinder onBind(final Intent intent) {
        return null;
    }
}

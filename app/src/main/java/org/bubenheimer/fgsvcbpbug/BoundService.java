package org.bubenheimer.fgsvcbpbug;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Debug;
import android.os.IBinder;

/**
 * Lets us reliably attach a debugger to the right process before starting the foreground service
 */
public class BoundService extends Service {
    private final Binder binder = new Binder();

    @Override
    public void onCreate() {
        //Wait for a debugger to attach
        Debug.waitForDebugger();

        startForegroundService(new Intent(this, FGService.class));
    }

    @Override
    public int onStartCommand(final Intent intent, final int flags, final int startId) {
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(final Intent intent) {
        return binder;
    }
}

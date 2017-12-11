package org.bubenheimer.fgsvcbpbug;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

public final class MainActivity extends Activity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Bind to another service first to let us more reliably attach a debugger to the other process
        bindService(new Intent(this, BoundService.class),
                new ServiceConnection() {
                    @Override
                    public void onServiceConnected(
                            final ComponentName componentName,
                            final IBinder iBinder) {
                    }
                    @Override
                    public void onServiceDisconnected(final ComponentName componentName) {
                    }
                }, BIND_AUTO_CREATE);
    }
}

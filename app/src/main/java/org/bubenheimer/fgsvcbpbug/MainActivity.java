package org.bubenheimer.fgsvcbpbug;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public final class MainActivity extends Activity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Start a background service first to let us reliably attach a debugger to the desired process
        startService(new Intent(this, BGService.class));
    }
}

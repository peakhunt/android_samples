package com.kongjastudio.runtracker;

import android.content.Context;
import android.location.Location;
import android.util.Log;

/**
 * Created by hawk on 14. 7. 24.
 */
public class TrackingLocationReceiver extends LocationReceiver {
    @Override
    protected void onLocationReceived(Context c, Location loc) {
        Log.i("TrackingLocationReceiver", "received location update\n");
        RunManager.get(c).insertLocation(loc);
    }
}

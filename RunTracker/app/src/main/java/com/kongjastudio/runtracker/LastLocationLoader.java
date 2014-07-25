package com.kongjastudio.runtracker;

import android.content.Context;
import android.location.Location;

/**
 * Created by hawk on 14. 7. 25.
 */
public class LastLocationLoader  extends DataLoader<Location> {
    private long mRunId;

    public LastLocationLoader(Context context, long runId) {
        super(context);
        mRunId = runId;
    }

    @Override
    public Location loadInBackground() {
        return RunManager.get(getContext()).getLastLocationForRun(mRunId);
    }
}

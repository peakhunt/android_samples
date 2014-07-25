package com.kongjastudio.runtracker;


import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.AsyncTaskLoader;

/**
 * Created by hawk on 14. 7. 26.
 */
public class LocationListCursorLoader extends AsyncTaskLoader<Cursor> {
    private long mRunId;
    private Cursor mCursor;

    public LocationListCursorLoader(Context context) {
        super(context);
    }

    @Override
    public Cursor loadInBackground() {
        Cursor cursor = loadCursor();

        if(cursor != null) {
            // Ensure that the contetn window is filled
            cursor.getCount();
        }
        return cursor;
    }

    @Override
    public void deliverResult(Cursor data) {
        Cursor oldCursor = mCursor;

        mCursor = data;

        if(isStarted()) {
            super.deliverResult(data);
        }

        if(oldCursor != null && oldCursor != data && !oldCursor.isClosed()) {
            oldCursor.close();
        }
    }

    @Override
    protected void onStartLoading() {
        if(mCursor != null) {
            deliverResult(mCursor);
        }

        if(takeContentChanged() || mCursor == null) {
            forceLoad();
        }
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    public void onCanceled(Cursor cursor) {
        if(cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();

        if(mCursor != null && !mCursor.isClosed()) {
            mCursor.close();
        }
        mCursor = null;
    }

    public LocationListCursorLoader(Context c, long runId) {
       super(c);
        mRunId = runId;
    }

    protected Cursor loadCursor() {
        return RunManager.get(getContext()).queryLocationsForRun(mRunId);
    }
}

package com.kongjastudio.runtracker;

import android.content.AsyncTaskLoader;
import android.content.Context;

/**
 * Created by hawk on 14. 7. 25.
 */
public abstract class DataLoader<D> extends AsyncTaskLoader<D> {
    private D mData;

    public DataLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        if(mData != null) {
            deliverResult(mData);
        } else {
            forceLoad();
        }
    }

    @Override
    public void deliverResult(D data) {
        mData = data;
        if(isStarted())
            super.deliverResult(data);
    }
}

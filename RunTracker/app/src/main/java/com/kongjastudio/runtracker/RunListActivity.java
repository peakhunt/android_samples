package com.kongjastudio.runtracker;

import android.app.Fragment;

/**
 * Created by ctrl on 14. 7. 25.
 */
public class RunListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new RunListFragment();
    }
}

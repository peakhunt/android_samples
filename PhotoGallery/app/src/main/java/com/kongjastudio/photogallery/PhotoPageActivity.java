package com.kongjastudio.photogallery;

import android.app.Fragment;

/**
 * Created by hawk on 14. 7. 22.
 */
public class PhotoPageActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return new PhotoPageFragment();
    }
}

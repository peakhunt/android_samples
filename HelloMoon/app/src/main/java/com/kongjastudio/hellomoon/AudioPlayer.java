package com.kongjastudio.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by hawk on 14. 6. 29.
 */
public class AudioPlayer {
    private MediaPlayer mPlayer = null;

    public void stop() {
        if(mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c) {
        stop();

        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });

        mPlayer.start();
    }
}

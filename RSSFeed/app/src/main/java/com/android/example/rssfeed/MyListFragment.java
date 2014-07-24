package com.android.example.rssfeed;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ctrl on 14. 7. 9.
 */
public class MyListFragment extends Fragment {
    private OnItemSelectedListener  listener;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rsslist_overview, container, false);

        Button  button = (Button)view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener)activity;
        } else {
            throw new ClassCastException(activity.toString() +
                    " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    public void updateDetail() {
        String newTime = String.valueOf(System.currentTimeMillis());

        listener.onRssItemSelected(newTime);
    }

    public interface OnItemSelectedListener {
        public void onRssItemSelected(String link);
    }
}

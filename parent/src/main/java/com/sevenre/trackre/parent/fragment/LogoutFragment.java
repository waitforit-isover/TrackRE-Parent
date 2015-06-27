package com.sevenre.trackre.parent.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sevenre.trackre.parent.R;


public class LogoutFragment extends Fragment {

    public static LogoutFragment newInstance() {
        LogoutFragment fragment = new LogoutFragment();
        return fragment;
    }

    public LogoutFragment() {    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_logout, container, false);
    }
}

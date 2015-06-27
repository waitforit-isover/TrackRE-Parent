package com.sevenre.trackre.parent.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sevenre.trackre.parent.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildrenFragment extends Fragment {

    public static ChildrenFragment newInstance() {
        ChildrenFragment fragment = new ChildrenFragment();
        return fragment;
    }

    public ChildrenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_children, container, false);
    }


}

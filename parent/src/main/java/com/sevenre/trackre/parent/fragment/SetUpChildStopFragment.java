package com.sevenre.trackre.parent.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sevenre.trackre.parent.R;
import com.sevenre.trackre.parent.adapter.SetUpChildStopAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetUpChildStopFragment extends Fragment {

    View view;
    ListView mListView;

    public SetUpChildStopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_set_up_child_stop, container, false);
        mListView = (ListView) view.findViewById(R.id.list_view_set_up_child_stop);
        mListView.setAdapter(new SetUpChildStopAdapter(getActivity()));
        return view;
    }


}

package com.sevenre.trackre.parent.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sevenre.trackre.parent.R;
import com.daimajia.swipe.SwipeLayout;
/**
 * A simple {@link Fragment} subclass.
 */
public class TrackingFragment extends Fragment {

    public static TrackingFragment newInstance() {
        return new TrackingFragment();
    }

    public TrackingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] listItems = {"item 1", "item 2 ", "list", "android", "item 3", "foobar", "bar", };
        View view = inflater.inflate(R.layout.fragment_tracking, container, false);
        //listView.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, listItems));



        return view;
    }


}

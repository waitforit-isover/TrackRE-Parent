package com.sevenre.trackre.parent.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.sevenre.trackre.parent.R;
import com.sevenre.trackre.parent.adapter.ChildrenAdapter;
public class ChildrenFragment extends Fragment {

    public static ChildrenFragment newInstance() {
        ChildrenFragment fragment = new ChildrenFragment();
        return fragment;
    }

    public ChildrenFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_children, container, false);
        ListView listView = (ListView) view.findViewById(R.id.list_view_children);
        listView.setAdapter(new ChildrenAdapter(getActivity()));
        return view;
    }
}

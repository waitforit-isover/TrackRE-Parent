package com.sevenre.trackre.parent.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.rey.material.widget.Spinner;

import com.sevenre.trackre.parent.R;
import com.sevenre.trackre.parent.activity.MainActivity;
import com.sevenre.trackre.parent.adapter.ListSwipeAdapter;
import com.sevenre.trackre.parent.adapter.StopRouteAdapter;
import com.sevenre.trackre.parent.datatypes.Stop;
import com.sevenre.trackre.parent.utils.Constants;

import java.util.ArrayList;

public class ExploreRoutesFragment extends Fragment {

    Spinner stop, route;
    ListView stops;
    String schoolId;
    boolean isAuthentic = true;

    public ExploreRoutesFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isAuthentic = this.getArguments().getBoolean(Constants.ISAUTHENTIC, true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore_routes, container, false);
        if (!isAuthentic) {
            view.setBackgroundColor(getResources().getColor(R.color.background_login_fragment));
        }
        stop = (Spinner)view.findViewById(R.id.spinner_stop_name);
        route = (Spinner)view.findViewById(R.id.spinner_route);
        stops = (ListView)view.findViewById(R.id.list_view_route);

        String[] items = new String[20];
        for(int i = 0; i < items.length; i++)
            items[i] = "Item " + String.valueOf(i + 1);

        items[0] = "New City Center";

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.row_spinner, items);
        adapter.setDropDownViewResource(R.layout.row_spinner_dropdown);
        stop.setAdapter(adapter);
        route.setAdapter(adapter);

        ArrayList<Stop> data = new ArrayList<>();

        for (int i = 0; i < 19;i++) {
            Stop s = new Stop();
            s.setTime("09:23 AM");
            s.setName("Stop " + i);
            data.add(s);
        }

        StopRouteAdapter stopsAdapter = new StopRouteAdapter(getActivity(),data);
        stops.setAdapter(new StopRouteAdapter(getActivity(),data));

        return view;
    }
}

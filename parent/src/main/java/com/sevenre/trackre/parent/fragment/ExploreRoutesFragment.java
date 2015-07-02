package com.sevenre.trackre.parent.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.rey.material.widget.Spinner;

import com.sevenre.trackre.parent.R;
import com.sevenre.trackre.parent.adapter.StopRouteAdapter;
import com.sevenre.trackre.parent.datatypes.Stop;
import com.sevenre.trackre.parent.utils.Constants;
import com.software.shell.fab.ActionButton;

import java.util.ArrayList;

public class ExploreRoutesFragment extends Fragment {

    Spinner stop, route;
    ListView stopList;
    String schoolId;
    boolean isAuthentic = true;
    View view;
    ActionButton favourite;

    public ExploreRoutesFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            isAuthentic = this.getArguments().getBoolean(Constants.ISAUTHENTIC, true);
        } catch (Exception e) {}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_explore_routes, container, false);
        if (!isAuthentic) {
            view.setBackgroundColor(getResources().getColor(R.color.background_login_fragment));
        }
        stop = (Spinner)view.findViewById(R.id.spinner_stop_name);
        route = (Spinner)view.findViewById(R.id.spinner_route);
        stopList = (ListView)view.findViewById(R.id.list_view_route);
        favourite = (ActionButton) view.findViewById(R.id.action_button_fav);
        favourite.setButtonColor(getResources().getColor(R.color.fab_material_lime_500));
        favourite.setButtonColorPressed(getResources().getColor(R.color.fab_material_lime_900));
        favourite.setImageResource(R.drawable.fav_star);

        stop.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(Spinner spinner, View view, int i, long l) {
                if (i!=0) {
                    ExploreRoutesFragment.this.view.findViewById(R.id.spinner_route).setVisibility(View.VISIBLE);
                    if (isAuthentic) {
                        favourite.playShowAnimation();
                        favourite.setVisibility(View.VISIBLE);
                    }
                } else {
                    route.setVisibility(View.GONE);
                    stopList.setVisibility(View.GONE);
                    favourite.playHideAnimation();
                    favourite.setVisibility(View.GONE);
                }
            }
        });

        route.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(Spinner spinner, View view, int i, long l) {
                if (i!=0) {
                    stopList.setVisibility(View.VISIBLE);
                } else {
                    stopList.setVisibility(View.GONE);
                }
            }
        });


        String[] items = new String[20];
        for(int i = 0; i < items.length; i++)
            items[i] = "Item " + String.valueOf(i + 1);

        items[0] = "No Selection";

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
        stopList.setAdapter(new StopRouteAdapter(getActivity(), data));
        stopList.setDividerHeight(0);

        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Fav this stop?", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}

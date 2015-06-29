package com.sevenre.trackre.parent.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sevenre.trackre.parent.R;
import com.sevenre.trackre.parent.datatypes.Stop;

import java.util.ArrayList;

public class StopRouteAdapter extends BaseAdapter {

	private ArrayList<Stop> data;
	int i = 0;
	Context mContext;

	public StopRouteAdapter(Context context, ArrayList<Stop> d) {
		data = new ArrayList<Stop>();
		mContext = context;
		this.data = d;
//        Stop ss = new Stop();
//        ss.setName("My Name");
//        ss.setTime("04:33 AM");
//        data.add(ss);
//        data.add(ss);
//        data.add(ss);
//        data.add(ss);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = LayoutInflater.from(mContext).inflate(R.layout.list_item_route_stop, null);

		if (position == 0) {
			vi.findViewById(R.id.route_line_top).setBackgroundColor(Color.TRANSPARENT);
		}

		if (position == data.size()-1) {
			vi.findViewById(R.id.route_line_bottom).setBackgroundColor(Color.TRANSPARENT);;
		}


		TextView time = (TextView) vi.findViewById(R.id.active_trip_next_stop_time);
		TextView name = (TextView) vi.findViewById(R.id.active_trip_next_stop_name);

        Stop t = (Stop) data.get(position);
		time.setText(t.getTime());
		name.setText(t.getName());

        //time.setText("08:23 AM");
        //name.setText("Stop Name");
		return vi;
	}
	
	@Override
	public int getCount() { return data.size(); }

	@Override
	public Object getItem(int position) {
		return (position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	
}
package com.sevenre.trackre.parent.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rey.material.widget.Spinner;
import com.sevenre.trackre.parent.R;
import com.sevenre.trackre.parent.activity.CropImageActivity;
import com.sevenre.trackre.parent.datatypes.Child;
import com.sevenre.trackre.parent.datatypes.ChildStopSelection;
import com.sevenre.trackre.parent.datatypes.Stop;
import com.sevenre.trackre.parent.datatypes.Trip;
import com.sevenre.trackre.parent.utils.Constants;
import com.sevenre.trackre.parent.utils.ImageConvert;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SetUpChildStopAdapter extends BaseAdapter {

    List<ChildStopSelection> selections = new ArrayList<>();
    Context mContext;
    List<Stop> stops;
    List<Trip> trips;

    public SetUpChildStopAdapter(Context context) {
        mContext = context;
        stops = new ArrayList<>();
        stops.add(new Stop("Mayur Vihar","2"));
        stops.add(new Stop("Vasant Kunj","3"));
        stops.add(new Stop("Faridabaad","4"));
        stops.add(new Stop("Noida city centre","5"));

        trips = new ArrayList<>();
        trips.add(new Trip("1", "AB 23"));
        trips.add(new Trip("2", "B 43"));
        trips.add(new Trip("3", "CF 243"));
        trips.add(new Trip("4", "AFC 48"));

        selections.add(new ChildStopSelection(
                new Child("1","Ted", "Mosby","DPS, Delhi"),
                "1","Mayur Kunj","2","AB 45",1,stops, trips));

        selections.add(new ChildStopSelection(
                new Child("1","Ted", "Mosby","DPS, Delhi"),
                "1","Mayur Kunj","2","AB 45",2,stops, trips));

        selections.add(new ChildStopSelection(
                new Child("2","Marshal", "Ericsson","NYC High School"),
                "1","Mayur Kunj","2","AB 45",1,stops, trips));

        selections.add(new ChildStopSelection(
                new Child("2","Marshal", "Ericsson","NYC High School"),
                "1","Mayur Kunj","2","AB 45",2,stops, trips));

    }

    @Override
    public int getCount() {
        return selections.size();
    }

    @Override
    public Object getItem(int position) {
        return selections.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_child_stop_set_up, null);
        final Spinner route = (Spinner)view.findViewById(R.id.child_spinner_stop_route);
        TextView name = (TextView)view.findViewById(R.id.child_name);
        final Spinner stop = (Spinner)view.findViewById(R.id.child_spinner_stop_name);

        name.setText(selections.get(position).getChildName());
        if (selections.get(position).getTripType()== Constants.PICKUP)
            ((TextView)view.findViewById(R.id.child_trip_type)).setText("Pick Up");

        //Child Photo
        {
            ImageView photo = (ImageView)view.findViewById(R.id.child_image);
            try {
                File f = new File(Environment.getExternalStorageDirectory() + File.separator + selections.get(position).getChildId() + "sevenre.jpg" );
                if (f.exists()) {
                    Bitmap muteBitmap = BitmapFactory.decodeFile(f.getAbsolutePath());
                    Bitmap bitmap = muteBitmap.copy(Bitmap.Config.ARGB_8888, true);
                    int w = muteBitmap.getWidth();
                    Bitmap roundBitmap = ImageConvert.getRoundedCroppedBitmap(bitmap, w);
                    Canvas canvas = new Canvas(roundBitmap);
                    canvas.drawBitmap(roundBitmap, 0, 0, null);
                    photo.setImageBitmap(roundBitmap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            photo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, CropImageActivity.class);
                    intent.putExtra("ChildId", selections.get(position).getChildId());
                    mContext.startActivity(intent);
                }
            });
        }

        //Stop Name
        {
            String[] items = new String[stops.size()+1];
            items[0] = "No Selection";
            for(int i = 1; i <= stops.size(); i++)
                items[i] = stops.get(i-1).getName();

            ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, R.layout.row_spinner, items);
            adapter.setDropDownViewResource(R.layout.row_spinner_dropdown);
            stop.setAdapter(adapter);
        }

        //Route Name
        {
            String[] items = new String[trips.size()];
            items[0] = "No Selection";
            for(int i = 1; i < trips.size(); i++)
                items[i] = trips.get(i-1).getName();

            ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, R.layout.row_spinner, items);
            adapter.setDropDownViewResource(R.layout.row_spinner_dropdown);
            route.setAdapter(adapter);
        }

        // Action button and valadition
        ImageButton button = (ImageButton)view.findViewById(R.id.action_button_check);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stop.getSelectedItemPosition()==0 ||route.getSelectedItemPosition()==0) {
                    Toast.makeText(mContext,"Stop or route not selected", Toast.LENGTH_SHORT).show();
                } else {
                    selections.remove(position);
                    notifyDataSetChanged();
                }
            }
        });

        return view;
    }
}

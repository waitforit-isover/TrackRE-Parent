package com.sevenre.trackre.parent.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.sevenre.trackre.parent.R;
import com.sevenre.trackre.parent.datatypes.Child;
import com.sevenre.trackre.parent.views.animation.DropDownAnim;

import java.util.ArrayList;
import java.util.List;

public class ChildrenAdapter extends BaseAdapter {

    List<Child> data;
    Context mContext;
    LayoutInflater inflater;

    public ChildrenAdapter() {
        data = new ArrayList<>();
        data.add(new Child("Ted", "Mosby","DPS, Delhi"));
        data.add(new Child("Marshal", "Ericsson","NYC High School"));
    }

    public ChildrenAdapter(Context context) {
        data = new ArrayList<>();
        data.add(new Child("Ted", "Mosby","DPS, Delhi"));
        data.add(new Child("Marshal", "Ericson","NYC High School"));
        mContext = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_child,null);
        TextView name = (TextView)view.findViewById(R.id.child_name);
        TextView school = (TextView) view.findViewById(R.id.child_school);
        name.setText(data.get(position).getFirstName() + " " + data.get(position).getLastName());
        school.setText(data.get(position).getSchool());
        //hideDetails(view.findViewById(R.id.list_item_detail_view));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.get(position).isDetailView()) {
                    hideDetails(view.findViewById(R.id.list_item_detail_view));
                    data.get(position).setIsDetailView(false);
                } else {
                    showDetails(view.findViewById(R.id.list_item_detail_view));
                    data.get(position).setIsDetailView(true);
                }

            }
        });
        return view;
    }

    void showDetails (View view) {
        TranslateAnimation animate = new TranslateAnimation(0,0,0,view.getHeight());
        animate.setDuration(500);
        DropDownAnim anim = new DropDownAnim(view, view.getHeight(),true);
        view.startAnimation(animate);
        view.setVisibility(View.VISIBLE);
    }

    void hideDetails (View view) {
        TranslateAnimation animate = new TranslateAnimation(0,0,0,-view.getHeight());
        animate.setDuration(500);
        DropDownAnim anim = new DropDownAnim(view, view.getHeight(),true);
        view.startAnimation(animate);
        view.setVisibility(View.GONE);
    }
}

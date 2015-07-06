package com.sevenre.trackre.parent.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sevenre.trackre.parent.R;
import com.sevenre.trackre.parent.activity.CropImageActivity;
import com.sevenre.trackre.parent.datatypes.Child;
import com.sevenre.trackre.parent.utils.ImageConvert;
import com.sevenre.trackre.parent.utils.Intents;
import com.sevenre.trackre.parent.views.animation.DropDownAnim;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ChildrenAdapter extends BaseAdapter {

    List<Child> data;
    Context mContext;
    LayoutInflater inflater;

    private static int REQUEST_PICTURE = 1;
    private static int REQUEST_CROP_PICTURE = 2;

    public ChildrenAdapter() {
        data = new ArrayList<>();
        data.add(new Child("1","Ted", "Mosby","DPS, Delhi"));
        data.add(new Child("2","Marshal", "Ericsson","NYC High School"));
    }

    public ChildrenAdapter(Context context) {
        data = new ArrayList<>();
        data.add(new Child("1","Ted", "Mosby","DPS, Delhi"));
        data.add(new Child("2","Marshal", "Ericsson","NYC High School"));
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

        ImageView photo = (ImageView)view.findViewById(R.id.child_image);
        try {
            File f = new File(Environment.getExternalStorageDirectory() + File.separator + data.get(position).getId() + "sevenre.jpg" );
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
                intent.putExtra("ChildId", data.get(position).getId());
                mContext.startActivity(intent);
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

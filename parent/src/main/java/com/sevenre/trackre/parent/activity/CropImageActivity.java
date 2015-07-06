package com.sevenre.trackre.parent.activity;

import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.sevenre.trackre.parent.R;

public class CropImageActivity extends ActionBarActivity {

    String childId;

    // Static final constants
    private static final int DEFAULT_ASPECT_RATIO_VALUES = 20;
    private static final int ROTATE_NINETY_DEGREES = 90;
    private static final String ASPECT_RATIO_X = "ASPECT_RATIO_X";
    private static final String ASPECT_RATIO_Y = "ASPECT_RATIO_Y";
    private static final int ON_TOUCH = 1;

    // Instance variables
    private int mAspectRatioX = DEFAULT_ASPECT_RATIO_VALUES;
    private int mAspectRatioY = DEFAULT_ASPECT_RATIO_VALUES;

    Bitmap croppedImage;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivityForResult(getPickImageChooserIntent(), 200);
        setContentView(R.layout.activity_crop_image);
        try {
            childId = getIntent().getStringExtra("ChildId");
        } catch (Exception e) {}

        // Initialize components of the app
        final CropImageView cropImageView = (CropImageView) findViewById(R.id.CropImageView);

        //Crop Image parameters
        cropImageView.setFixedAspectRatio(true);
        cropImageView.setAspectRatio(DEFAULT_ASPECT_RATIO_VALUES, DEFAULT_ASPECT_RATIO_VALUES);
        cropImageView.setCropShape(CropImageView.CropShape.RECTANGLE);

        //Sets the rotate button
        final Button rotateButton = (Button) findViewById(R.id.Button_rotate);
        rotateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cropImageView.rotateImage(ROTATE_NINETY_DEGREES);
            }
        });

        findViewById(R.id.Button_crop).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                croppedImage = cropImageView.getCroppedImage();
                try {
                    File f = new File(Environment.getExternalStorageDirectory() + File.separator + childId +  "sevenre.jpg");
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    croppedImage.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byte[] byteArray = stream.toByteArray();
                    f.createNewFile();
                    FileOutputStream fo = new FileOutputStream(f);
                    fo.write(byteArray);
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });

        findViewById(R.id.Button_load).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivityForResult(getPickImageChooserIntent(), 200);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            Uri imageUri = getPickImageResultUri(data);
            ((CropImageView) findViewById(R.id.CropImageView)).setImageUri(imageUri);
        }
    }

    public Intent getPickImageChooserIntent() {

        // Determine Uri of camera image to save.
        Uri outputFileUri = getCaptureImageOutputUri();

        List<Intent> allIntents = new ArrayList<>();
        PackageManager packageManager = getPackageManager();

        // collect all camera intents
        Intent captureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        List<ResolveInfo> listCam = packageManager.queryIntentActivities(captureIntent, 0);
        for (ResolveInfo res : listCam) {
            Intent intent = new Intent(captureIntent);
            intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            intent.setPackage(res.activityInfo.packageName);
            if (outputFileUri != null) {
                intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
            }
            allIntents.add(intent);
        }

        // collect all gallery intents
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        List<ResolveInfo> listGallery = packageManager.queryIntentActivities(galleryIntent, 0);
        for (ResolveInfo res : listGallery) {
            Intent intent = new Intent(galleryIntent);
            intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            intent.setPackage(res.activityInfo.packageName);
            allIntents.add(intent);
        }

        // the main intent is the last in the list (fucking android) so pickup the useless one
        Intent mainIntent = allIntents.get(allIntents.size() - 1);
        for (Intent intent : allIntents) {
            if (intent.getComponent().getClassName().equals("com.android.documentsui.DocumentsActivity")) {
                mainIntent = intent;
                break;
            }
        }
        allIntents.remove(mainIntent);

        // Create a chooser from the main intent
        Intent chooserIntent = Intent.createChooser(mainIntent, "Select source");

        // Add all other intents
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, allIntents.toArray(new Parcelable[allIntents.size()]));

        return chooserIntent;
    }

    private Uri getCaptureImageOutputUri() {
        Uri outputFileUri = null;
        File getImage = getExternalCacheDir();
        if (getImage != null) {
            outputFileUri = Uri.fromFile(new File(getImage.getPath(), "pickImageResult.jpeg"));
        }
        return outputFileUri;
    }

    public Uri getPickImageResultUri(Intent data) {
        boolean isCamera = true;
        if (data != null) {
            String action = data.getAction();
            isCamera = action != null && action.equals(MediaStore.ACTION_IMAGE_CAPTURE);
        }
        return isCamera ? getCaptureImageOutputUri() : data.getData();
    }

    @Override
    protected void onSaveInstanceState(@SuppressWarnings("NullableProblems") Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(ASPECT_RATIO_X, mAspectRatioX);
        bundle.putInt(ASPECT_RATIO_Y, mAspectRatioY);
    }

    @Override
    protected void onRestoreInstanceState(@SuppressWarnings("NullableProblems") Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        mAspectRatioX = bundle.getInt(ASPECT_RATIO_X);
        mAspectRatioY = bundle.getInt(ASPECT_RATIO_Y);
    }
}
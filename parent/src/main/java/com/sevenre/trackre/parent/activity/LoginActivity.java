package com.sevenre.trackre.parent.activity;

import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.rey.material.widget.SnackBar;
import com.sevenre.trackre.parent.R;
import com.sevenre.trackre.parent.fragment.LoginFragment;

import java.io.IOException;

public class LoginActivity extends ActionBarActivity {

    private SnackBar mSnackBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginFragment fragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.login_fragment_container,fragment).commit();
        mSnackBar = (SnackBar)findViewById(R.id.login_snackbar);
//        TextView tv = (TextView)findViewById(R.id.textView4);
//        tv.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto.ttf"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new ID().execute();
    }

    class ID extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String token = "null";
            try {
                Looper.prepare();
                InstanceID instanceID = InstanceID.getInstance(LoginActivity.this);
                token = instanceID.getToken("777450129634", GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Log.i("Raj", "Login Activity + " + token);
            Toast.makeText(getApplicationContext(),token,Toast.LENGTH_LONG).show();
            return token;
        }
    }
    public SnackBar getSnackBar(){
        return mSnackBar;
    }
}

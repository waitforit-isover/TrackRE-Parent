package com.sevenre.trackre.parent.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.rey.material.widget.SnackBar;
import com.sevenre.trackre.parent.R;
import com.sevenre.trackre.parent.activity.MainActivity;
import com.sevenre.trackre.parent.datatypes.ServerResult;
import com.sevenre.trackre.parent.utils.Server;

public class LoginFragment extends Fragment implements View.OnClickListener{

    EditText mobile_no, password;
    SnackBar mSnackBar;
    TextView tv;
    ProgressDialog progressDialog;
    View view;

    public LoginFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        mobile_no = (EditText)view.findViewById(R.id.login_phone);
        password = (EditText)view.findViewById(R.id.login_password);
        progressDialog = new ProgressDialog(getActivity());

        view.findViewById(R.id.login_forget_password).setOnClickListener(this);
        view.findViewById(R.id.login_register).setOnClickListener(this);
        view.findViewById(R.id.login_simply_track).setOnClickListener(this);
        view.findViewById(R.id.login_login).setOnClickListener(this);

        mSnackBar = (SnackBar)getActivity().findViewById(R.id.login_snackbar);
        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        switch (v.getId()) {
            case R.id.login_login:
                if(progressDialog.isShowing())
                    progressDialog.dismiss();
                progressDialog.setMessage("Authenticating user");
                progressDialog.show();
                String id = ((TextView)view.findViewById(R.id.login_phone)).getText().toString();
                String password = ((TextView)view.findViewById(R.id.login_password)).getText().toString();
                new Login().execute(id,password);
                break;
            case R.id.login_register:
                fragment = new Register1Fragment();
                this.getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,R.anim.enter_from_left, R.anim.exit_to_right)
                        .replace(R.id.login_fragment_container,fragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.login_forget_password:
                if(mSnackBar.getState() == SnackBar.STATE_SHOWN)
                    mSnackBar.dismiss();
                mSnackBar.applyStyle(R.style.AppTheme_SnackBarSingleLine).text("LOL! You forgot password").show();
                break;
            case R.id.login_simply_track:
                fragment = new SimplyTrackVerificationFragment();
                this.getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,R.anim.enter_from_left, R.anim.exit_to_right)
                        .replace(R.id.login_fragment_container,fragment)
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }

    class Login extends AsyncTask<String, Integer, ServerResult> {

        @Override
        protected ServerResult doInBackground(String... params) {
            return Server.isAuthenticUser(params[0],params[1]);
        }

        @Override
        protected void onPostExecute(ServerResult login) {
            super.onPostExecute(login);
            if(progressDialog.isShowing())
                progressDialog.dismiss();

            if (login.isAuthentic()) {
                LoginFragment.this.startActivity(new Intent(getActivity(), MainActivity.class));
                LoginFragment.this.getActivity().finish();
            } else {
                mSnackBar.applyStyle(R.style.AppTheme_SnackBarSingleLine).text(R.string.login_wrong_password).show();
            }
        }
    }
}
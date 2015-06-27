package com.sevenre.trackre.parent.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rey.material.widget.SnackBar;
import com.sevenre.trackre.parent.R;
import com.sevenre.trackre.parent.activity.LoginActivity;
import com.sevenre.trackre.parent.activity.MainActivity;
import com.sevenre.trackre.parent.fragment.Register1Fragment;

public class LoginFragment extends Fragment implements View.OnClickListener{

    EditText mobile_no, password;
    SnackBar mSnackBar;

    public LoginFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        mobile_no = (EditText)view.findViewById(R.id.login_phone);
        password = (EditText)view.findViewById(R.id.login_password);

        view.findViewById(R.id.login_forget_password).setOnClickListener(this);
        view.findViewById(R.id.login_register).setOnClickListener(this);
        view.findViewById(R.id.login_simply_track).setOnClickListener(this);
        view.findViewById(R.id.login_login).setOnClickListener(this);
        mSnackBar = ((LoginActivity)getActivity()).getSnackBar();

        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        switch (v.getId()) {
            case R.id.login_login:
                this.startActivity(new Intent(getActivity(),MainActivity.class));
                this.getActivity().finish();
                break;
            case R.id.login_register:
                fragment = new Register1Fragment();
                this.getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
                        .replace(R.id.login_fragment_container,fragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.login_forget_password:
                if(mSnackBar.getState() == SnackBar.STATE_SHOWN)
                    mSnackBar.dismiss();
                mSnackBar.applyStyle(R.style.AppTheme_SnackBarSingleLine).text("LOL! You forget password").show();
                Toast.makeText(getActivity(),"huh",Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_simply_track:
                if(mSnackBar.getState() == SnackBar.STATE_SHOWN)
                    mSnackBar.dismiss();
                mSnackBar.applyStyle(R.style.AppTheme_SnackBarSingleLine).text("LOL! You forget password").show();
                fragment = new SimplyTrackVerificationFragment();
                this.getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
                        .replace(R.id.login_fragment_container,fragment)
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
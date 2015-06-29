package com.sevenre.trackre.parent.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sevenre.trackre.parent.R;

public class Register1Fragment extends Fragment implements View.OnClickListener{

    public static Register1Fragment newInstance(String param1, String param2) {
        Register1Fragment fragment = new Register1Fragment();
        return fragment;
    }

    public Register1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register1, container, false);
        view.findViewById(R.id.login_continue).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_continue:
                Register2Fragment fragment = new Register2Fragment();
                this.getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)//,R.anim.enter_from_left, R.anim.exit_to_right)
                        .replace(R.id.login_fragment_container, fragment)
                        .addToBackStack(null)
                        .commit();
        }
    }
}

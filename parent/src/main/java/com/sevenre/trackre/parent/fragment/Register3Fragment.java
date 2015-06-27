package com.sevenre.trackre.parent.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sevenre.trackre.parent.R;
import com.sevenre.trackre.parent.activity.MainActivity;
//import com.sevenre.trackre.parent.backend.GcmRegistrationAsyncTask;

public class Register3Fragment extends Fragment implements View.OnClickListener{

    public static Register3Fragment newInstance(String param1, String param2) {
        Register3Fragment fragment = new Register3Fragment();
        return fragment;
    }

    public Register3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register3, container, false);
        view.findViewById(R.id.login_continue).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_continue:
                //new GcmRegistrationAsyncTask(getActivity()).execute();
                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
        }
    }


}

package com.sevenre.trackre.parent.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sevenre.trackre.parent.R;
import com.sevenre.trackre.parent.utils.Constants;

public class SimplyTrackVerificationFragment extends Fragment {

    public SimplyTrackVerificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_simply_track_verification, container, false);
        view.findViewById(R.id.login_continue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExploreRoutesFragment fragment = new ExploreRoutesFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(Constants.ISAUTHENTIC,false);
                bundle.putString(Constants.SCHOOLID,"schoold ididdi");
                fragment.setArguments(bundle);
                SimplyTrackVerificationFragment.this.getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,R.anim.enter_from_left, R.anim.exit_to_right)
                        .replace(R.id.login_fragment_container,fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }


}

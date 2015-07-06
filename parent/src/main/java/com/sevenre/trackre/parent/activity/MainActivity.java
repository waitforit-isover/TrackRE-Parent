package com.sevenre.trackre.parent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blunderer.materialdesignlibrary.models.Account;
import com.blunderer.materialdesignlibrary.handlers.ActionBarDefaultHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerAccountsHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerAccountsMenuHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerBottomHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerTopHandler;
import com.joanzapata.android.iconify.Iconify;
import com.rey.material.widget.SnackBar;
import com.sevenre.trackre.parent.fragment.AddMobileFragment;
import com.sevenre.trackre.parent.fragment.ExploreRoutesFragment;
import com.sevenre.trackre.parent.fragment.HomeFragment;
import com.sevenre.trackre.parent.fragment.LogoutFragment;
import com.sevenre.trackre.parent.fragment.NotificationFragment;
import com.sevenre.trackre.parent.fragment.SetUpChildStopFragment;
import com.sevenre.trackre.parent.fragment.SimplyTrackVerificationFragment;

import com.sevenre.trackre.parent.R;

public class MainActivity extends com.blunderer.materialdesignlibrary.activities.NavigationDrawerActivity {

    private SnackBar mSnackBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public NavigationDrawerAccountsHandler getNavigationDrawerAccountsHandler() {
        return new NavigationDrawerAccountsHandler(this)
                .addAccount("Raj Shah", "90254 74327",
                        R.drawable.profile1, R.drawable.profile1_background);
    }

    @Override
    public NavigationDrawerAccountsMenuHandler getNavigationDrawerAccountsMenuHandler() {
        return null;
    }

    @Override
    public void onNavigationDrawerAccountChange(Account account) {

    }

    @Override
    public NavigationDrawerTopHandler getNavigationDrawerTopHandler() {

        return new NavigationDrawerTopHandler(this)
                .addItem(R.string.home, Iconify.IconValue.fa_home, new HomeFragment())
                .addItem(R.string.notification, Iconify.IconValue.fa_bell_o, new NotificationFragment())
                .addItem(R.string.routes, Iconify.IconValue.fa_road, new ExploreRoutesFragment())
                .addItem(R.string.simply_track, Iconify.IconValue.fa_map_marker,new SimplyTrackVerificationFragment())
                .addItem("Set Up", new SetUpChildStopFragment())
                .addItem(R.string.add_phone_no, Iconify.IconValue.fa_phone, new AddMobileFragment())
                .addItem(R.string.logout, Iconify.IconValue.fa_unlock, new LogoutFragment());

    }

    @Override
    public NavigationDrawerBottomHandler getNavigationDrawerBottomHandler() {
        return new NavigationDrawerBottomHandler(this)
                .addSettings(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                    }
                });
    }

    @Override
    public boolean overlayActionBar() {
        return true;
    }

    @Override
    public boolean replaceActionBarTitleByNavigationDrawerItemTitle() {
        return true;
    }

    @Override
    public int defaultNavigationDrawerItemSelectedPosition() {
        return 1;
    }

    @Override
    protected ActionBarHandler getActionBarHandler() {
        return new ActionBarDefaultHandler(this);
    }

    public SnackBar getSnackBar(){
        return mSnackBar;
    }
}

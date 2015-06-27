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
import com.rey.material.widget.SnackBar;
import com.sevenre.trackre.parent.fragment.HomeFragment;
import com.sevenre.trackre.parent.fragment.LoginFragment;
import com.sevenre.trackre.parent.fragment.LogoutFragment;
import com.sevenre.trackre.parent.fragment.NotificationFragment;

import com.sevenre.trackre.parent.R;
import com.sevenre.trackre.parent.fragment.SimplyTrackVerificationFragment;
import com.sevenre.trackre.parent.fragment.TrackingFragment;

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
                .addItem("Home", new HomeFragment())
                .addItem(R.string.notification, new NotificationFragment())
                .addItem(R.string.simply_track, new SimplyTrackVerificationFragment())
                .addItem(R.string.add_phone_no, new NotificationFragment())
                .addItem(R.string.notification, new NotificationFragment())
                .addItem(R.string.logout, new LogoutFragment())
                .addItem(R.string.tracking, new TrackingFragment())
                .addItem("Login", new LoginFragment());

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

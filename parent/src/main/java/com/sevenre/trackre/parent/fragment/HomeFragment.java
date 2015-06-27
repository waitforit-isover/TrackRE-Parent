package com.sevenre.trackre.parent.fragment;

import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;
import com.sevenre.trackre.parent.R;

public class HomeFragment extends com.blunderer.materialdesignlibrary.fragments.ViewPagerWithTabsFragment {

    @Override
    protected boolean expandTabs() {
        return false;
    }

    @Override
    public ViewPagerHandler getViewPagerHandler() {
        return new ViewPagerHandler(getActivity())
                .addPage(R.string.children, ChildrenFragment.newInstance())
                .addPage(R.string.tracking, TrackingFragment.newInstance())
                .addPage(R.string.notification, NotificationFragment.newInstance());
    }

    @Override
    public int defaultViewPagerPageSelectedPosition() {
        return 0;
    }
}

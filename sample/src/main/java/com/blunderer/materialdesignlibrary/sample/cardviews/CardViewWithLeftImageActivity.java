package com.blunderer.materialdesignlibrary.sample.cardviews;

import com.blunderer.materialdesignlibrary.handlers.ActionBarDefaultHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.sample.R;

public class CardViewWithLeftImageActivity
        extends com.blunderer.materialdesignlibrary.activities.Activity {

    @Override
    protected int getContentView() {
        return R.layout.activity_cardview_with_left_image;
    }

    @Override
    protected ActionBarHandler getActionBarHandler() {
        return new ActionBarDefaultHandler(this);
    }

}

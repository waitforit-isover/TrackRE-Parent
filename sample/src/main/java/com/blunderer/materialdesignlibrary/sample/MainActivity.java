package com.blunderer.materialdesignlibrary.sample;

import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import com.blunderer.materialdesignlibrary.handlers.ActionBarDefaultHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.sample.cardviews.CardViewNormalActivity;
import com.blunderer.materialdesignlibrary.sample.cardviews.CardViewWithLeftImageActivity;
import com.blunderer.materialdesignlibrary.sample.cardviews.CardViewWithTopImageActivity;
import com.blunderer.materialdesignlibrary.sample.listviews.ListViewActivity;
import com.blunderer.materialdesignlibrary.sample.listviews.ListViewWithCustomLayoutActivity;
import com.blunderer.materialdesignlibrary.sample.listviews.ListViewWithRefreshActivity;
import com.blunderer.materialdesignlibrary.sample.navigationdrawers.NavigationDrawerActivity;
import com.blunderer.materialdesignlibrary.sample.navigationdrawers.NavigationDrawerWithAccountsActivity;
import com.blunderer.materialdesignlibrary.sample.navigationdrawers.NavigationDrawerWithAccountsAndFullHeightActivity;
import com.blunderer.materialdesignlibrary.sample.navigationdrawers.NavigationDrawerWithFullHeightActivity;
import com.blunderer.materialdesignlibrary.sample.scrollviews.ScrollViewActivity;
import com.blunderer.materialdesignlibrary.sample.scrollviews.ScrollViewWithRefreshActivity;
import com.blunderer.materialdesignlibrary.sample.searchbar.SearchBarActivity;
import com.blunderer.materialdesignlibrary.sample.searchbar.SearchBarAutoCompletionActivity;
import com.blunderer.materialdesignlibrary.sample.viewpagers.ViewPagerActivity;
import com.blunderer.materialdesignlibrary.sample.viewpagers.ViewPagerWithIndicatorActivity;
import com.blunderer.materialdesignlibrary.sample.viewpagers.ViewPagerWithTabsActivity;
import com.blunderer.materialdesignlibrary.sample.viewpagers.ViewPagerWithTabsExpandedActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends com.blunderer.materialdesignlibrary.activities.ListViewActivity {

    @Override
    public ListAdapter getListAdapter() {
        return new MainActivityAdapter(this, R.layout.activity_main_row, getFeatures());
    }

    @Override
    public boolean useCustomContentView() {
        return false;
    }

    @Override
    public int getCustomContentView() {
        return 0;
    }

    @Override
    public boolean pullToRefreshEnabled() {
        return false;
    }

    @Override
    public int[] getPullToRefreshColorResources() {
        return new int[0];
    }

    @Override
    public void onRefresh() {
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent(this,
                ((MainActivityFeature) adapterView.getAdapter().getItem(position)).getActivity());
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.github:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/DenisMondon/material-design-library"));
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected ActionBarHandler getActionBarHandler() {
        return new ActionBarDefaultHandler(this);
    }

    private List<MainActivityFeature> getFeatures() {
        MainActivityFeature navigationDrawerHeader = new MainActivityFeature();
        navigationDrawerHeader.setHeader(true);
        navigationDrawerHeader.setTitle("NavigationDrawer");
        MainActivityFeature navigationDrawerFeature1 = new MainActivityFeature();
        navigationDrawerFeature1.setActivity(NavigationDrawerActivity.class);
        navigationDrawerFeature1.setTitle("Normal");
        navigationDrawerFeature1.setDescription("A basic NavigationDrawer");
        MainActivityFeature navigationDrawerFeature2 = new MainActivityFeature();
        navigationDrawerFeature2.setActivity(NavigationDrawerWithAccountsActivity.class);
        navigationDrawerFeature2.setTitle("With Accounts");
        navigationDrawerFeature2.setDescription("A NavigationDrawer with accounts");
        MainActivityFeature navigationDrawerFeature3 = new MainActivityFeature();
        navigationDrawerFeature3.setActivity(NavigationDrawerWithFullHeightActivity.class);
        navigationDrawerFeature3.setTitle("With Full Height");
        navigationDrawerFeature3.setDescription("A NavigationDrawer that overlays the ActionBar");
        MainActivityFeature navigationDrawerFeature4 = new MainActivityFeature();
        navigationDrawerFeature4.setActivity(NavigationDrawerWithAccountsAndFullHeightActivity.class);
        navigationDrawerFeature4.setTitle("With Accounts & Full Height");
        navigationDrawerFeature4.setDescription("A NavigationDrawer with accounts that overlays the ActionBar");

        MainActivityFeature listViewHeader = new MainActivityFeature();
        listViewHeader.setHeader(true);
        listViewHeader.setTitle("ListView");
        MainActivityFeature listViewFeature1 = new MainActivityFeature();
        listViewFeature1.setActivity(ListViewActivity.class);
        listViewFeature1.setTitle("Normal");
        listViewFeature1.setDescription("A basic ListView");
        MainActivityFeature listViewFeature2 = new MainActivityFeature();
        listViewFeature2.setActivity(ListViewWithCustomLayoutActivity.class);
        listViewFeature2.setTitle("With Custom Layout");
        listViewFeature2.setDescription("A ListView with a custom layout");
        MainActivityFeature listViewFeature3 = new MainActivityFeature();
        listViewFeature3.setActivity(ListViewWithRefreshActivity.class);
        listViewFeature3.setTitle("With Pull To Refresh");
        listViewFeature3.setDescription("A ListView with a pull to refresh");

        MainActivityFeature viewPagerHeader = new MainActivityFeature();
        viewPagerHeader.setHeader(true);
        viewPagerHeader.setTitle("ViewPager");
        MainActivityFeature viewPagerFeature1 = new MainActivityFeature();
        viewPagerFeature1.setActivity(ViewPagerActivity.class);
        viewPagerFeature1.setTitle("Normal");
        viewPagerFeature1.setDescription("A basic ViewPager");
        MainActivityFeature viewPagerFeature2 = new MainActivityFeature();
        viewPagerFeature2.setActivity(ViewPagerWithIndicatorActivity.class);
        viewPagerFeature2.setTitle("With Indicator");
        viewPagerFeature2.setDescription("A ViewPager with an indicator");
        MainActivityFeature viewPagerFeature3 = new MainActivityFeature();
        viewPagerFeature3.setActivity(ViewPagerWithTabsActivity.class);
        viewPagerFeature3.setTitle("With Tabs");
        viewPagerFeature3.setDescription("A ViewPager with tabs");
        MainActivityFeature viewPagerFeature4 = new MainActivityFeature();
        viewPagerFeature4.setActivity(ViewPagerWithTabsExpandedActivity.class);
        viewPagerFeature4.setTitle("With Expanded Tabs");
        viewPagerFeature4.setDescription("A ViewPager with expanded tabs");

        MainActivityFeature scrollViewHeader = new MainActivityFeature();
        scrollViewHeader.setHeader(true);
        scrollViewHeader.setTitle("ScrollView");
        MainActivityFeature scrollViewFeature1 = new MainActivityFeature();
        scrollViewFeature1.setActivity(ScrollViewActivity.class);
        scrollViewFeature1.setTitle("Normal");
        scrollViewFeature1.setDescription("A basic ScrollView");
        MainActivityFeature scrollViewFeature2 = new MainActivityFeature();
        scrollViewFeature2.setActivity(ScrollViewWithRefreshActivity.class);
        scrollViewFeature2.setTitle("With Pull To Refresh");
        scrollViewFeature2.setDescription("A ListView with a pull to refresh");

        MainActivityFeature cardviewHeader = new MainActivityFeature();
        cardviewHeader.setHeader(true);
        cardviewHeader.setTitle("CardView");
        MainActivityFeature cardviewFeature1 = new MainActivityFeature();
        cardviewFeature1.setActivity(CardViewNormalActivity.class);
        cardviewFeature1.setTitle("Normal");
        cardviewFeature1.setDescription("A basic CardView");
        MainActivityFeature cardviewFeature2 = new MainActivityFeature();
        cardviewFeature2.setActivity(CardViewWithLeftImageActivity.class);
        cardviewFeature2.setTitle("Left Image");
        cardviewFeature2.setDescription("A CardView with an image on the left");
        MainActivityFeature cardviewFeature3 = new MainActivityFeature();
        cardviewFeature3.setActivity(CardViewWithTopImageActivity.class);
        cardviewFeature3.setTitle("Top Image");
        cardviewFeature3.setDescription("A CardView with an image on the top");

        MainActivityFeature searchBarHeader = new MainActivityFeature();
        searchBarHeader.setHeader(true);
        searchBarHeader.setTitle("SearchBar");
        MainActivityFeature searchBarFeature1 = new MainActivityFeature();
        searchBarFeature1.setActivity(SearchBarActivity.class);
        searchBarFeature1.setTitle("Normal");
        searchBarFeature1.setDescription("A basic SearchBar");
        MainActivityFeature searchBarFeature2 = new MainActivityFeature();
        searchBarFeature2.setActivity(SearchBarAutoCompletionActivity.class);
        searchBarFeature2.setTitle("With Auto Completion");
        searchBarFeature2.setDescription("A SearchBar with auto completion");

        List<MainActivityFeature> objects = new ArrayList<>();
        objects.add(searchBarHeader);
        objects.add(searchBarFeature1);
        objects.add(searchBarFeature2);
        objects.add(navigationDrawerHeader);
        objects.add(navigationDrawerFeature1);
        objects.add(navigationDrawerFeature2);
        objects.add(navigationDrawerFeature3);
        objects.add(navigationDrawerFeature4);
        objects.add(listViewHeader);
        objects.add(listViewFeature1);
        objects.add(listViewFeature2);
        objects.add(listViewFeature3);
        objects.add(viewPagerHeader);
        objects.add(viewPagerFeature1);
        objects.add(viewPagerFeature2);
        objects.add(viewPagerFeature3);
        objects.add(viewPagerFeature4);
        objects.add(scrollViewHeader);
        objects.add(scrollViewFeature1);
        objects.add(scrollViewFeature2);
        objects.add(cardviewHeader);
        objects.add(cardviewFeature1);
        objects.add(cardviewFeature2);
        objects.add(cardviewFeature3);

        return objects;
    }

}

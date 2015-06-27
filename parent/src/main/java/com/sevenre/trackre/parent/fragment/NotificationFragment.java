package com.sevenre.trackre.parent.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.util.Attributes;
import com.sevenre.trackre.parent.R;
import com.sevenre.trackre.parent.adapter.ListSwipeAdapter;

public class NotificationFragment extends Fragment {

    private ListView mListView;
    private ListSwipeAdapter mAdapter;

    public static NotificationFragment newInstance() {
        NotificationFragment fragment = new NotificationFragment();
        return fragment;
    }

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        mAdapter = new ListSwipeAdapter(getActivity());
        mListView = (ListView)view.findViewById(R.id.notif_list_view);
        mListView.setAdapter(mAdapter);
        mAdapter.setMode(Attributes.Mode.Single);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((SwipeLayout) (mListView.getChildAt(position - mListView.getFirstVisiblePosition()))).open(true);
            }
        });
        mListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("ListView", "OnTouch");
                return false;
            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "OnItemLongClickListener", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Log.e("ListView", "onScrollStateChanged");
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        mListView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("ListView", "onItemSelected:" + position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.e("ListView", "onNothingSelected:");
            }
        });

        final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        mAdapter.contentRefresh();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }

                }, 2000);

            }
        });
        return view;
    }

    void refreshContent() {

    }
}

//public class NotificationFragment extends com.blunderer.materialdesignlibrary.fragments.ListViewFragment {
//
//    private List<String> mObjects;
//    private ArrayAdapter<String> mAdapter;
//
//    public static NotificationFragment newInstance() {
//        return new NotificationFragment();
//    }
//
//    @Override
//    public ListAdapter getListAdapter() {
//        mObjects = new ArrayList<>(Arrays.asList(
//                "item 1", "item 2", "item 3"
//        ));
//
//
//        return (mAdapter = new ArrayAdapter<>(getActivity(),R.layout.notification_row, mObjects));
//    }
//
//    @Override
//    public boolean useCustomContentView() {
//        return false;
//    }
//
//    @Override
//    public int getCustomContentView() {
//        return 0;
//    }
//
//    @Override
//    public boolean pullToRefreshEnabled() {
//        return true;
//    }
//
//    @Override
//    public int[] getPullToRefreshColorResources() {
//        return new int[]{R.color.color_primary};
//    }
//
//    @Override
//    public void onRefresh() {
//        new Handler().postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                mObjects.add("item " + (mObjects.size() + 1));
//                mAdapter.notifyDataSetChanged();
//                setRefreshing(false);
//            }
//
//        }, 2000);
//
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//    }
//
//    @Override
//    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
//        return false;
//    }
//}

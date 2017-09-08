package com.rohit.serviceexample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.logging.Handler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NewFragment extends Fragment {

    ArrayList<Fragment> fragments = new ArrayList<>();
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    BrowseTourAdapter browseTourAdapter;
    ArrayList<String> mTabText = new ArrayList<>();
    Boolean first = true;
    private Unbinder unbinder;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.activity_fragment_one, container, false);
        unbinder = ButterKnife.bind(this,mView);

       /* mTabLayout = (TabLayout) mView.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) mView.findViewById(R.id.view_pager);*/

        fragments.add(new FragmentTab());
        fragments.add(new FragmentTab());
//        fragments.add(new FragmentTab());
        mTabText.add("All");
        mTabText.add("Near");
//        mTabText.add("Recomm");

        browseTourAdapter = new BrowseTourAdapter(getChildFragmentManager(), fragments, mTabText);
        mViewPager.setAdapter(browseTourAdapter);
        mTabLayout.setupWithViewPager(mViewPager);


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (first && positionOffset == 0 && positionOffsetPixels == 0) {
                    onPageSelected(0);
                    first = false;
                }
            }

            @Override
            public void onPageSelected(int position) {

                Log.e("", "positionPageSelected " + position);
                FragmentTab fragmentTab = (FragmentTab) browseTourAdapter.getItem(position);
                fragmentTab.changeName(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return mView;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
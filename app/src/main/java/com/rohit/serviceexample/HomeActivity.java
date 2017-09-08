package com.rohit.serviceexample;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

//    ArrayList<Fragment> fragments = new ArrayList<>();
//    TabLayout mTabLayout;
//    ViewPager mViewPager;
//    BrowseTourAdapter browseTourAdapter;
//    ArrayList<String> mTabText = new ArrayList<>();
//    Boolean first = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        mViewPager = (ViewPager) findViewById(R.id.view_pager);
//
//        fragments.add(new FragmentTab());
//        fragments.add(new FragmentTab());
//        fragments.add(new FragmentTab());
//        mTabText.add("All");
//        mTabText.add("Near");
//        mTabText.add("Recomm");
//
//        browseTourAdapter = new BrowseTourAdapter(getSupportFragmentManager(), fragments, mTabText);
//        mViewPager.setAdapter(browseTourAdapter);
//        mTabLayout.setupWithViewPager(mViewPager);

        getSupportFragmentManager().beginTransaction().add(R.id.ll_container,new NewFragment()).commit();

//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                if (first && positionOffset == 0 && positionOffsetPixels == 0) {
//                    onPageSelected(0);
//                    first = false;
//                }
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//                Log.e("", "positionPageSelected " + position);
//                FragmentTab fragmentTab = (FragmentTab) browseTourAdapter.getItem(position);
//                fragmentTab.changeName("Page"+position);
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }
}

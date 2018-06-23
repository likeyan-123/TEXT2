package com.example.lky12.text2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.lky12.text2.adapter.SimpleFragmentPagerAdapter;
import com.example.lky12.text2.ui.OneFragment;
import com.example.lky12.text2.ui.TwoFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<android.support.v4.app.Fragment> list_fragment=new ArrayList<>();                                //定义要装fragment的列表
    private ArrayList<String> list_title=new ArrayList<>();                                //定义要装fragment的列表
    private OneFragment mOneFragment;              //热门推荐fragment
    private TwoFragment mTwoFragment;            //热门收藏fragment


    private SimpleFragmentPagerAdapter pagerAdapter;

    private ViewPager viewPager;

    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initControls();
    }
    /**
     * 初始化各控件
     */
    private void initControls() {

        //初始化各fragment
        mOneFragment = new OneFragment();
        mTwoFragment = new TwoFragment();

        //将fragment装进列表中

        list_fragment.add(mOneFragment);
        list_fragment.add(mTwoFragment);

        list_title.add("第一个页面");
        list_title.add("第二个页面");


        pagerAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), this,list_fragment,list_title);
//        viewPager = (ChildViewPager) findViewById(R.id.viewpager);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}


package com.tm.viewpagerholder;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int [] imgs = {
            R.mipmap.img1,
            R.mipmap.img2,
            R.mipmap.img3,
            R.mipmap.img4,
            R.mipmap.img5
    };
    private ViewPager vp;
    private CommonViewPagerAdapter adapter;
    private List<DataEntity> datas;

    private RadioGroup rgBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
        datas = new ArrayList<>();
        for (int i: imgs) {
            DataEntity dataEntity = new DataEntity();
            dataEntity.setImageResId(i);
            datas.add(dataEntity);
        }
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        rgBanner = (RadioGroup) findViewById(R.id.rg_banner);

        adapter = new CommonViewPagerAdapter(vp, datas, new ViewPagerHolderCreator<ViewImageHolder>() {
            @Override
            public ViewImageHolder createViewHolder() {
                return new ViewImageHolder();
            }
        });
        vp.setAdapter(adapter);
        vp.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                RadioButton rb = (RadioButton) rgBanner.getChildAt(position);
                rb.setChecked(true);
            }
        });

    }
}

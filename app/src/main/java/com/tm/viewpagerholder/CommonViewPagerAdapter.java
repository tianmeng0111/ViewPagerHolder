package com.tm.viewpagerholder;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Tian on 2017/5/31.
 */

public class CommonViewPagerAdapter<T> extends PagerAdapter {

    private List<T> mDatas;
    private ViewPagerHolderCreator mCreator;//ViewPager生成器
    private ViewPager mViewPager;

    public CommonViewPagerAdapter(ViewPager viewPager, List<T> mDatas, ViewPagerHolderCreator mCreator) {
        this.mDatas = mDatas;
        this.mCreator = mCreator;
        this.mViewPager = viewPager;
    }

    @Override
    public int getCount() {
        return mDatas == null? 0: mDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //不把view写死，而是调用接口提供的布局
        View view = getView(position, null, container);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    /**
     * 获取ViewPage页面显示View
     * @param position
     * @param view
     * @param container
     * @return
     */
    private View getView(int position, View view, ViewGroup container) {
        ViewPagerHolder holder;
        if (view == null) {
            holder = mCreator.createViewHolder();
            view = holder.createView(container.getContext());
            view.setTag(holder);
        } else {
            holder = (ViewPagerHolder) view.getTag();
        }


        if (holder != null && mDatas != null && mDatas.size() > 0) {
            //数据绑定
            holder.onBind(container.getContext(), position, mDatas.get(position));
        }

        return view;
    }
}

package com.tm.viewpagerholder;

/**
 * Created by Tian on 2017/5/31.
 */

public interface ViewPagerHolderCreator<VH extends ViewPagerHolder> {

    /**
     * 创建ViewPagerHolder
     * @return
     */
    public VH createViewHolder();
}

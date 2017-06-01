package com.tm.viewpagerholder;

import android.content.Context;
import android.view.View;

/**
 * Created by Tian on 2017/5/31.
 */

public interface ViewPagerHolder<T> {

    /**
     * 创建View
     * @param context
     * @return
     */
    View createView(Context context);

    /**
     * 绑定数据
     * @param context
     * @param position
     * @param data
     * @return
     */
    void onBind(Context context, int position, T data);
}

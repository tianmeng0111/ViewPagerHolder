package com.tm.viewpagerholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Tian on 2017/5/31.
 */

public class ViewImageHolder implements ViewPagerHolder<DataEntity> {
    private static final String TAG = "ViewImageHolder";

    private ImageView img;

    @Override
    public View createView(Context context) {
        View view = View.inflate(context, R.layout.item, null);
        img = (ImageView) view.findViewById(R.id.img);
        return view;
    }

    @Override
    public void onBind(Context context, int position, DataEntity data) {
        img.setImageResource(data.getImageResId());
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), data.getImageResId());
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Log.e(TAG, "width: " + width + ";height:" + height);
    }
}

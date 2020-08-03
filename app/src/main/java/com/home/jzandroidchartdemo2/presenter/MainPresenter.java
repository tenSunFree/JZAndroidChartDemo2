package com.home.jzandroidchartdemo2.presenter;

import android.app.Activity;
import android.util.DisplayMetrics;

import com.home.jzandroidchartdemo2.model.MainModel;

import java.util.List;

import cn.jingzhuan.lib.chart.data.CandlestickValue;

public class MainPresenter {

    private Activity activity;
    private MainModel model;

    public MainPresenter(Activity activity) {
        this.activity = activity;
        model = new MainModel();
    }

    public List<CandlestickValue> getCandlestickValueList() {
        return model.getCandlestickValueList();
    }

    public int getCenterBarHeight() {
        int statusBarHeight = -1;
        int resourceId = activity.getResources()
                .getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = activity.getResources().getDimensionPixelSize(resourceId);
        }
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;
        int height = metric.heightPixels;
        int topBarHeight = width * 663 / 1440;
        int bottomBarHeight = width * 1237 / 1440;
        return height - statusBarHeight - topBarHeight - bottomBarHeight;
    }
}
package com.home.jzandroidchartdemo2.view.epoxy;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.EpoxyController;
import com.home.jzandroidchartdemo2.ActivityMainBottomBarBindingModel_;
import com.home.jzandroidchartdemo2.ActivityMainTopBarBindingModel_;
import com.home.jzandroidchartdemo2.R;

import java.util.List;

import cn.jingzhuan.lib.chart.data.CandlestickValue;

public class MainEpoxyController extends EpoxyController {

    @AutoModel
    MainCenterBarEpoxyModel_ mainCenterBarEpoxyModel_;

    private int height;
    private List<CandlestickValue> candlestickValueList;

    public MainEpoxyController(int height, List<CandlestickValue> list) {
        this.height = height;
        this.candlestickValueList = list;
    }

    @Override
    protected void buildModels() {
        initTopModel();
        initCenterModel();
        initBottomModel();
    }

    private void initTopModel() {
        new ActivityMainTopBarBindingModel_()
                .id("ActivityMainTopBarBindingModel_")
                .imageResource(R.drawable.icon_top_bar)
                .addTo(this);
    }

    private void initCenterModel() {
        mainCenterBarEpoxyModel_.candlestickValues = candlestickValueList;
        mainCenterBarEpoxyModel_.height = height;
        mainCenterBarEpoxyModel_.addTo(this);
    }

    private void initBottomModel() {
        new ActivityMainBottomBarBindingModel_()
                .id("ActivityMainBottomBarBindingModel_").imageResource(R.drawable.icon_bottom_bar)
                .addTo(this);
    }
}
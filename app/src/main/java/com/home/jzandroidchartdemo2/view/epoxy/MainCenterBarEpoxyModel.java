package com.home.jzandroidchartdemo2.view.epoxy;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.epoxy.DataBindingEpoxyModel;
import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.home.jzandroidchartdemo2.R;
import com.home.jzandroidchartdemo2.databinding.ActivityMainCenterBarBinding;

import java.util.ArrayList;
import java.util.List;

import cn.jingzhuan.lib.chart.component.Highlight;
import cn.jingzhuan.lib.chart.data.CandlestickDataSet;
import cn.jingzhuan.lib.chart.data.CandlestickValue;
import cn.jingzhuan.lib.chart.event.HighlightStatusChangeListener;

import static cn.jingzhuan.lib.chart.component.AxisY.LEFT_OUTSIDE;
import static cn.jingzhuan.lib.chart.component.AxisY.RIGHT_INSIDE;
import static com.airbnb.epoxy.EpoxyAttribute.Option.DoNotHash;

@EpoxyModelClass(layout = R.layout.activity_main_center_bar)
public abstract class MainCenterBarEpoxyModel extends DataBindingEpoxyModel {

    @EpoxyAttribute(DoNotHash)
    HighlightStatusChangeListener highlightStatusChangeListener;
    int height;
    List<CandlestickValue> candlestickValues = new ArrayList<>();

    @Override
    protected View buildView(@NonNull ViewGroup parent) {
        View rootView = super.buildView(parent);
        final ActivityMainCenterBarBinding binding =
                (ActivityMainCenterBarBinding) rootView.getTag();
        RecyclerView.LayoutParams params =
                (RecyclerView.LayoutParams) binding.constraintLayout.getLayoutParams();
        params.height = height;
        binding.constraintLayout.setLayoutParams(params);
        CandlestickDataSet dataSet = new CandlestickDataSet(candlestickValues);
        dataSet.setHighlightedVerticalEnable(true);
        dataSet.setHighlightedHorizontalEnable(true);
        initCombineChart(binding, dataSet);
        return rootView;
    }

    private void initCombineChart(final com.home.jzandroidchartdemo2.databinding.ActivityMainCenterBarBinding binding, CandlestickDataSet dataSet) {
        binding.combineChart.getAxisLeft().setAxisPosition(LEFT_OUTSIDE);
        binding.combineChart.getAxisRight().setAxisPosition(RIGHT_INSIDE);
        binding.combineChart.setMaxVisibleEntryCount(70);
        binding.combineChart.setMinVisibleEntryCount(10);
        binding.combineChart.setHighlightColor(Color.BLACK);
        binding.combineChart.setDataSet(dataSet);
        binding.combineChart.setScaleGestureEnable(true);
        binding.combineChart.setScaleXEnable(true);
        binding.combineChart.setDoubleTapToZoom(false);
        binding.combineChart.setHighlightDisable(false);
        binding.combineChart.setDraggingToMoveEnable(true);
        binding.combineChart.setOnHighlightStatusChangeListener(new HighlightStatusChangeListener() {
            @Override
            public void onHighlightShow(Highlight[] highlights) {
                binding.combineChart.setDraggingToMoveEnable(false);
            }

            @Override
            public void onHighlightHide() {
                binding.combineChart.setDraggingToMoveEnable(true);
            }
        });
    }

    @Override protected void setDataBindingVariables(ViewDataBinding binding) {
    }
}

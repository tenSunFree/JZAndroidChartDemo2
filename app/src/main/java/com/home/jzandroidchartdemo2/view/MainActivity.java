package com.home.jzandroidchartdemo2.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.airbnb.epoxy.EpoxyControllerAdapter;
import com.home.jzandroidchartdemo2.presenter.MainPresenter;
import com.home.jzandroidchartdemo2.R;
import com.home.jzandroidchartdemo2.databinding.ActivityMainBinding;
import com.home.jzandroidchartdemo2.view.epoxy.MainEpoxyController;

import java.util.List;

import cn.jingzhuan.lib.chart.data.CandlestickValue;

public class MainActivity extends AppCompatActivity {

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        initView();
    }

    private void initPresenter() {
        presenter = new MainPresenter(this);
    }

    private void initView() {
        ActivityMainBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_main);
        setContentView(binding.getRoot());
        int height = presenter.getCenterBarHeight();
        List<CandlestickValue> list = presenter.getCandlestickValueList();
        MainEpoxyController controller = new MainEpoxyController(height, list);
        EpoxyControllerAdapter adapter = controller.getAdapter();
        binding.recyclerView.setAdapter(adapter);
        controller.requestModelBuild();
    }
}
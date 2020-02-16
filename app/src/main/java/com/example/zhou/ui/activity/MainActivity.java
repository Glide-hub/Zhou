package com.example.zhou.ui.activity;

import android.os.Bundle;
import android.widget.TextView;


import com.example.zhou.R;
import com.example.zhou.base.BaseActivity;
import com.example.zhou.bean.BaseBean;
import com.example.zhou.presenter.MainPresenter;
import com.example.zhou.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.Tv)
    TextView tv;



    @Override
    protected MainPresenter initPresenter() {
        String string = getResources().getString(R.string.app_name);
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        mPresenter.showToast(this, "新年好");
    }

    @Override
    public void setData(BaseBean bean) {
        System.out.println("Success:"+bean.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter=null;
    }
}

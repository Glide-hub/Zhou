package com.example.zhou.base;

import android.os.Bundle;

import com.example.zhou.util.ToastUtil;
import com.example.zhou.widget.LoadingDialog;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;


public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView{

    public P mPresenter;
    private LoadingDialog mLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mPresenter = initPresenter();
        if (mPresenter!=null){
            mPresenter.attachView(this);
        }
        initView();
        initData();
        initListener();

    }

    protected abstract P initPresenter();

    public void initListener() {
    }

    public void initData() {
    }

    public void initView() {
    }

    protected abstract int getLayoutId() ;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.destroy();
            mPresenter=null;
        }
    }
    public void showToast(String str){
        ToastUtil.showToastLong(str);
    }
    public void showLoading(){
        if (mLoadingDialog==null) {
            mLoadingDialog = new LoadingDialog(this);
        }
        if (!mLoadingDialog.isShowing()) {
            mLoadingDialog.show();
        }
    }
    public void hideLoading(){
        if (mLoadingDialog!=null){
            mLoadingDialog.hide();
        }
    }
}

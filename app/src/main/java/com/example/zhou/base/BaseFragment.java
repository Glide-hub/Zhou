package com.example.zhou.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhou.util.ToastUtil;
import com.example.zhou.widget.LoadingDialog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    public P mPresenter;
    private LoadingDialog mLoadingDialog;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), null);
        bind = ButterKnife.bind(this, inflate);
        mPresenter = initPresenter();
        if (mPresenter!=null){
            mPresenter.attachView(this);
        }
        initView();
        initData();
        initListener();

        return inflate;
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
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
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
            mLoadingDialog = new LoadingDialog(getContext());
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

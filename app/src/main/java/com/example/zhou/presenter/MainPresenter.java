package com.example.zhou.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.zhou.base.BasePresenter;
import com.example.zhou.bean.BaseBean;
import com.example.zhou.model.MainModel;
import com.example.zhou.net.NetCallBack;
import com.example.zhou.view.MainView;


public class MainPresenter extends BasePresenter<MainView> {
    public final MainModel mainModel;
    /*public MainPresenter(BaseView view) {
        super(view);
    }*/

    public MainPresenter(){
        mainModel = new MainModel();
        addModel(mainModel);
    }
    public void showToast(Context context, String msg){
       mainModel.getData(new NetCallBack<BaseBean>() {
           @Override
           public void onSuccess(BaseBean bean) {
               if (mView!=null){
                   mView.hideLoading();
               }
               if (bean!=null) {
                   mView.setData(bean);
               }
           }

           @Override
           public void onFaid(String str) {
               if (mView!=null){
                   mView.hideLoading();
               }
                System.out.println("erros:"+str);
           }
       });
    }

}

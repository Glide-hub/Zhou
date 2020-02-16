package com.example.zhou.model;



import com.example.zhou.base.BaseModel;
import com.example.zhou.bean.BaseBean;
import com.example.zhou.net.ApiService;
import com.example.zhou.net.BaseObserver;
import com.example.zhou.net.HttpUtil;
import com.example.zhou.net.NetCallBack;
import com.example.zhou.util.RxUtils;


import io.reactivex.schedulers.Schedulers;


public class MainModel extends BaseModel {
    public void getData(NetCallBack<BaseBean> baseBeanNetCallBack) {
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);*/
        ApiService apiService = HttpUtil.getInstance().getApiserver(ApiService.BASE_URL, ApiService.class);


       /* apiService.getHot().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(BaseBean bean) {
                        if (bean!=null){
                            baseBeanNetCallBack.onSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        baseBeanNetCallBack.onFaid(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/
       apiService.getHot().subscribeOn(Schedulers.io())
                .compose(RxUtils.rxObserableSchedulerHelper())
               .subscribe(new BaseObserver<BaseBean>(this) {
                   @Override
                   protected void onSuccess(BaseBean bean) {
                       baseBeanNetCallBack.onSuccess(bean);
                   }

                   @Override
                   protected void error(String err) {
                        baseBeanNetCallBack.onFaid(err);
                   }
               });
    }

}

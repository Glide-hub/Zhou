package com.example.zhou.base;



import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public class BaseModel {
    private static final String TAG = "BaseModel";
    CompositeDisposable compositeDisposable=null;
    public void notifyDestroy() {
        if (compositeDisposable!=null&&compositeDisposable.size()>0){
            compositeDisposable.clear();
        }
    }
    public void addDisposable(Disposable disposable){
        if (compositeDisposable==null){
            compositeDisposable=new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    public void removeDisposable(Disposable mDisposable) {
        if (compositeDisposable!=null){
            compositeDisposable.delete(mDisposable);
        }
    }
}

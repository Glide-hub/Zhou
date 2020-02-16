package com.example.zhou.base;

import java.util.ArrayList;

public class BasePresenter<V> {
    public V mView;
    private ArrayList<BaseModel> models=new ArrayList<>();

    public void addModel(BaseModel model){
            if (model!=null){
                models.add(model);
            }
    }

    public void attachView(V view) {
        mView=view;
    }

    public void destroy() {
        if (models.size()>0){
            for (int i = 0; i < models.size(); i++) {
                BaseModel baseModel = models.get(i);
                baseModel.notifyDestroy();
            }
        }
        mView=null;
    }


    /*public BasePresenter(BaseView view){

        mView = view;
    }*/
}

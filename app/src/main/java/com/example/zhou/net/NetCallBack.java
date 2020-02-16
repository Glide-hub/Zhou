package com.example.zhou.net;

import com.example.demo_three.bean.BaseBean;

public interface NetCallBack<T> {
    void onSuccess(T t);
    void onFaid(String str);
}

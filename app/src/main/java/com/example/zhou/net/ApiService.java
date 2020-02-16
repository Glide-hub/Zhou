package com.example.zhou.net;



import com.example.zhou.bean.BaseBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String BASE_URL="https://www.wanandroid.com/";
    @GET("project/list/1/json?cid=294")
    Observable<BaseBean>getHot();
}

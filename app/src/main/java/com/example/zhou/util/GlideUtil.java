package com.example.zhou.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtil {
    /**
     *
     * @param context
     * @param imageUrl 网络图片链接
     * @param resId 占为图
     * @param iv
     */
    public static void loadImage(Context context, String imageUrl, int resId,ImageView iv){
        RequestOptions options = new RequestOptions().placeholder(resId);
        Glide.with(context).load(imageUrl).apply(options).into(iv);
    }
    /**
     *
     * @param context
     * @param id 本地资源图片
     * @param resId 占为图
     * @param iv
     */
    public static void loadImage(Context context, int id, int resId,ImageView iv){
        RequestOptions options = new RequestOptions().placeholder(resId);
        Glide.with(context).load(id).apply(options).into(iv);
    }
    /**
     * 加载圆形图片
     * @param context
     * @param imageUrl 本地资源图片
     * @param resId 占为图
     * @param iv
     */
    public static void loadImageCircle(Context context, String imageUrl, int resId,ImageView iv){
        RequestOptions options = new RequestOptions().placeholder(resId).circleCrop();
        Glide.with(context).load(imageUrl).apply(options).into(iv);
    }
}

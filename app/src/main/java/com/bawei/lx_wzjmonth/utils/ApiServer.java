package com.bawei.lx_wzjmonth.utils;


import com.bawei.lx_wzjmonth.Goods.bean.AddBean;
import com.bawei.lx_wzjmonth.Goods.bean.DetailsBean;
import com.bawei.lx_wzjmonth.Goods.bean.GoodBean;
import com.bawei.lx_wzjmonth.login.LoginBean;
import com.bawei.lx_wzjmonth.zhuce.SignUpBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by fan on 2017/11/8.
 */

public interface ApiServer {
    @POST
    Observable<SignUpBean> getsup(@Url String url, @QueryMap Map<String, String> map);

    @POST
    Observable<LoginBean> getlg(@Url String url, @QueryMap Map<String, String> map);

    /*@GET("product/getCatagory")
    Observable<OneBean> getonedata();

    @GET("ad/getAd")
    Observable<BannerBean> getbanner();

    @POST
    Observable<TwoBean> getRight(@Url String url, @QueryMap Map<String, Integer> map);
*/
    @POST
    Observable<GoodBean> getgood(@Url String url, @QueryMap Map<String, Integer> map);

    @POST
    Observable<DetailsBean> getdetail(@Url String url, @QueryMap Map<String, String> map);

    @POST
    Observable<AddBean> getAdd(@Url String url, @QueryMap Map<String, String> map);


}

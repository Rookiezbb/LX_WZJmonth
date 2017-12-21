package com.bawei.lx_wzjmonth.Goods.presenter;


import com.bawei.lx_wzjmonth.Goods.GoodConstract;
import com.bawei.lx_wzjmonth.Goods.bean.GoodBean;
import com.bawei.lx_wzjmonth.Goods.model.GoodModel;

import java.util.List;

/**
 * Created by Zhang on 2017/11/16.
 */

public class GoodPresenter implements GoodConstract.IGoodPresenter {
    GoodConstract.IGoodView iGoodView;
    GoodConstract.IGoodModel iGoodModel;
    public GoodPresenter(GoodConstract.IGoodView iGoodView) {
        this.iGoodView = iGoodView;
        iGoodModel = new GoodModel();
    }

    @Override
    public void LoadList(String url, int pscid, int page, int sort) {
        iGoodModel.requestData(url, pscid, page, sort, new GoodConstract.OnGoodListener() {
            @Override
            public void onSuccess(List<GoodBean.DataBean> list) {
                iGoodView.ShowList(list);
            }

            @Override
            public void onError(String e) {
                iGoodView.ShowError(e);
            }
        });
    }

    /*@Override
    public void LoadDetails(String url, int pid) {
        iGoodModel.requestDetails(url, pid, new GoodConstract.OnDetailsListener() {
            @Override
            public void onSuccess(DetailsBean.DataBean list) {

            }

            @Override
            public void onError(String e) {

            }
        });
    }*/
}

package com.tianyuan.ruraldiary.presenter;

import com.tianyuan.ruraldiary.presenter.iview.IDetailView;

public class DetailPresenterImpl implements DetailPresenter{
    private IDetailView iDetailView=null;
    public DetailPresenterImpl(){

    }
    public DetailPresenterImpl(IDetailView iDetailView){
        this.iDetailView=iDetailView;
    }
    @Override
    public void onInitView() {
        iDetailView.initViews();
    }

    @Override
    public void onSetData() {
        iDetailView.initDataForComponent();
    }
}

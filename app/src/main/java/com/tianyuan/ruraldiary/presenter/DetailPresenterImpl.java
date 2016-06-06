package com.tianyuan.ruraldiary.presenter;

import android.content.Context;
import android.content.Intent;

import com.tianyuan.ruraldiary.bean.Diary;
import com.tianyuan.ruraldiary.presenter.iview.IDetailView;
import com.tianyuan.ruraldiary.ui.UpdateDiaryActivity;

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

    @Override
    public void onUpdate(Context context, Diary diary) {
        Intent intent=new Intent(context, UpdateDiaryActivity.class);
        intent.putExtra("updatediary",diary);
        context.startActivity(intent);
    }
}

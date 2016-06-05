package com.tianyuan.ruraldiary.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.tianyuan.ruraldiary.bean.Diary;
import com.tianyuan.ruraldiary.biz.DiaryImpl;
import com.tianyuan.ruraldiary.biz.IDiary;
import com.tianyuan.ruraldiary.presenter.iview.IHomeView;
import com.tianyuan.ruraldiary.ui.CreateDiaryActivity;
import com.tianyuan.ruraldiary.ui.DiaryDetailActivity;

import java.util.List;

/**
 *首页业务控制类
 */
public class HomePresenterImpl implements HomePresenter {
    //biz层对象
    private IDiary iDiary=null;
    private Context context=null;
    //视图
    private IHomeView iHomeView=null;
    public HomePresenterImpl(@NonNull Context context, IHomeView  iHomeView){
        this.context=context;
        iDiary=new DiaryImpl(context);
        this.iHomeView=iHomeView;
    }

    @Override
    public void initViews() {
        iHomeView.initViews();
        iHomeView.setData();
        iHomeView.setRecycleView();
    }

    @Override
    public void notifyData() {
        iHomeView.setData();
        iHomeView.setRecycleView();
    }

    @Override
    public void initDataBase() {
        DiaryImpl.getDataBaseHelper().getWritableDatabase();
    }

    @Override
    public List<Diary> getAllDiary() {
        return iDiary.getAllDiary();
    }

    @Override
    public void deleteDiary(Diary diary) {
        iDiary.deleteDiary(diary);
        iHomeView.showToast("删除日记成功！");
    }

    @Override
    public void readDiary(Context context,Diary diary) {
        Intent intent=new Intent(context, DiaryDetailActivity.class);
        intent.putExtra("diaryItem",diary);
        context.startActivity(intent);
    }

    @Override
    public void createDiary(Context context) {
        Intent intent=new Intent(context, CreateDiaryActivity.class);
        context.startActivity(intent);
    }
}

package com.tianyuan.ruraldiary.presenter;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.tianyuan.ruraldiary.bean.Diary;
import com.tianyuan.ruraldiary.biz.DiaryImpl;
import com.tianyuan.ruraldiary.biz.IDiary;
import com.tianyuan.ruraldiary.presenter.iview.IUpdateDiaryView;
import com.tianyuan.ruraldiary.ui.HomeActivity;
import com.tianyuan.ruraldiary.util.DiarySaveFormat;

public class UpdateDiaryPreImpl implements UpdateDiaryPresenter{
    private EditText mTitle;
    private EditText mContent;
    private  Diary mDiary;

    private  IDiary iDiary=null;
    private IUpdateDiaryView iUpdateDiaryView=null;

    public UpdateDiaryPreImpl(){}

    public UpdateDiaryPreImpl(IUpdateDiaryView iUpdateDiaryView){
        this.iUpdateDiaryView=iUpdateDiaryView;
        iDiary=new DiaryImpl();
    }

    @Override
    public void onInitView() {
        iUpdateDiaryView.initViews();
    }

    @Override
    public void onSetData() {
        mTitle=iUpdateDiaryView.getEtTitle();
        mContent=iUpdateDiaryView.getEtContent();
        mDiary=iUpdateDiaryView.getDiaryData();
        mTitle.setText(mDiary.getTitle());
        mTitle.setSelection(mDiary.getTitle().length());
        mContent.setText(mDiary.getContent());
    }

    @Override
    public void onSaveData(AppCompatActivity context) {
        mTitle=iUpdateDiaryView.getEtTitle();
        mContent=iUpdateDiaryView.getEtContent();
        //如果没有改变，不做更新操作
        if (mDiary.getTitle().equals(mTitle.getText().toString())
                && mDiary.getContent().equals(mContent.getText().toString())){
            showInfo("你木有更新呐！");
        }else{
            String createtime = DiarySaveFormat.formatTimeStr();
            String week = DiarySaveFormat.formatWeekStr();
            mDiary.setTitle(mTitle.getText().toString());
            mDiary.setContent(mContent.getText().toString());
            mDiary.setCreatetime(createtime);
            mDiary.setWeek(week);
            //更新数据
            iDiary.updateDiary(mDiary.getId(),mDiary);
            showInfo("更新成功！");
            Intent i=new Intent(context, HomeActivity.class);
            context.startActivity(i);
            context.finish();
        }
    }

    /**
     * 显示操作信息
     * @param msg
     */
    private void showInfo(String msg) {
        iUpdateDiaryView.showToast(msg);
    }
}

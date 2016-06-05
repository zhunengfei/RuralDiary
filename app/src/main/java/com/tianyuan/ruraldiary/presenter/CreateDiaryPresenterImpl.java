package com.tianyuan.ruraldiary.presenter;


import com.tianyuan.ruraldiary.bean.Diary;
import com.tianyuan.ruraldiary.biz.DiaryImpl;
import com.tianyuan.ruraldiary.biz.IDiary;
import com.tianyuan.ruraldiary.presenter.iview.ICreateDiaryView;
import com.tianyuan.ruraldiary.util.DiarySaveFormat;

public class CreateDiaryPresenterImpl implements CreateDiaryPresenter{
    ICreateDiaryView iCreateDiaryView=null;
    IDiary iDiary=null;
    public CreateDiaryPresenterImpl(ICreateDiaryView iCreateDiaryView){
        this.iCreateDiaryView=iCreateDiaryView;
        iDiary=new DiaryImpl();
    }

    @Override
    public void onInitView() {
        iCreateDiaryView.initViews();
    }

    @Override
    public void showInfo(String msg) {
        iCreateDiaryView.showToast(msg);
    }

    @Override
    public void getEditTextInfo() {
        String title=iCreateDiaryView.getEtDiaryTitle().getText().toString();
        String content=iCreateDiaryView.getetEtDiaryContent().getText().toString();
        if ("".equals(title) || "".equals(content)) {
            showInfo("你没写东西！！");
        }else {
            String createtime = DiarySaveFormat.formatTimeStr();
            String week = DiarySaveFormat.formatWeekStr();
            Diary diary = new Diary();
            diary.setTitle(title);
            diary.setContent(content);
            diary.setCreatetime(createtime);
            diary.setWeek(week);

            onInsertDiary(diary);
        }
    }

    /**
     * 插入日记
     * @param diary
     */
    public void onInsertDiary(Diary diary) {
        iDiary.insertDiary(diary);
        showInfo("添加日记成功!");
    }
}

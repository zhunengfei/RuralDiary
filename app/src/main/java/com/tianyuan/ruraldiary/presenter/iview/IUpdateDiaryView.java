package com.tianyuan.ruraldiary.presenter.iview;

import android.widget.EditText;

import com.tianyuan.ruraldiary.bean.Diary;

/**
 * 更新日记界面UI操作
 */
public interface IUpdateDiaryView {
    /**
     * 显示提示信息
     * @param msg success | failure
     */
    void showToast(String msg);

    /**
     * 初始化控件
     * 注册事件
     */
    void initViews();

    /**
     * 获取从阅读页面传递来的日记数据
     * @return
     */
    Diary getDiaryData();

    /**
     * 获取标题
     * @return
     */
    EditText getEtTitle();

    /**
     * 获取内容
     * @return
     */
    EditText getEtContent();
}

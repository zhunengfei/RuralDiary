package com.tianyuan.ruraldiary.presenter.iview;

import android.widget.EditText;

/**
 *创建日记UI操作
 */
public interface ICreateDiaryView {
    /**
     * 打印Toast
     * @param msg success | failure
     */
    void showToast(String msg);

    /**
     * 初始化控件
     * 注册监听
     */
    void initViews();

    /**
     * 获取标题控件
     * @return
     */
    EditText getEtDiaryTitle();

    /**
     * 获取内容控件
     * @return
     */
    EditText getetEtDiaryContent();
}

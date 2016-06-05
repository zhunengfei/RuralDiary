package com.tianyuan.ruraldiary.presenter;

/**
 * 创建日记控制器
 */
public interface CreateDiaryPresenter {
    /**
     * 初始化控件
     */
    void onInitView();

    /**
     * 显示提示信息，反馈用户操作的成功与否
     * @param msg
     */
    void showInfo(String msg);

    /**
     * 获取空间上的文字信息
     */
    void getEditTextInfo();

}

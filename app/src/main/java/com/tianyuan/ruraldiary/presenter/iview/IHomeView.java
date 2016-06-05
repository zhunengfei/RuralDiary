package com.tianyuan.ruraldiary.presenter.iview;

/**
 * 主Activity的U操作
 */
public interface IHomeView {
    /**
     * Toast提示
     * @param msg
     */
    void showToast(String msg);

    /**
     * 初始化控件
     */
    void initViews();

    /**
     * 设置RecycleView，布局方式，adapter，数据
     */
    void setRecycleView();

    /**
     * 设置数据源
     */
    void setData();

    /**
     * 显示删除对话框
     * @param position 删除item的位置
     */
    void showRemoveDialog(final int position);

}

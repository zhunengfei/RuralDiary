package com.tianyuan.ruraldiary.presenter;

import android.content.Context;

import com.tianyuan.ruraldiary.bean.Diary;

/**
 * 日记阅读页面控制器
 */
public interface DetailPresenter {
    /**
     * 视图初始化与注册事件
     */
    void onInitView();

    /**
     * 给控件设置数据
     */
    void onSetData();

    /**
     * 更新数据页面
     * @param context
     * @param diary
     */
    void onUpdate(Context context, Diary diary);

}

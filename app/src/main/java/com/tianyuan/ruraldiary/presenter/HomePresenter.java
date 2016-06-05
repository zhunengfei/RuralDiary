package com.tianyuan.ruraldiary.presenter;

import android.content.Context;

import com.tianyuan.ruraldiary.bean.Diary;

import java.util.List;

/**
 * 首页控制器
 */
public interface HomePresenter {
    /**
     * 初始化视图操作
     */
    void initViews();

    /**
     * 刷新数据
     */
    void notifyData();
    /**
     * 初始化数据库
     */
    void initDataBase();

    /**
     * 获取所有日记信息
     */
    List<Diary> getAllDiary();

    /**
     * 删除当前日记
     * @param diary
     */
    void deleteDiary(Diary diary);

    /**
     * 阅读当前日记
     * @param diary
     * @param context 页面上下文
     */
    void readDiary(Context context,Diary diary);

    /**
     * 创建日记
     * @param context 页面上下文
     */
    void createDiary(Context context);
}

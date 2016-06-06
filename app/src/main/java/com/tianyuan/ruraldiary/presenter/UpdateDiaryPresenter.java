package com.tianyuan.ruraldiary.presenter;

import android.support.v7.app.AppCompatActivity;

/**
 * 更新日记控制层
 */
public interface UpdateDiaryPresenter {
    /**
     * 初始化控件
     */
    void onInitView();
    /**
     * 初始设置数据给控件
     */
    void onSetData();

    /**
     * 保存修改后的数据
     * @param context 上下文对象
     */
    void onSaveData(AppCompatActivity context);
}

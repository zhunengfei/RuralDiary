package com.tianyuan.ruraldiary.ui.adapter;

import android.view.View;

/**
 * DiaryAdapter的回调接口，处理点击事件
 */
public interface IonItemClickLister {
    /**
     * 单击
     * @param view
     * @param position
     */
    void onItemClick(View view , int position);

    /**
     * 长点击
     * @param view
     * @param position
     */
    void  onItemLongClick(View view,int position);
}

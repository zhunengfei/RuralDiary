package com.tianyuan.ruraldiary.biz;

import com.tianyuan.ruraldiary.bean.Diary;

import java.util.List;

/**
 * 日记操作
 */
public interface IDiary {
    /**
     * 获取所有日记
     * @return
     */
    List<Diary> getAllDiary();

    /**
     * 删除当前日记
     * @param diary
     */
    void deleteDiary(Diary diary);

    /**
     * 添加一条日记
     * @param diary
     */
    void insertDiary(Diary diary);

    /**
     * 更新id==id的日记
     * @param id
     * @param diary
     */
    void updateDiary(int id,Diary diary);
}

package com.tianyuan.ruraldiary.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tianyuan.ruraldiary.bean.Diary;
import com.tianyuan.ruraldiary.util.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库操作业务类
 */
public class DiaryImpl implements IDiary{
    private static DataBaseHelper dataBaseHelper=null;
    private SQLiteDatabase sqLiteDatabase=null;
    private Context context;
    public DiaryImpl(){

    }
    public DiaryImpl(Context context){
        this.context=context;
        dataBaseHelper = new DataBaseHelper(context);
    }
    public static DataBaseHelper getDataBaseHelper(){
        return dataBaseHelper;
    }

    @Override
    public List<Diary> getAllDiary() {
        //日记集合
        List<Diary> diaryList=new ArrayList<Diary>();
        //获取可读数据库
        sqLiteDatabase=dataBaseHelper.getReadableDatabase();
        //查询表中所有数据
        Cursor cursor=sqLiteDatabase.query("diary",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do {
                int id=cursor.getInt(cursor.getColumnIndex("id"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String content = cursor.getString(cursor.getColumnIndex("content"));
                String createtime = cursor.getString(cursor.getColumnIndex("createtime"));
                String week=cursor.getString(cursor.getColumnIndex("week"));
                Diary diary=new Diary();
                diary.setId(id);
                diary.setTitle(title);
                diary.setContent(content);
                diary.setCreatetime(createtime);
                diary.setWeek(week);
                diaryList.add(diary);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return diaryList;
    }

    @Override
    public void deleteDiary(Diary diary) {
        String title=diary.getTitle();
        sqLiteDatabase=dataBaseHelper.getWritableDatabase();
        sqLiteDatabase.delete("diary","title = ?",new String[]{title});
    }

    @Override
    public void insertDiary(Diary diary) {
        sqLiteDatabase=dataBaseHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("title",diary.getTitle());
        values.put("content",diary.getContent());
        values.put("week",diary.getWeek());
        values.put("createtime",diary.getCreatetime());
        sqLiteDatabase.insert("diary",null,values);
        values.clear();
    }

    @Override
    public void updateDiary(int id,Diary diary) {
        sqLiteDatabase=dataBaseHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("title",diary.getTitle());
        contentValues.put("content",diary.getContent());
        contentValues.put("week",diary.getWeek());
        contentValues.put("createtime",diary.getCreatetime());
        sqLiteDatabase.update("diary",contentValues,"id=?",new String[]{String.valueOf(id)});
    }

}

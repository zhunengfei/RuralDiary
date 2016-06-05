package com.tianyuan.ruraldiary.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库操作帮助类
 */
public class DataBaseHelper extends SQLiteOpenHelper{
    //建表语句
    private static final String sql="create table diary" +
            "(id Integer primary key autoincrement," +
            "title text," +
            "content text," +
            "createtime text," +
            "week text)";
    public DataBaseHelper(Context context) {
        super(context, "diary", null, 1);
    }
    public DataBaseHelper(Context context, int version) {
        super(context, "diary", null, version);
    }

    /**
     * 创建数据库
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql);
        ContentValues cv = new ContentValues();
        cv.put("title", "欢迎使用");
        cv.put("content", "你的第一条日记");
        cv.put("createtime", "2016-05-31");
        cv.put("week", "星期二-12:00");
        sqLiteDatabase.insert("diary", null, cv);//执行插入操作
    }

    /**
     * 升级数据库
     * @param sqLiteDatabase
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exists Diary");
        onCreate(sqLiteDatabase);
    }
}

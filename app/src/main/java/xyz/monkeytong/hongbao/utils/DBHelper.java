package xyz.monkeytong.hongbao.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import xyz.monkeytong.hongbao.enums.ActivityEnum;

/**
 * 数据库操作
 * Created by pangpeijie on 17/1/17.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "WeChatLuckyMoney";

    //红包日志表
    //private static final String createDatabaseSQL = "CREATE TABLE IF NOT EXISTS HongbaoLog (id INTEGER PRIMARY KEY AUTOINCREMENT, sender TEXT, content TEXT, time TEXT, amount TEXT);";
    //激活表
    private static final String createActiveSql = "CREATE TABLE IF NOT EXISTS Activate (id INTEGER PRIMARY KEY AUTOINCREMENT,active_status TEXT, first_time TEXT, actice_time TEXT);";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //sqLiteDatabase.execSQL(createDatabaseSQL);
        sqLiteDatabase.execSQL(createActiveSql);
        sqLiteDatabase.execSQL("INSERT INTO Activate(active_status,first_time) VALUES('"+ ActivityEnum.NOTACTIVITY.getCode()+"',datetime('now'));");//插入初始状态
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //String hongbaoLogql = "DROP TABLE IF EXISTS HongbaoLog";
        String createActiveSql = "DROP TABLE IF EXISTS Activate";
        //sqLiteDatabase.execSQL(hongbaoLogql);
        sqLiteDatabase.execSQL(createActiveSql);
        onCreate(sqLiteDatabase);
    }
}

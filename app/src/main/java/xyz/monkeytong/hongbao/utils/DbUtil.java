package xyz.monkeytong.hongbao.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import xyz.monkeytong.hongbao.entity.ActiveStatus;

public class DbUtil {
    private Context context;
    private SQLiteDatabase database;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "WeChatLuckyMoney.db";
    //红包日志表
    private static final String createDatabaseSQL = "CREATE TABLE IF NOT EXISTS HongbaoLog (id INTEGER PRIMARY KEY AUTOINCREMENT, sender TEXT, content TEXT, time TEXT, amount TEXT);";
    //激活表
    private static final String createActiveSql = "CREATE TABLE IF NOT EXISTS Activate (active_status TEXT, first_time TEXT, actice_time TEXT);";

    public DbUtil(final Context context) {
        this.context = context;
        this.initSchemaAndDatabase();
    }

    private void initSchemaAndDatabase() {
        this.database = context.openOrCreateDatabase(DATABASE_NAME, context.MODE_PRIVATE, null);
        this.database.beginTransaction();
        this.database.execSQL(createDatabaseSQL);
        this.database.execSQL(createActiveSql);
        this.database.execSQL("INSERT INTO Activate(active_status,first_time) VALUES(\"notActive\",datetime('now'));");//插入初始状态
        this.database.endTransaction();
    }

    /**
     * 写红包日志
     * @param sender
     * @param content
     * @param amount
     */
    public void writeHongbaoLog(String sender, String content, String amount) {

    }

    /**
     * 获取所有的红包
     */
    public void getAllHongbaoLog() {

    }

    /**
     * 获取激活状态
     */
    public List<ActiveStatus> getActiveStatus(){
        Cursor cursor = database.query("Activate",
                new String[]{"active_status","first_time","actice_time"}, null, null, null, null, null);
        if (cursor.getCount() > 0) {
            List<ActiveStatus> activeStatusList = new ArrayList<ActiveStatus>(cursor.getCount());
            while (cursor.moveToNext()) {
                SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                ActiveStatus activeStatus = new ActiveStatus();
                activeStatus.setStatus(cursor.getString(0));
                try{
                    activeStatus.setFirstTime(dateformat.parse(cursor.getString(1)));
                    activeStatus.setActiceTime(dateformat.parse(cursor.getString(2)));
                }catch (Exception ex){}
                activeStatusList.add(activeStatus);
            }
            return activeStatusList;
        }
        return null;
    }
}

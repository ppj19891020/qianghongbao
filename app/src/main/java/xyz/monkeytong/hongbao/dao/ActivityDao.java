package xyz.monkeytong.hongbao.dao;

import android.content.Context;
import android.database.Cursor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import xyz.monkeytong.hongbao.entity.ActiveStatus;
import xyz.monkeytong.hongbao.utils.DBHelper;

/**
 * Created by pangpeijie on 17/1/17.
 */

public class ActivityDao {

    private Context context;

    private DBHelper dbHelper;

    public ActivityDao(Context context){
        this.context = context;
        dbHelper = new DBHelper(context);
    }

    public ActiveStatus getActiveStatus(){
        Cursor cursor = dbHelper.getReadableDatabase().query("Activate",
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
            return activeStatusList.get(0);
        }
        return null;
    }

}

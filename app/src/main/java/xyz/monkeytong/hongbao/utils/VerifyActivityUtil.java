package xyz.monkeytong.hongbao.utils;

import java.util.Date;

import xyz.monkeytong.hongbao.entity.ActiveStatus;
import xyz.monkeytong.hongbao.enums.ActivityEnum;

/**
 * 验证是否有效
 * Created by pangpeijie on 17/1/17.
 */
public class VerifyActivityUtil {

    public static boolean verifyActivityStatus(ActiveStatus activeStatus){
        boolean bol = false;
        if(null == activeStatus){
            return bol;
        }
        if(activeStatus.getStatus().equals(ActivityEnum.NOTACTIVITY.getCode())){
            Date nowDate = new Date();
            long day=(nowDate.getTime()-activeStatus.getFirstTime().getTime())/(24*60*60*1000);
            if(day <= 3){
                //未激活状态,试用期3天
                return true;
            }else{
                return false;
            }
        }
        return bol;
    }

}

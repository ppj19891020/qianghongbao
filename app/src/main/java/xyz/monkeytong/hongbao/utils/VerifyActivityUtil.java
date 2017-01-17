package xyz.monkeytong.hongbao.utils;

import java.util.Date;

import xyz.monkeytong.hongbao.entity.ActiveStatus;
import xyz.monkeytong.hongbao.enums.ActivityEnum;

/**
 * 验证是否有效
 * Created by pangpeijie on 17/1/17.
 */
public class VerifyActivityUtil {

    /**
     * 最大3天试用期
     */
    private static int maxDay = 3;

    /**
     * 获取激活状态
     * @param activeStatus
     * @return
     */
    public static boolean verifyActivityStatus(ActiveStatus activeStatus){
        boolean bol = false;
        if(null == activeStatus){
            return bol;
        }
        if(activeStatus.getStatus().equals(ActivityEnum.NOTACTIVITY.getCode())){
            Date nowDate = new Date();
            long day=(nowDate.getTime()-activeStatus.getFirstTime().getTime())/(24*60*60*1000);
            if(day <= maxDay){
                //未激活状态,试用期3天
                return true;
            }else{
                return false;
            }
        }
        return bol;
    }

    /**
     * 获取激活状态字符串
     * @param activeStatus
     * @return
     */
    public static String verifyActivityStatusStr(ActiveStatus activeStatus){
        String str = null;
        if(null == activeStatus){
            str = "未激活";
            return str;
        }
        if(activeStatus.getStatus().equals(ActivityEnum.NOTACTIVITY.getCode())){
            Date nowDate = new Date();
            long day=(nowDate.getTime()-activeStatus.getFirstTime().getTime())/(24*60*60*1000);
            if(day <= maxDay){
                //未激活状态,试用期3天
                return "试用期3天(剩余天数"+(maxDay-day)+"天)";
            }else{
                return "已激活";
            }
        }
        return str;
    }
}

package xyz.monkeytong.hongbao.entity;

import java.util.Date;

/**
 * 激活状态实体
 * Created by pangpeijie on 17/1/17.
 */
public class ActiveStatus {

    /**
     * 状态:
     */
    private String status;

    /**
     * 安装时间
     */
    private Date firstTime;

    /**
     * 激活时间
     */
    private Date acticeTime;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public Date getActiceTime() {
        return acticeTime;
    }

    public void setActiceTime(Date acticeTime) {
        this.acticeTime = acticeTime;
    }
}

package xyz.monkeytong.hongbao.enums;

/**
 * 激活状态
 * Created by pangpeijie on 17/1/17.
 */
public enum ActivityEnum {
    NOTACTIVITY("notActive","未激活"),
    ACTIVITY("Active","激活");

    private String code;
    private String desc;

    ActivityEnum(String code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

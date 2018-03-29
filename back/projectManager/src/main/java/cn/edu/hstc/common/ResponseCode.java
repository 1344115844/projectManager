package cn.edu.hstc.common;

/**
 * 状态码
 */
public enum ResponseCode {

    SUCCESS(200,"SUCCESS"),
    ERROR(400,"ERROR"),
    NEED_LOGIN(401,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(402,"ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;


    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}

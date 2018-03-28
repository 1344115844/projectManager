package cn.edu.hstc.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 *服务器端返回JSON数据的格式是统一的，封装成JSONResponse这个类
 */
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失
public class JSONResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;

    private JSONResponse(int status){
        this.status = status;
    }
    private JSONResponse(int status,T data){
        this.status = status;
        this.data = data;
    }

    private JSONResponse(int status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private JSONResponse(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus(){
        return status;
    }
    public T getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }


    public static <T> JSONResponse<T> createBySuccess(){
        return new JSONResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> JSONResponse<T> createBySuccessMessage(String msg){
        return new JSONResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> JSONResponse<T> createBySuccess(T data){
        return new JSONResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> JSONResponse<T> createBySuccess(String msg,T data){
        return new JSONResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }


    public static <T> JSONResponse<T> createByError(){
        return new JSONResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }


    public static <T> JSONResponse<T> createByErrorMessage(String errorMessage){
        return new JSONResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> JSONResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new JSONResponse<T>(errorCode,errorMessage);
    }


}

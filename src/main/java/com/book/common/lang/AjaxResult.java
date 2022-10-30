package com.book.common.lang;


import com.book.common.utils.StringUtils;
import lombok.Data;



import java.util.HashMap;

/**
 * @author zcz
 * @created 2022/9/15 16:39
 */
public class AjaxResult<T>
{
    private static final long serialVersionUID = 1L;

    //    /** 状态码 */
//    public static final String CODE_TAG = "code";
//
//    /** 返回内容 */
//    public static final String MSG_TAG = "msg";
//
//    /** 数据对象 */
//    public static final String DATA_TAG = "data";
//
//    /**
//     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
//     */
    //状态码
    private int code;

    //返回内容
    private String msg;

    //数据对象
    private T data;

    public AjaxResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg 返回内容
     */
//    public AjaxResult(int code, String msg)
//    {
//        super.put(CODE_TAG, code);
//        super.put(MSG_TAG, msg);
//    }
//
//    /**
//     * 初始化一个新创建的 AjaxResult 对象
//     *
//     * @param code 状态码
//     * @param msg 返回内容
//     * @param data 数据对象
//     */
//    public AjaxResult(int code, String msg, Object data)
//    {
//        super.put(CODE_TAG, code);
//        super.put(MSG_TAG, msg);
//        if (StringUtils.isNotNull(data))
//        {
//            super.put(DATA_TAG, data);
//        }
//    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static AjaxResult success()
    {
        return  AjaxResult.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static<T> AjaxResult success(T data)
    {
        return AjaxResult.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static AjaxResult success(String msg)
    {
        return AjaxResult.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static<T> AjaxResult success(String msg, T data)
    {
        return new AjaxResult(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static AjaxResult error()
    {
        return AjaxResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static AjaxResult error(String msg)
    {
        return AjaxResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static<T> AjaxResult error(String msg, T data)
    {
        return new AjaxResult(HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg 返回内容
     * @return 警告消息
     */
    public static AjaxResult error(int code, String msg)
    {
        return new AjaxResult(code, msg, null);
    }

//    /**
//     * 方便链式调用
//     *
//     * @param key 键
//     * @param value 值
//     * @return 数据对象
//     */
//    @Override
//    public AjaxResult put(String key, Object value)
//    {
//        super.put(key, value);
//        return this;
//    }

    public static AjaxResult custom(boolean ident){
        return ident ? AjaxResult.success() : AjaxResult.error();
    }
}
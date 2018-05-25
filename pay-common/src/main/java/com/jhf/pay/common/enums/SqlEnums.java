package com.jhf.pay.common.enums;

import lombok.Data;
import lombok.Setter;

/**
 * //          佛曰:
 * //                  写字楼里写字间，写字间里程序员；
 * //                  程序人员写程序，又拿程序换酒钱。
 * //                  酒醒只在网上坐，酒醉还来网下眠；
 * //                  酒醉酒醒日复日，网上网下年复年。
 * //                  但愿老死电脑间，不愿鞠躬老板前；
 * //                  奔驰宝马贵者趣，公交自行程序员。
 * //                  别人笑我忒疯癫，我笑自己命太贱；
 * //                  不见满街漂亮妹，哪个归得程序员？
 * Created by yw on 2018/5/23.
 */
public enum  SqlEnums{

    DB_INSERT_RESULT_0(90001001,"数据库操作，insert返回0"),
    DB_UPDATE_RESULT_0(90001002,"数据库操作，update返回0"),
    DB_SELECTONE_IS_NULL(90001003,"数据库操作,selectOne返回null"),
    DB_LIST_IS_NULL(90001004, "数据库操作,list返回null");

    private int code;
    private String msg;

    SqlEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static void main(String[] args) {
        System.out.println(SqlEnums.values());
        SqlEnums[] sqlEnums = SqlEnums.values();
        for (int i = 0; i < sqlEnums.length; i++) {
            SqlEnums sqlEnum = sqlEnums[i];
            System.out.println( sqlEnum.getMsg());
        }
    }
}

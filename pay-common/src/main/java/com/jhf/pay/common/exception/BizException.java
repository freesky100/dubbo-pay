package com.jhf.pay.common.exception;

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
 * Created by yw on 2018/5/17.
 */

/**
 * 可以定义公用的数据库异常
 */
public class BizException extends RuntimeException {

    private int code;
    private String msg;


    /**
     *
     转  换  符
     说    明
     示    例
     %s
     字符串类型
     "mingrisoft"
     %c
     字符类型
     'm'
     %b
     布尔类型
     true
     %d
     整数类型（十进制）
     99
     %x
     整数类型（十六进制）
     FF
     %o
     整数类型（八进制）
     77
     %f
     浮点类型
     99.99
     %a
     十六进制浮点类型
     FF.35AE
     %e
     指数类型
     9.38e+5
     %g
     通用浮点类型（f和e类型中较短的）

     %h
     散列码

     %%
     百分比类型
     ％
     %n
     换行符

     %tx
     日期与时间类型（x代表不同的日期与时间转换符

     * @param code
     * @param format
     * @param args
     */
    public BizException(int code,String format,Object... args){
        this.code=code;
        this.msg = String.format(format,args);
    }

    public BizException(int code,String message){
        this.code=code;
        this.msg = message;
    }

    public BizException() {
        super();
    }


    public BizException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        String res = String.format("%02d元%n %03d分%n %05d里%n",1,3,4);
        String res1= String.format("",1);
        System.out.println(res1);
    }
}

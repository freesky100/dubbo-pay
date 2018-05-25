package com.jhf.pay.service.entity;

import javax.persistence.*;
import java.util.List;

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
 * Created by yw on 2018/5/24.
 */
@Entity
@Table(name="t_dept")
public class Department extends BaseEntity {

    @Column(nullable = false,length = 30)
    private String deptName;
    private Long nums;

    /*
* 三种配置方式：
* 1. @OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.LAZY ,mappedBy="customId")
* mappedBy属性用于双向关联实体时使用，
* mappedBy属性：用在双向关联中，把关系的维护权反转 ； 跟hibernate XML映射中的property-ref一样。
*
* JPA执行步骤：一、插入数据到CUSTOM表，
* 二、执行getAddresses()获取需要持久化的ADDRESS（ADDRESS必须代码设置外键CUSTID），
* 三、插入数据到ADDRESS表
*
* 2.@OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.LAZY )
* JPA执行步骤: 一、插入数据到CUSTOM表，
* 二、执行getAddresses()获取需要持久化的ADDRESS（ADDRESS代码不需要设置外键CUSTID），ADDRESS和CUSTOM关系保存在关联表中；
* 三、插入数据到ADDRESS表
* 四、插入关联信息到CUSTOM_ADDRESS 表中
* 另外关联表的字段对应关系也可以手工设置，
* @JoinTable(name="ref_customer_address",
* joinColumns={@JoinColumn(name="customer_id",referencedColumnName="custId")},
* inverseJoinColumns={@JoinColumn(name="address_id",referencedColumnName="addrId")}
*
* 3.@OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.LAZY )
* @JoinColumn(name="customer_id") 对应的是表中的字段，会在最后一步进行该字段的更新
* 该设置属于单向关联， 该设置需要执行三条SQL操作，不推荐；JPA推荐第一种和第二种做法；
* JPA执行步骤如下：一、插入数据到CUSTOM表，
* 二、执行getAddresses()获取需要持久化的ADDRESS（ADDRESS必须代码设置外键CUSTID或者将外键属性设置为可以为空），
* 三、插入数据到ADDRESS表
* 四、 然后再UPDATE ADDRESS 设置外键关系customer_id
*
* 4.另外多端需要初始化一个空数组
* private Collection<Address> addresses = new ArrayList<Address>();
*
* */
    /**
     *  ·CascadeType.PERSIST （级联新建）
     ·CascadeType.REMOVE （级联删除）
     ·CascadeType.REFRESH （级联刷新）
     ·CascadeType.MERGE （级联更新）中选择一个或多个。

     此种方式是外键关联建表方式
     后面属性可以默认
     */
//    @ManyToOne()
//    @JoinColumn(name="uid")
    /**
     * 映射策略——表关联 建立中间表 user_dept_relative 表，
     */
//    @OneToMany()
//    @JoinTable(name="user_dept_relative",
//            joinColumns = {@JoinColumn(name="uid",referencedColumnName = "id")},
//             inverseJoinColumns = {@JoinColumn(name="deptid",referencedColumnName = "id")})
    /**
     *
     * 如果先建表，为表关联关系，同时在关联表中建立了外检的约束，这可以直接默认oneTomany
     */
//    private User user;




}

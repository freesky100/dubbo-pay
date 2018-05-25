package com.jhf.pay.service.entity;

import com.jhf.pay.common.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;

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
@Data
@Entity
@Table(name="t_user")
public class User extends BaseEntityJpa {

    @Column(length = 20,nullable = false)
    private String userName;

    @Column(length = 2)
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Sex sex;
    //和主表具有同等生命周期
    @Embedded
    private Address address;


    /**
     * # 外键关联：两个表的关系定义在一个表中；
     # 表关联：两个表的关系单独定义一个表中通过一个中间表来关联。
     *
     */
//    @OneToMany
//    @JoinColumn(name = "dept_id")
//    private Department department;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idcard_id")
    private IdentityCard identityCard;


}

package com.jhf.pay.service.impl;

import com.jhf.pay.service.dao.UserDao;
import com.jhf.pay.service.entity.Address;
import com.jhf.pay.service.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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
public class UserDaoImplBySpringTest extends SpringTestBase {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindById(){
        System.out.println(userDao);
        User user = userDao.findById(1);
        Assert.assertNotNull(user);
    }

    @Test
    public void tsetSaveUser(){
        User user= new User();
        user.setUserName("张三");
        user.setAge(11);
        Address address = new Address();
        address.setHome("家的味道");
        userDao.save(user);
        System.out.println(user);
    }


    @Test
    public void TestBatchSave(){
        User user = new User();
        user.setUserName("李四");
        user.setAge(11);
        User user1 = new User();
        user1.setUserName("王五");
        user1.setAge(12);
        List<User> list = new ArrayList();
        list.add(user);
        list.add(user1);
//        userDao.batchSave(list);

    }



}

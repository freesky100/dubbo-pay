package com.jhf.pay.service.impl;

import com.jhf.pay.service.UserService;
import com.jhf.pay.service.dao.UserDao;
import com.jhf.pay.service.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


    @Override
    public User findById(long id) {
      User user =  userDao.findById(id);
       return user;
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public long batchSave(List<User> userList) {
//        return userDao.batchSave(userList);
        return 1;
    }
}

package com.jhf.pay.dao.impl;

import com.jhf.pay.common.framework.dao.BaseDaoImpl;
import com.jhf.pay.dao.UserInfoDao;
import com.jhf.pay.facade.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@Repository("userInfoDao")
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo> implements UserInfoDao {

    @Override
    public UserInfo findByPhone(String phone){
        Map<String,Object> map = new HashMap<>();
        map.put("phone",phone);
        return super.getByParam(map);
    }



}

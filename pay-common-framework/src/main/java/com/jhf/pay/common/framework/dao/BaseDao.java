package com.jhf.pay.common.framework.dao;

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

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

/**
 * 数据库采用mybatis
 * 基本接口
 *
 * @param <T>
 */
public interface BaseDao<T> {


    public long insert(T t);

    public long insert(List<T> list);

    public long update(T t);

    public long update(List<T> list);

    T getById(long id);

    T getByParam(Map<String,Object> map);

    List<T> getAll();

    List<T> getListBy(Map<String,Object> map);


    long deleteById(long id);

    String getSeqNextValue(String seqName);


    SqlSessionTemplate getSessionTemplate();

    SqlSession getSqlSession();


}

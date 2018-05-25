package com.jhf.pay.common.framework.dao;

import com.jhf.pay.common.entity.BaseEntity;
import com.jhf.pay.common.entity.BaseEntityJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
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

/**
 * 自定义接口，主要改写jpa中save方法，del方法，当然前提T extends BaseEntity
 * @param <T>
 * @param <ID>
 */
public interface BaseRepository<T extends BaseEntityJpa,ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T> {
    public long batchSave(List<T>list);
}

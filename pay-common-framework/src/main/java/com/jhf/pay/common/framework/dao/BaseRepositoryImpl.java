package com.jhf.pay.common.framework.dao;

import com.jhf.pay.common.entity.BaseEntityJpa;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.sql.Timestamp;
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
 * Created by yw on 2018/5/25.
 */
public class BaseRepositoryImpl<T extends BaseEntityJpa,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements BaseRepository<T,ID> {

    private final EntityManager entityManager;


    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public void delete(ID id) {
        T entity = findOne(id);
        entity.setModifiedTime(new Timestamp(System.currentTimeMillis()));
        super.delete(id);
    }

    @Override
    public <S extends T> S save(S entity) {
        entity.setModifiedTime(new Timestamp(System.currentTimeMillis()));
        return super.save(entity);
    }

    @Override
    public long batchSave(List<T> list) {
        long total = 0;
        for (int i = 0; i < list.size(); i++) {
            T t = list.get(i);
           super.save(t);
            total++;
        }
        return total;
    }

    //
//    public BaseRepostitoryImpl(Class<T> domainClass, EntityManager em) {
//        super(domainClass, em);
//    }





}

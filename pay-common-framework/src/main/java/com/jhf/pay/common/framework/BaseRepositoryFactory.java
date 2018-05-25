package com.jhf.pay.common.framework;

import com.jhf.pay.common.entity.BaseEntity;
import com.jhf.pay.common.entity.BaseEntityJpa;
import com.jhf.pay.common.framework.dao.BaseRepository;
import com.jhf.pay.common.framework.dao.BaseRepositoryImpl;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;

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
public class BaseRepositoryFactory<T extends JpaRepository<S,ID>,S ,ID extends BaseEntity> extends JpaRepositoryFactoryBean<T,S,ID>{
    public BaseRepositoryFactory(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new JpaRepositoryFactory(entityManager){
            @Override
            protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {
                Class<T> domainClass = (Class<T>) information.getDomainType();
                if(BaseEntity.class.isAssignableFrom(domainClass)){
                    return new BaseRepositoryImpl(domainClass,entityManager);
                }else{
                    return new SimpleJpaRepository(domainClass,entityManager);
                }
            }

            @Override
            protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
                return metadata.getDomainType().isAssignableFrom(BaseEntityJpa.class)? BaseRepositoryImpl.class:SimpleJpaRepository.class;
            }
        };
    }
}

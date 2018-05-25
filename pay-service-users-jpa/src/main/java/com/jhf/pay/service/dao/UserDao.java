package com.jhf.pay.service.dao;

import com.jhf.pay.common.framework.dao.BaseRepository;
import com.jhf.pay.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.RepositoryDefinition;

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


//public interface UserDao extends Repository<AccountInfo, Long> { …… }
//等价的2中方式
//@RepositoryDefinition(domainClass = AccountInfo.class, idClass = Long.class)
//public interface UserDao { …… }
public interface UserDao extends JpaRepository<User,Long> {

    public User findById(long id);

    public User save(User user);

}

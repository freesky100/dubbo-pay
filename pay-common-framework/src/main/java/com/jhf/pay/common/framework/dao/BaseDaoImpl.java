package com.jhf.pay.common.framework.dao;

import com.jhf.pay.common.entity.BaseEntity;
import com.jhf.pay.common.enums.SqlEnums;
import com.jhf.pay.common.exception.BizException;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
public class BaseDaoImpl<T extends BaseEntity> extends SqlSessionDaoSupport implements BaseDao<T> {

    private static final Logger log = LoggerFactory.getLogger(BaseDaoImpl.class);



    public static final String SQL_INSERT = "insert";
    public static final String SQL_BATCH_INSERT = "batchInsert";
    public static final String SQL_UPDATE = "update";
    public static final String SQL_GET_BY_ID = "getById";
    public static final String SQL_DELETE_BY_ID = "deleteById";
    public static final String SQL_GET_ALL_ID = "getAll";
    public static final String SQL_GET_LIST_ID = "getList";
    public static final String SQL_GET_PARAM_ID = "getParam";
    public static final String SQL_LIST_PAGE = "listPage";
    public static final String SQL_LIST_BY = "listBy";
    public static final String SQL_COUNT_BY_PAGE_PARAM = "countByPageParam"; // 根据当前分页参数进行统计

    /**
     * 简单的使用spring的对象
     */
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public long insert(T t) {
        if(t==null){
            throw new RuntimeException(t +"is  null");
        }
        int result = sqlSessionTemplate.insert(getStatement(SQL_INSERT),t);
        if(result<=0){
            throw new BizException(SqlEnums.DB_INSERT_RESULT_0.getCode(),SqlEnums.DB_INSERT_RESULT_0.getMsg());
        }
        if(t!=null && t.getId()!=null && result>0)
            return t.getId();
        return result;
    }

    public long insert(List<T> list) {

        if (list == null || list.size() <= 0)
            return 0;

        int result = sqlSessionTemplate.insert(getStatement(SQL_BATCH_INSERT), list);

        if (result <= 0)
            throw new BizException(SqlEnums.DB_INSERT_RESULT_0.getCode(),SqlEnums.DB_INSERT_RESULT_0.getMsg());

        return result;
    }

    @Override
    public long update(T t) {
        if (t == null)
            throw new RuntimeException("T is null");

        int result = sqlSessionTemplate.update(getStatement(SQL_UPDATE), t);

        if (result <= 0)//此处注意幂等操作，是否要抛异常
            throw new BizException(SqlEnums.DB_UPDATE_RESULT_0.getCode(),SqlEnums.DB_UPDATE_RESULT_0.getMsg());

        return result;
    }

    @Override
    public long update(List<T> list) {

        if (list == null || list.size() <= 0)
            return 0;

        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            this.update(list.get(i));
            result += 1;
        }

        if (result <= 0)
            throw new BizException(SqlEnums.DB_UPDATE_RESULT_0.getCode(),SqlEnums.DB_UPDATE_RESULT_0.getMsg());
        return result;
    }

    @Override
    public T getById(long id) {
        return sqlSessionTemplate.selectOne(getStatement(SQL_GET_BY_ID),id);
    }


    @Override
    public long deleteById(long id) {
        return sqlSessionTemplate.delete(getStatement(SQL_DELETE_BY_ID),id);
    }


    @Override
    public String getSeqNextValue(String seqName) {
        return null;
    }

    @Override
    public SqlSessionTemplate getSessionTemplate() {
        return this.sqlSessionTemplate;
    }

    @Override
    public List<T> getAll() {
        return sqlSessionTemplate.selectList(getStatement(SQL_GET_ALL_ID));
    }

    public String getStatement(String sqlId){
        //决定了mapper.xml namespace中的值
        String name = this.getClass().getName();
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(".").append(sqlId);
        return sb.toString();
    }

    @Override
    public List<T> getListBy(Map<String,Object> map) {
        return this.sqlSessionTemplate.selectList(getStatement(SQL_GET_LIST_ID),map);
    }

    @Override
    public T getByParam(Map<String, Object> map) {
        return this.sqlSessionTemplate.selectOne(getStatement(SQL_GET_PARAM_ID),map);
    }

    @Override
    public SqlSession getSqlSession() {
        return getSqlSession();
    }
}

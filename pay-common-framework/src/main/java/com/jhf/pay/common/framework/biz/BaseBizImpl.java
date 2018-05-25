package com.jhf.pay.common.framework.biz;

import com.jhf.pay.common.entity.BaseEntity;
import com.jhf.pay.common.framework.dao.BaseDao;

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
public abstract class BaseBizImpl<T extends BaseEntity> implements BaseBiz<T> {

    protected abstract  BaseDao<T> getDao();
//    protected BaseDao<T> baseDao;

    @Override
    public long create(T t) {
       return getDao().insert(t);
    }

    @Override
    public long create(List<T> list) {
        return getDao().insert(list);
    }

    @Override
    public long update(T t) {
        return getDao().update(t);
    }

    @Override
    public long update(List<T> list) {
        return getDao().update(list);
    }

    @Override
    public long deleteById(long id) {
        return getDao().deleteById(id);
    }

    @Override
    public T getById(long id) {
        return getDao().getById(id);
    }

    @Override
    public List<T> getAll() {
        return getDao().getAll();
    }

    @Override
    public List<T> getListBy(Map<String,Object> map) {
        return getDao().getListBy(map);
    }

    @Override
    public String getSeqNextValue(String seqName) {
        return getDao().getSeqNextValue(seqName);
    }
}

package com.ztesoft.zsmartcity.cc.framework.dao;

import java.io.Serializable;

public interface IBaseDAO <E, PK extends Serializable>{
	 /**
     * 根据主键查找记录
     * 
     * @param id
     *            主键
     * @return 符合条件的记录
     */
    Object getById(PK id);

    /**
     * 根据主键删除记录
     * 
     * @param id
     *            主键
     * @return 删除的记录条数
     */
    int deleteById(PK id);

    /**
     * 保存一条记录
     * 
     * @param entity
     *            需要保存的对象
     * 
     * @return 插入的记录条数
     * 
     */
    int save(E entity);

    /**
     * 更新记录
     * 
     * @param entity
     *            需要执行更新操作的对象
     * 
     * @return 更新的记录条数
     * 
     */
    int update(E entity);

    /**
     * 根据业务逻辑判断保存或更新
     * 
     * @param entity
     *            需要操作的对象
     */
    void saveOrUpdate(E entity);

    /**
     * 检查某列数据是否唯一
     * 
     * @param entity
     *            查询条件对象
     * @param uniquePropertyNames
     *            列名
     * @return 唯一时返回true,否则返回false
     */
    boolean isUnique(E entity, String uniquePropertyNames);

    /**
     * 用于hibernate.flush()
     */
    void flush();

}

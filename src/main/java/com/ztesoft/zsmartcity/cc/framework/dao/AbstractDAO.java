package com.ztesoft.zsmartcity.cc.framework.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.support.DaoSupport;
import org.springframework.util.Assert;



public abstract class AbstractDAO <E, PK extends Serializable> extends
DaoSupport implements IBaseDAO<E, PK>{
	// xu_kai 2013-09-01 end
    /** 封装好的Session工厂对象 */
    @Resource(name="ccSqlSessionFactory")
    private DefaultSqlSessionFactory sqlSessionFactory;

    /** 封装好的Session模板对象 */
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 断言sqlSessionFactory不为空
     */
    protected void checkDaoConfig() {
        Assert.notNull(sqlSessionFactory, "sqlSessionFactory must be not null");
    }

    /**
     * 插入或更新操作的空实现，请在子类根据实际业务情况覆盖
     * 
     * @param entity
     *            待插入或者更新的对象
     */
    public void saveOrUpdate(E entity) {
    }

    /**
     * 获得session工厂对象
     * 
     * @return session工厂对象
     * 
     */
    public DefaultSqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    /**
     * 根据session工厂对象创建 session模板
     * 
     * @param factory
     *            session工厂对象
     * 
     */
    public void setSqlSessionFactory(DefaultSqlSessionFactory factory) {
        this.sqlSessionFactory = factory;
   
           try {
			this.sqlSessionTemplate = new SqlSessionTemplate(this.sqlSessionFactory);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * 获得session模板对象
     * 
     * @return session模板对象
     * 
     */
    public SqlSessionTemplate getSqlSessionTemplate() {
        if (null == this.sqlSessionTemplate) {
            try {
				this.sqlSessionTemplate = new SqlSessionTemplate(
						this.sqlSessionFactory);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return this.sqlSessionTemplate;
    }

    /**
     * setter of sqlSessionTemplate
     * 
     * @param sessionTemplate
     *            SqlSessionTemplate
     */
    public void setSqlSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sqlSessionTemplate = sessionTemplate;
    }

    /**
     * 根据ID查找记录
     * 
     * @param primaryKey
     *            条件ID
     * 
     * @return 找到的记录
     * 
     */
    public Object getById(PK primaryKey){
        Object object = null;
      
            object = getSqlSessionTemplate().selectOne(
                    getFindByPrimaryKeyStatement(), primaryKey);
      
        return object;
    }

    /**
     * 根据自定义条件查找记录
     * 
     * @param statement
     *            自定义的sql_id，不含包名
     * 
     * @param condition
     *            查询条件对象
     * 
     * @return 找到的一条，当符合条件的记录有多条时，会发生错误
     * 
     */
    public Object selectOne(String statement, Object condition) {
        Object object = null;
     
            object = getSqlSessionTemplate().selectOne(
                    getMbatisMapperNamesapce() + "." + statement, condition);
       
        return object;
    }

    /**
     * 根据ID删除记录
     * 
     * @param id
     *            条件ID
     * 
     * @return 删除的记录条数
     * 
     */
    public int deleteById(PK id) {
        int affectCount = 0;
      
            affectCount = getSqlSessionTemplate().delete(getDeleteStatement(),
                    id);
       
        return affectCount;
    }

    /**
     * 根据自定义条件删除记录
     * 
     * @param condition
     *            删除条件对象
     * 
     * @param statement
     *            自定义的sql_id，不含包名
     * 
     * @return 删除的记录条数
     * 
     */
    public int delete(String statement, Object condition) {
        int affectCount = 0;
     
            affectCount = getSqlSessionTemplate().delete(
                    getMbatisMapperNamesapce() + "." + statement, condition);
        
        return affectCount;
    }

    /**
     * 保存记录
     * 
     * @param entity
     *            需要保存的对象或者对象列表
     * 
     * @return 实际插入的记录数
     * 
     */
    public int save(E entity) {
        prepareObjectForSaveOrUpdate(entity);
        int affectCount = 0;
       
            affectCount = getSqlSessionTemplate().insert(getInsertStatement(),
                    entity);
       
        return affectCount;
    }

    /**
     * 保存记录
     * 
     * @param entity
     *            需要保存的对象或者对象列表
     * 
     * @param statement
     *            自定义的sql_id，不含包名
     * 
     * @return 实际插入的记录数
     * 
     */
    public int save(String statement, E entity) {
        prepareObjectForSaveOrUpdate(entity);
        int affectCount = 0;
     
            affectCount = getSqlSessionTemplate().insert(
                    getMbatisMapperNamesapce() + "." + statement, entity);
        
        return affectCount;
    }

    /**
     * 保存记录
     * 
     * @param entity
     *            需要保存的对象或者对象列表
     * 
     * @return 实际插入的记录数
     * 
     */
    public int update(E entity) {
        prepareObjectForSaveOrUpdate(entity);
        int affectCount = 0;
      
            affectCount = getSqlSessionTemplate().update(getUpdateStatement(),
                    entity);
        
        return affectCount;
    }

    /**
     * 更新记录
     * 
     * @param entity
     *            需要保存的对象或者对象列表
     * 
     * @param statement
     *            自定义的sql_id，不含包名
     * 
     * @return 实际插入的记录数
     * 
     */
    public int update(String statement, E entity) {
        prepareObjectForSaveOrUpdate(entity);
        int affectCount = 0;
      
            affectCount = getSqlSessionTemplate().update(
                    getMbatisMapperNamesapce() + "." + statement, entity);
        
        return affectCount;
    }

    /**
     * 用于子类覆盖,在insert,update之前自动调用 可以用来维护外键关系
     * 
     * @param object
     *            需要操作的对象
     * 
     */
    protected void prepareObjectForSaveOrUpdate(E object) {
    }

    /**
     * 回调方法 获得自定义的mybatis namespace
     * 
     * @return 子类覆盖的getMbatisMapperNamesapce返回值
     * 
     */
    public String getMbatisMapperNamesapce() {
        return null;
    }

    /**
     * 系统默认按主键查找对象的sql_id
     * 
     * @return sql_id
     * 
     */
    private String getFindByPrimaryKeyStatement() {
        return getMbatisMapperNamesapce() + ".getById";
    }

    /**
     * 系统默认插入记录的sql_id
     * 
     * @return sql_id
     * 
     */
    private String getInsertStatement() {
        return getMbatisMapperNamesapce() + ".insert";
    }

    /**
     * 系统默认更新记录的sql_id
     * 
     * @return sql_id
     * 
     */
    private String getUpdateStatement() {
        return getMbatisMapperNamesapce() + ".update";
    }

    /**
     * 系统默认删除记录的sql_id
     * 
     * @return sql_id
     * 
     */
    private String getDeleteStatement() {
        return getMbatisMapperNamesapce() + ".delete";
    }

    /**
     * 获得删除记录的sql_id
     * 
     * @param statementName
     *            自定义的sql_id，不含包名
     * 
     * @return sql_id
     * 
     */
    public String getCountStatementForPaging(String statementName) {
        return getMbatisMapperNamesapce() + "." + statementName + "_" + "count";
    }

   

    

    /**
     * 根据查询条件得到集合，支持自定义范围
     * 
     * @param statementName
     *            查询使用的sql_id，不包含包名
     * 
     * @param condition
     *            查询的条件
     * 
     * @param offset
     *            记录起始位置，第一条记录
     * 
     * @param limit
     *            结果集大小
     * 
     * @return 查询到的结果集List
     * 
     */
    @SuppressWarnings("rawtypes")
    public List findList(String statementName, Object condition, int offset,
            int limit) {
        RowBounds rb = new RowBounds(offset, limit);
        List list = null;
        
            list = sqlSessionTemplate.selectList(getMbatisMapperNamesapce()
                    + "." + statementName, condition, rb);
        
        return list;
    }

    /**
     * 根据条件查找所有的记录（不分页）
     * 
     * @param statementName
     *            查询使用的sql_id，不包含包名
     * 
     * @param condition
     *            查询的条件
     * 
     * @return 符合条件的所有记录
     * 
     */
    @SuppressWarnings("rawtypes")
    public List findAll(String statementName, Object condition) {
        List list = null;
   
            list = getSqlSessionTemplate()
                    .selectList(
                            getMbatisMapperNamesapce() + "." + statementName,
                            condition);
       
        return list;
    }

    

    /**
     * 检查一条记录是否是唯一记录，此版本暂不实现
     * 
     * @param entity
     *            查询条件对象
     * 
     * @param uniquePropertyNames
     *            属性/列名
     * 
     * @return 如果记录唯一返回true,否则返回false
     * 
     */
    public boolean isUnique(E entity, String uniquePropertyNames) {
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * 类似于hibernate的flush功能，空实现
     * 
     */
    public void flush() {
    }
}

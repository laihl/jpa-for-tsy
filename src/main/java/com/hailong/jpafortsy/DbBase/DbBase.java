package com.hailong.jpafortsy.DbBase;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hailong.jpafortsy.DbBase.utils.DbUtils;
import com.hailong.jpafortsy.DbBase.utils.SqlInfo;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.defaults.RawLanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.Transaction;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.*;

@Transactional
@Slf4j
public class DbBase implements Dao{

    @Autowired
    DataSource dataSource;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    @Autowired
    private SqlSession SqlSession;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TransactionTemplate transTemplate;

//    @Autowired
//    private void transactionTemplate(DataSource dataSource) {
//        transTemplate = new TransactionTemplate(new DataSourceTransactionManager(dataSource));
//    }

    private Configuration getConfiguration() {
        return sqlSessionFactory.getConfiguration();
    }

    @Transactional
    public <T> void insert(T t) {
        try {
            transTemplate.execute(new TransactionCallback<Object>() {
                @Override
                public Object doInTransaction(TransactionStatus status) {

                    return null;
                }
            });

            SqlInfo sqlInfo = DbUtils.getInsertSql(t);

           MappedStatement mapped = getInserMappedStatment(sqlInfo);



            String sql = mapped.getBoundSql(t).getSql();

            Transaction transaction = getConfiguration().getEnvironment().getTransactionFactory().newTransaction(dataSource,null,false);

            Executor executor = getConfiguration().newExecutor(transaction);

            System.out.println(sql);
            System.out.println(t);

            int update = executor.update(mapped, t);



            System.out.println(update);

        } catch (Throwable e) {
            e.printStackTrace(System.err);
            throw new RuntimeException(e);
        }
    }

    private MappedStatement getInserMappedStatment(SqlInfo sqlInfo) {

        String tempMappedName = sqlInfo.hashCode()+".insert";
        String tempMappedKepName =tempMappedName+"!selectKey";


        String selectKey = "SELECT LAST_INSERT_ID() "+sqlInfo.getIdColumn();
        MappedStatement.Builder keyBuilder = newMappedStatementBuider(tempMappedKepName ,selectKey,JSONObject.class,SqlCommandType.SELECT);
        keyBuilder.keyProperty(sqlInfo.getJFieleName());
        List<ResultMap> resultMapList = new ArrayList<>();
        ResultMapping.Builder mappingBuilder = new ResultMapping.Builder(getConfiguration(), sqlInfo.getJFieleName());
        mappingBuilder.typeHandler(getConfiguration().getTypeHandlerRegistry().getUnknownTypeHandler());
        mappingBuilder.column(sqlInfo.getIdColumn());
        ResultMapping resultMapping = mappingBuilder.build();
        ResultMap resultMap = new ResultMap.Builder(getConfiguration(),tempMappedKepName+"resultMap",Integer.class,Arrays.asList(resultMapping))
                .build();
        resultMapList.add(resultMap);
        keyBuilder.resultMaps(resultMapList);
        MappedStatement.Builder builder = newMappedStatementBuider(tempMappedName ,sqlInfo.getSql(),JSONObject.class,sqlInfo.getSqlType());


        KeyGenerator keyGenerator = new SelectKeyGenerator(keyBuilder.build(),false);
        builder.keyGenerator(keyGenerator);
        return  builder.build();
    }

    private MappedStatement.Builder newMappedStatementBuider(String id, String sql, Class<?> param, SqlCommandType sqlType) {
        LanguageDriver languageDriver = new RawLanguageDriver();
        SqlSource sqlSource = languageDriver.createSqlSource(getConfiguration(), sql, param);
        return new MappedStatement.Builder(getConfiguration(), id, sqlSource, sqlType);
    }


    public static void main(String[] agrs) {

        Configuration config = new Configuration();
        LanguageDriver languageDriver = new RawLanguageDriver();
        SqlSource sqlSource = languageDriver.createSqlSource(config, "select * from t_user where 1=1 and  #{test1}", JSONObject.class);
        MappedStatement.Builder buider = new MappedStatement.Builder(config, "addTest", sqlSource, SqlCommandType.INSERT);
        buider.keyColumn("user_id");
        buider.keyGenerator(new NoKeyGenerator());

        MappedStatement mapped = buider.build();

        Map<String, Object> map = new HashMap<>();
//        map.put("test1", "1");
        String sql = mapped.getBoundSql(map).getSql();
        System.out.println(sql);


    }

}

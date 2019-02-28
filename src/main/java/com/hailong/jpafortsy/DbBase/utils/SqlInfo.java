package com.hailong.jpafortsy.DbBase.utils;

import com.hailong.jpafortsy.bean.ResultAll;
import lombok.Data;
import org.apache.ibatis.mapping.SqlCommandType;

@Data
public class SqlInfo {
    private String sql ;
    private Object[] values;
    private SqlCommandType sqlType;
    private String IdColumn;
    private Object IdValue;
    private Class aClass;
    private String tableName;
    private String jFieleName;

}

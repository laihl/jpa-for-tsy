package com.hailong.jpafortsy.DbBase.utils;

import com.alibaba.fastjson.JSONObject;
import jodd.util.StringUtil;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.defaults.RawLanguageDriver;
import org.apache.ibatis.session.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DbUtils {

    public static <T> SqlInfo getInsertSql(T t) throws IllegalAccessException {
        StringBuffer sqlStrb = new StringBuffer("INSERT INTO ");
        Class<?> aClass = t.getClass();
        Entity table = aClass.getAnnotation(Entity.class);
        if (table == null) {
            throw new RuntimeException(aClass.getCanonicalName() + "未定义 Entity");
        }

        if (StringUtil.isEmpty(table.name())) {
            throw new RuntimeException(aClass.getCanonicalName() + "未定义插入的表名name");
        }

        sqlStrb.append(table.name() + "(");

        List<String> columnList = new ArrayList<>();
        List<String> fielNameList = new ArrayList<>();
        List<Object> valueList = new ArrayList<>();
        boolean hasId = false;
        String IdColumnName = "";
        String IdFieleName = "";
        Object IdColumnValue = "";
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            Column annotation = declaredField.getDeclaredAnnotation(Column.class);

            Id id = declaredField.getDeclaredAnnotation(Id.class);
            if (id != null) {
                IdFieleName=declaredField.getName();
                hasId = true;
                IdColumnName = camel2Underline(declaredField.getName()).toLowerCase();
                IdColumnValue = declaredField.get(t);
                if (IdColumnValue!=null){
                    columnList.add(IdColumnName);
                    valueList.add(IdColumnValue);
                }
            }

            Object value = declaredField.get(t);
            if (annotation != null && value != null) {
                String columnName = StringUtil.isEmpty(annotation.name()) ? camel2Underline(declaredField.getName()).toLowerCase() : annotation.name();
                fielNameList.add(declaredField.getName());
                columnList.add(columnName);
                valueList.add(value);
            }
        }
        if (!hasId) {
            throw new RuntimeException(aClass.getCanonicalName() + "未定义id");
        }

        for (String s : columnList) {
            sqlStrb.append( s+ ",");
        }

        sqlStrb = new StringBuffer(sqlStrb.substring(0, sqlStrb.length() - 1) + ") VALUES(");

        for (String o : fielNameList) {
            sqlStrb.append("#{"+o+"},");
        }
        if (fielNameList.size()==0){
            throw new RuntimeException("未指定插入参数");
        }
        SqlInfo sqlInfo = new SqlInfo();
        sqlInfo.setAClass(t.getClass());
        sqlInfo.setSql(sqlStrb.substring(0,sqlStrb.length()-1)+")");
        sqlInfo.setIdValue(valueList.toArray());
        sqlInfo.setSqlType(SqlCommandType.INSERT);
        sqlInfo.setIdColumn(IdColumnName);
        sqlInfo.setIdValue(IdColumnValue);
        sqlInfo.setTableName(table.name());
        sqlInfo.setJFieleName(IdFieleName);

        return sqlInfo;
    }



    public static String underline2Camel(String line, boolean... smallCamel) {
        if (line == null || "".equals(line)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher = pattern.matcher(line);
        //匹配正则表达式
        while (matcher.find()) {
            String word = matcher.group();
            //当是true 或则是空的情况
            if ((smallCamel.length == 0 || smallCamel[0]) && matcher.start() == 0) {
                sb.append(Character.toLowerCase(word.charAt(0)));
            } else {
                sb.append(Character.toUpperCase(word.charAt(0)));
            }

            int index = word.lastIndexOf('_');
            if (index > 0) {
                sb.append(word.substring(1, index).toLowerCase());
            } else {
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }

    public static String camel2Underline(String line) {
        if (line == null || "".equals(line)) {
            return "";
        }
        line = String.valueOf(line.charAt(0)).toUpperCase()
                .concat(line.substring(1));
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String word = matcher.group();
            sb.append(word.toUpperCase());
            sb.append(matcher.end() == line.length() ? "" : "_");
        }
        return sb.toString();
    }
}

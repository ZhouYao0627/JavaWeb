package com.atguigu.dao.impl;

import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 @author：ZhouYao
 @create：2021-11-19 17:05
 */
public abstract class BaseDao {


    // 使用dbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();


    public int update(String sql, Object... args) {

        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return -1;
    }

    public <T> T queryForOne(String sql, Class<T> type, Object... args) {

        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }


    public <T> List<T> queryForList(String sql, Class<T> type, Object... args) {

        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }


    public Object queryForSingleValue(String sql, Object... args) {

        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }


}






















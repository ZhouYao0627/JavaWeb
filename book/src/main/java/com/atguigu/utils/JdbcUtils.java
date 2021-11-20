package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 @author：ZhouYao
 @create：2021-11-19 16:31
 */
public class JdbcUtils {

    private static DataSource dataSource;

    static {
        try {
            // 提供Properties，并加载指定配置文件的流
            Properties pros = new Properties();

            // 读取jdbc.properties属性配置文件
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载数据
            pros.load(is);

            // 通过DruidDataSourceFactory创建一个数据源
            // 由于静态代码块只执行一次，所以我们自始至终就创建过一个DataSource
            dataSource = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接的方法
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection(){
        // 通过数据源获取连接
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


    /**
     * 关闭连接
     *
     * @param connection
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}

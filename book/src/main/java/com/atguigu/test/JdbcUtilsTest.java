package com.atguigu.test;

import com.atguigu.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 @author：ZhouYao
 @create：2021-11-19 16:59
 */
public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils() {

        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);

        }

    }


}

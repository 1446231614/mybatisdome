package com.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * DCL的单例模式
 */
public class MyBatisUtil {
    //无需将构造方法私有化，因为这里面只要保证之创建一个SqlSessionFactory的对象
   private static  volatile SqlSessionFactory sqlSessionFactory;
   public static SqlSession getSqlSession(){
           try {
               if (sqlSessionFactory == null) {
                   InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
                   synchronized (MyBatisUtil.class) {
                       if (sqlSessionFactory == null) {
                           sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
                       }
                   }
               }
           }catch (IOException e) {
               e.printStackTrace();
           }
           return sqlSessionFactory.openSession();
       }
    }


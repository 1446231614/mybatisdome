package com.mybatis.daoimpl;

import com.mybatis.bean.Student;
import com.mybatis.dao.StudentDao;
import com.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;


public class StudentDaoImpl implements StudentDao {
    public void insertStudent(Student student) {
        //SqlSession实现了AutoCloseable接口，可以自动关闭
           SqlSession sqlSession=MyBatisUtil.getSqlSession();
            //新增操作
            sqlSession.insert("insertStudent",student);

            sqlSession.commit();
            sqlSession.close();
       /* try {
            //读取主配置文件
            InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
            //创建SqlSessionFactory对象
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(input);
            //创建SqlSession对象
            sqlSession = sessionFactory.openSession();
            //新增数据操作
            sqlSession.insert("insertStudent", student);
            //提交SqlSession
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }
         }*/
    }
    public void deleteStudent(int id) {
        SqlSession sqlSession=MyBatisUtil.getSqlSession();
        sqlSession.delete("deleteStudent",id);
        sqlSession.commit();
        sqlSession.close();
    }
}

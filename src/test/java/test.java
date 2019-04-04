
import com.mybatis.bean.Student;
import com.mybatis.dao.StudentDao;
import com.mybatis.daoimpl.StudentDaoImpl;
import org.junit.Before;
import org.junit.Test;


public class test {
    private StudentDao studentDao;
    @Before
    public void initStudentDao(){
        studentDao=new StudentDaoImpl();
    }
    @Test
    public void insertStudent(){
         Student student = new Student();
         student.setId(2);
         student.setName("张三");
         student.setSex("男");
        studentDao.insertStudent(student);
    }
    @Test
    public void deleteStudent(){
        //删除
        studentDao.deleteStudent(1);
    }
}

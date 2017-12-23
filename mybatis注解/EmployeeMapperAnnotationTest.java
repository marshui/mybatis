package cn.marsma.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import cn.marsma.mybatis.entity.Employee;
import cn.marsma.mybatis.mapper.EmployeeMapperAnnotation;

public class EmployeeMapperAnnotationTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        sqlSessionFactory = SessionUtils.getSqlSessionFactory();
    }

    @Test
    public void testSaveEmployee() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapperAnnotation employeeMapperAnnotation = sqlSession.getMapper(EmployeeMapperAnnotation.class);
        Employee employee = new Employee();
        employee.setLoginname("mahui");
        employee.setPassword("123456");
        employee.setAge(24);
        employee.setPhone("15271887470");
        employeeMapperAnnotation.saveEmployee(employee);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void removeEmployee() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapperAnnotation employeeMapperAnnotation = sqlSession.getMapper(EmployeeMapperAnnotation.class);
        employeeMapperAnnotation.removeEmployee(5);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectEmployeeById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapperAnnotation employeeMapperAnnotation = sqlSession.getMapper(EmployeeMapperAnnotation.class);
        Employee employee = employeeMapperAnnotation.selectEmployeeById(4);
        System.out.println(employee);
    }
}

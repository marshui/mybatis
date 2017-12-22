package cn.marsma.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import cn.marsma.mybatis.entity.Employee;
import cn.marsma.mybatis.mapper.EmployeeMapper;

public class EmployeeMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        sqlSessionFactory = SessionUtils.getSqlSessionFactory();
    }
/**
 * 测试if
 */
    @Test
    public void testFindEmployee() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setId(1);
        List<Employee> list = employeeMapper.findEmployee(employee);
        sqlSession.close();
        System.out.println(list);
    }

    /**
     * 测试when
     */
    @Test
    public void testFindEmployeeWhen() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setId(1);
        List<Employee> list = employeeMapper.findEmployeeWhen(employee);
        sqlSession.close();
        System.out.println(list);
    }

    /**
     * 测试set
     */
    @Test
    public void testUpdateSet() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setId(1);
        employee.setSex("男");
        employeeMapper.updateSet(employee);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 测试foreach
     */
    @Test
    public void testFindEmployeeForeach() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        List<Employee> employees = employeeMapper.findEmployeeForeach(list);
        System.out.println(employees);
    }

    @Test
    public void findEmployeeBind() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setName("e");
        employee.setSex("e");
        List<Employee> list = employeeMapper.findEmployeeBind(employee);
        System.out.println(list);
    }
}

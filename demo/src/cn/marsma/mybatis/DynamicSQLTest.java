package cn.marsma.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.marsma.mybatis.entity.Employee;
import cn.marsma.mybatis.mapper.EmployeeMapper;

public class DynamicSQLTest {
    public static void main(String[] agrs) throws Exception{
        SqlSessionFactory sqlSessionFactory = SessionUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> list = employeeMapper.findEmployee();
        System.out.println(list);
    }
}

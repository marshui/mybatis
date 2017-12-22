package cn.marsma.mybatis.mapper;

import java.util.List;

import cn.marsma.mybatis.entity.Employee;

public interface EmployeeMapper {
    List<Employee> findEmployee();
}
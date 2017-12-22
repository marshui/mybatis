package cn.marsma.mybatis.mapper;

import java.util.List;

import cn.marsma.mybatis.entity.Employee;

public interface EmployeeMapper {
    List<Employee> findEmployee(Employee employee);

    List<Employee> findEmployeeWhen(Employee employee);

    void updateSet(Employee employee);

    List<Employee> findEmployeeForeach(List<Integer> ids);

    List<Employee> findEmployeeBind(Employee employee);
}
package cn.marsma.mybatis.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.marsma.mybatis.entity.Employee;

public interface EmployeeMapperAnnotation {

    @Insert("insert into employee (loginname,password,age,phone) values(#{loginname},#{password},#{age},#{phone})")
    void saveEmployee(Employee employee);

    @Delete("delete from employee where id= #{id}")
    void removeEmployee(Integer id);

    @Update("update employee set loginname=#{loginname},password=#{password} where id=#{id}")
    void modifyEmployee(Employee employee);

    @Select("select * from employee where id=#{id}")
    @Results({
        @Result(id=true,column="id",property="id"),
        @Result(property="loginname",column="loginname"),
        @Result(property="password",column="password"),
        @Result(property="age",column="age")
    })
    Employee selectEmployeeById(Integer id);
}

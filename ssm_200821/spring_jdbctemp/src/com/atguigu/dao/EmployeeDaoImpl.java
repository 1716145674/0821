package com.atguigu.dao;

import com.atguigu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public int saveEmployee(Employee employee){
        String sql="insert into employee(name,salary) values(:name,:salary)";
        Map<String ,Object> map=new HashMap<>();
        map.put("name",employee.getName());
        map.put("salary",employee.getSalary());
        return namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map));

    }
}

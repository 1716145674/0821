package com.atguigu.test;

import com.atguigu.pojo.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JdbctempTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test1() throws SQLException {
//        实验2：将id=5的记录的salary字段更新为1300.00
        String sql = "update employee set salary=? where id=?";
        System.out.println(jdbcTemplate.update(sql, new BigDecimal("1300"), 5));

    }



    @Test
    public void test2() {
//        实验3：批量插入 是使用多个数组的集合实现
        String sql = "insert into employee(name,salary) values(?,?)";
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"aaa", new BigDecimal("22222")});
        list.add(new Object[]{"bbb", new BigDecimal("22223")});
        list.add(new Object[]{"ccc", new BigDecimal("22224")});
        list.add(new Object[]{"ddd", new BigDecimal("22225")});
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        for (int i : ints) {
            System.out.println(i);
        }

    }

    @Test
    public void tes3() {
//        实验4：查询id=5的数据库记录，封装为一个Java对象返回 queryForObject beanPropertyRowMapper
        String sql = "select id ,name,salary from employee where id=?";
        Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class), 5);
        System.out.println(employee);
    }

    @Test
    public void test4() {
//实验5：查询salary>4000的数据库记录，封装为List集合返回
        String sql = "select id,name,salary from employee where salary >?";
        List<Employee> employees = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class), new BigDecimal("4000"));
        employees.forEach(System.out::println);
    }
    @Test
    public void test5() {
//    查询最大salary
        String sql= "select max(salary) from employee";
        BigDecimal bigDecimal = jdbcTemplate.queryForObject(sql, BigDecimal.class);
        System.out.println(bigDecimal);

//    查询最大salary的员工
        String sql1="select * from employee where salary=(select max(salary) from employee )";
        List<Employee> employees = jdbcTemplate.query(sql1, new BeanPropertyRowMapper<Employee>(Employee.class));
        employees.forEach(System.out::println);

    }
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Test
    public void test6() {
//实验7：使用带有具名参数的SQL语句插入一条员工记录，并以Map形式传入参数值
        String sql="insert into employee (name ,salary) values(:name,:salary)";
        Map<String,Object> map=new HashMap<>();
        map.put("name","唧唧复唧唧");
        map.put("salary",new BigDecimal("333333"));
        namedParameterJdbcTemplate.update(sql,map);
    }
    @Test
    public void test7() {
//重复实验7，以SqlParameterSource形式传入参数值
        String sql="insert into employee (name ,salary) values(:name,:salary)";
        Map<String,Object> map=new HashMap<>();
        map.put("name","再唧唧复唧唧");
        map.put("salary",new BigDecimal("333333"));
        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map));
    }
    @Test
    public void test8() {
//创建Dao，自动装配JdbcTemplate对象
    }
    @Test
    public void test() {

    }
}

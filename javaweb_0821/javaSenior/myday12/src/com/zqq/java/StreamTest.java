package com.zqq.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StreamTest {
    @Test
    public void  test1(){
        List<Employee> list = EmployeeData.getEmployees();
        list.stream().filter(employee -> employee.getName().length()>3).map(employee -> employee.getName()).forEach(System.out::println);
        list.stream().map(Employee::getName).filter(name->name.length()>3).forEach(str-> System.out.println(str));
        Arrays.asList();





    }

}


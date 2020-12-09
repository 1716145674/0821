package com.atguigu.controller;

import com.atguigu.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.awt.PeerEvent;

import java.util.*;

@Controller
public class JsonController {
    @ResponseBody
    @RequestMapping("/jsonStr")
    public String returnString(){

        return "ok";
    }
    @ResponseBody
    @RequestMapping("/jsonPojo")
    public Person returnPojo(){
        Person person = new Person(12, "张三", "男");
        return person;
    }
    @ResponseBody
    @RequestMapping("/jsonList")
    public List<Person> returnList(){
        Person person = new Person(12, "张三", "男");
        Person person1 = new Person(13, "张三", "男");
        Person person2 = new Person(14, "张三", "男");
        List<Person> list =new ArrayList<>();
        list.add(person);
        list.add(person2);
        list.add(person1);
        return list;
    }
    @ResponseBody
    @RequestMapping("/jsonMap")
    public Map returnMap(){
        Map map=new HashMap();
        map.put("perosn", new Person(13, "pojo", "男"));

        Person person = new Person(12, "张三", "男");
        Person person1 = new Person(13, "张三", "男");
        Person person2 = new Person(14, "张三", "男");
        List<Person> list =new ArrayList<>();
        list.add(person);
        list.add(person2);
        list.add(person1);
        map.put("list",list);
        return map;
    }
    @ResponseBody
    @RequestMapping("/getPerson")
    public Person getPerson(@RequestBody Person person){
        System.out.println("aaaaa");
        System.out.println(person);
        return person;
    }
    @ResponseBody
    @RequestMapping("/sendPerson")
    public String sendPerson(@RequestBody() Person person){
        System.out.println(person);
        return "1";
    }

}

package com.thh.spring.controller;

import com.thh.spring.bean.Dog;
import com.thh.spring.bean.Person;
import com.thh.spring.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@Api(tags = "swaggerEEEEEEEEEEEEEEEEE1")
public class SampleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Person person;

    @ApiOperation(value = "这是第一个测试", notes = "test")
    @GetMapping("/hello")
    public String helloworld() {
        person.setAge(10000);
        //logger.warn("helloworld....");
        return person.getAge().toString();
    }

    @GetMapping("/sample")
    public String helloworld2() {
        User user = new User();
        user.setUsername("test");
        //Object clone = user.clone();
        person.setAge(88888);
        //logger.warn("helloworld....");
        return person.getAge().toString();
    }

    @GetMapping("/show")
    public String helloworld3() {
        //logger.warn("helloworld....");
        return person.getAge().toString();
    }

    //@GetMapping("/")
    public MultiValueMap<String, String> helloworld2(@RequestParam MultiValueMap<String, String> map) {
        //logger.warn("helloworld....");
        List<Dog> test = new ArrayList<>();
        test.add(new Dog());
        map.add("www1", "eeee1");
        map.add("www2", "eeee2");
        test.add(new Dog());
        map.add("www3", "eeee3");
        map.add("www4", "eeee4");
        map.add("www5", "eeee5");
        map.add("www6", "eeee6");
        return map;
    }

    //@GetMapping("/**")
    public Map<String, String> helloworld32(@RequestParam Map<String, String> map) {
        //logger.warn("helloworld....");
        return map;
    }

    //@ApiOperation(value = "这是第一个测试",notes = "test")
    @GetMapping("/test/getPerson")
    public Person getPerson() throws Exception {
        Person person = new Person();
        return person;
    }
}

package com.thh.spring;

import com.thh.spring.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * spring的单元测试.
 * 可以在测试期间进行自动注入.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class YamlTest {

    @Autowired
    Person person;
    @Autowired
    ApplicationContext ioc;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testLog() {
        logger.trace("trace.....");
        logger.debug("debug...");
        logger.info("info....");
        logger.warn("warn....");
        logger.error("error....");
    }

    @Test
    public void testPerson() {
        System.out.println(person);
    }

    @Test
    public void testHelloService() {
        boolean helloService = ioc.containsBean("helloService");
        System.out.println(helloService);
    }

    /*
        方法引用:
            1、对象::实例方法名.
            2、类::静态方法名
            3、类::实例方法名
     */
    @Test
    public void test1() {
        User user = new User(User.rt.FREE);
        user.setAge(1);
        User user1 = new User(User.rt.VICTORY);
        user1.setAge(2);
        User user2 = new User(User.rt.FREE);
        user2.setAge(3);
        User user3 = new User(User.rt.VICTORY);
        user3.setAge(4);

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        //users.stream().forEach(System.out::println);
        Set<User.rt> set = users.stream().collect(Collectors.collectingAndThen(Collectors.groupingBy(User::getF), Map::keySet));
        set.forEach(System.out::println);
        Map<User.rt,Integer> map2 = users.stream().collect(Collectors.groupingBy(User::getF,Collectors.summingInt(User::getAge)));
        System.out.println(map2);


        //对象::实例方法名
        Consumer<String> consumer = (x) -> user.setUsername(x);
        Consumer<String> consumer1 = user::setUsername;
        //users.stream().collect(Collectors.toMap()
        //类::静态方法名
        Comparator<Integer> comparator = (x,y) -> Integer.compare(x,y);
        Comparator<Integer> comparator1 = Integer::compare;
        //类::实例方法名
        BiPredicate<String,String> bp = (x,y) -> x.equals(y);
        BiPredicate<String,String> bp2 = String::equals;
    }
}

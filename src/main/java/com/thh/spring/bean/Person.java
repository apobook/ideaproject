package com.thh.spring.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中的配置的每一个属性的值，映射到这个组件中.
 * @ConfigurationProperties :告诉springboot将本类中的所有属性与配置文件中相关的配置属性绑定.
 * prefix = "person" :指定配置文件中的属性与类中的属性一一对应.
 * 只有这个组件被容器管理 ，@ConfigurationProperties 才会起作用.
 * @ConfigurationProperties(prefix = "person") 使用该注解赋值  是从全局配置文件中获取值的(application).
 * @PropertySource("classpath:person.properties"):加载外部指定的配置文件（只能为properties文件）.
 */
@Component
//@PropertySource(value = {"classpath:person.properties"})
//@ConfigurationProperties(prefix = "person")
public class Person {

    //@Value("${person.lastName}")
    @ApiModelProperty("opop")
    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> lists;

    private Dog pets;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", pets=" + pets +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getPets() {
        return pets;
    }

    public void setPets(Dog pets) {
        this.pets = pets;
    }
}

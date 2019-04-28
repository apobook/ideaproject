package com.thh.spring;

import com.thh.spring.bean.Egg;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User implements Cloneable{

    private String username;
    private String password;
    private String iconUrl;
    private rt f;

    private Integer age;

    private List<Egg> eggs;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public enum rt {
        FREE,
        VICTORY;
    }

    public User(rt f) {
        this.f = f;
    }

    public User() {
    }


}

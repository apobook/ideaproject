package com.thh.spring.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User implements Cloneable{

    private String username;
    private String password;
    private String iconUrl;

    private List<Egg> eggs;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

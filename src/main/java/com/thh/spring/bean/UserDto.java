package com.thh.spring.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private String dtoName;
    private String iconUrl;

    private List<EggVo> eggDTOs;
}

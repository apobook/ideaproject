package com.thh.spring.config;


import com.thh.spring.bean.Egg;
import com.thh.spring.bean.EggVo;
import org.mapstruct.Mapper;

//@Mapper(componentModel="spring")
public interface EggVoMapper {

    public EggVo eggToDto(Egg user);
}

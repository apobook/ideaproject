package com.thh.spring.config;

import com.thh.spring.bean.Egg;
import com.thh.spring.bean.EggVo;
import com.thh.spring.bean.User;
import com.thh.spring.bean.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//@Mapper(componentModel="spring")
public interface UserDtoMapper {

    public User dtoToUser(UserDto userDto) ;
    public EggVo eggToDto(Egg egg);
    public UserDto userToDto(User user);
}

package com.thh.spring.controller;

import com.thh.spring.bean.*;
import com.thh.spring.config.UserDtoMapper;
import io.swagger.annotations.*;
import org.modelmapper.*;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static javafx.beans.binding.Bindings.when;

@RestController
@Api(value = "用户接口", tags = {"dogAPi"})//接口简要标注，对中文的支持不太好
public class TestController {

    @Autowired
    private UserDtoMapper userDtoMapper;

    @ApiOperation(value = "创建图书", notes = "创建图书")
    //@ApiImplicitParam(name = "book", value = "json参数", required = true, dataType = "Person")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Person postBook(@RequestBody @ApiParam(name = "lastName") Person book) {
        return book;
    }

    @ApiOperation(value = "创建图书", notes = "创建图书")
    //@ApiImplicitParams({@ApiImplicitParam(name = "")})
    @ApiImplicitParam(access = "lastName")
    @GetMapping("/test2")
    public Person postBook2(Person book) {
        return book;
    }

    @GetMapping("/user")
    public UserDto getUser(User user) throws Exception {
        User u = new User();
        u.setUsername("tyty");
        u.setIconUrl("www");
        List<Egg> list = new ArrayList<Egg>();
        Egg e = new Egg();
        e.setName("e1");
        list.add(e);
        u.setEggs(list);

        final ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        //针对内部list的转换
        final Converter<List<Egg>,List<EggVo>> converter = new AbstractConverter<List<Egg>, List<EggVo>>() {
            @Override
            protected List<EggVo> convert(List<Egg> source) {
                return modelMapper.map(source,new TypeToken<ArrayList<EggVo>>(){}.getType());
            }
        };
        PropertyMap<User,UserDto> propertyMap = new PropertyMap<User, UserDto>() {
            @Override
            protected void configure() {
                //using(converter).map(source.getEggs(),destination.getEggDTOs());
                Condition notNull = new Condition(){
                    @Override
                    public boolean applies(MappingContext context) {
                        return context.getSource() != null;
                    }
                };
                when(notNull).map().setDtoName(source.getUsername());
                skip(destination.getIconUrl());
            }
        };
        modelMapper.addMappings(propertyMap);
       // modelMapper.createTypeMap(User.class,UserDto.class);
        return modelMapper.map(u, UserDto.class);
    }

}

package com.thh.feign;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.httpclient.ApacheHttpClient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FeignMain {

    public static void main(String[] args) {

        HelloCilent helloCilent = Feign.builder()
                .requestInterceptor(new CharlesRequestInterceptor())
                //.client(new ApacheHttpClient())
                .decoder(new GsonDecoder())//解码器.
                .encoder(new GsonEncoder())//编码器.
                .target(HelloCilent.class,"http://127.0.0.1:8080");
        PoliceBean policeBean = helloCilent.getPoliceBean(100);
        System.out.println(policeBean);
        PoliceBean policeBean1 = new PoliceBean();
        policeBean1.setId(555);
        policeBean1.setPoliceName("警察名字");
        policeBean1.setLiss(Arrays.asList("we","qw"));
        Map<String,Object> map = new HashMap<>();
        map.put("id",555);
        map.put("policeName","警察名字");
        PoliceBean policeByIdAndName = helloCilent.getPoliceByIdAndName(policeBean1);
        System.out.println(policeByIdAndName);

    }
}

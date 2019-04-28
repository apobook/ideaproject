package com.thh.feign;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

public interface HelloCilent {

    @RequestLine("GET /set/police/{id}")
    PoliceBean getPoliceBean(@Param("id") Integer id);

    @RequestLine("GET /set/police")
    PoliceBean getPoliceByIdAndName(PoliceBean policeBean);
}

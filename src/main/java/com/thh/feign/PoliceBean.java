package com.thh.feign;

import java.util.List;

public class PoliceBean {

    private Integer id;
    private String policeName;
    private Integer sex;
    private List<String> liss;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoliceName() {
        return policeName;
    }

    public void setPoliceName(String policeName) {
        this.policeName = policeName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PoliceBean{" +
                "id=" + id +
                ", policeName='" + policeName + '\'' +
                ", sex=" + sex +
                '}';
    }

    public List<String> getLiss() {
        return liss;
    }

    public void setLiss(List<String> liss) {
        this.liss = liss;
    }
}

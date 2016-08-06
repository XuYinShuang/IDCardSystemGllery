package com.zhiyuan3g.idcardsystemgllery.entity;

/**
 * Created by Administrator on 2016/7/19.
 */
public class Information {

   private String name;
    private String sex;
    private String country;
    private String address;
    private String shenfen;
    private int index;

    public Information(String name, String sex, String country,  String address, String shenfen,int index) {
        this.name = name;
        this.sex = sex;
        this.country = country;
        this.address = address;
        this.shenfen = shenfen;
        this.index=index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShenfen() {
        return shenfen;
    }

    public void setShenfen(String shenfen) {
        this.shenfen = shenfen;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

package com.elangzhi.fish.model;

public class Person {
    private Long id;

    private String name;

    /**
     <option value="1">组委会主席</option>
     <option value="2">主任仲裁员</option>
     <option value="3">总裁判长</option>
     <option value="4">副总裁判长</option>
     <option value="5">成统裁判长</option>
     <option value="6">成统裁判员</option>
     <option value="7">分区裁判长</option>
     <option value="8">分区裁判员</option>
     <option value="9">助理裁判员</option>
     <option value="20">参赛人员</option>
     */
    private Integer type;

    private Integer number;

    private String phone;

    private String address;

    private Double price;

    private String intro;

    private String group;

    private Long gameId;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
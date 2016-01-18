package com.elangzhi.fish.model;

import java.util.Date;

public class Game {
    private Long id;

    private String name;

    private Date time;

    private String zhu;

    private String cheng;

    private Integer chang;

    private Integer qu;

    private String intro;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getZhu() {
        return zhu;
    }

    public void setZhu(String zhu) {
        this.zhu = zhu == null ? null : zhu.trim();
    }

    public String getCheng() {
        return cheng;
    }

    public void setCheng(String cheng) {
        this.cheng = cheng == null ? null : cheng.trim();
    }

    public Integer getChang() {
        return chang;
    }

    public void setChang(Integer chang) {
        this.chang = chang;
    }

    public Integer getQu() {
        return qu;
    }

    public void setQu(Integer qu) {
        this.qu = qu;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }
}
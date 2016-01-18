package com.elangzhi.fish.model;

import java.util.Date;

public class Grade {
    private Long id;

    private Long personId;

    private Long gameId;

    private Date time;

    private Integer chang;

    private Integer qu;

    private Integer number;

    private Double weight;

    private Integer grade;

    private Integer ranking;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
}
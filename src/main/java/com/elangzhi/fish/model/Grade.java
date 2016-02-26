package com.elangzhi.fish.model;

import java.util.Date;
import java.util.List;

public class Grade {
    private Long id;

    private Long personId;

    private Long gameId;

    private Date time;

    private Integer chang;

    private Integer qu;

    private Integer room;

    private Integer number = 0;

    private Double weight = 0.0;

    private Double grade = 0.0;

    private Double ranking = 0.0;

    private Double defen;

    private Integer quCount;

    List<Grade> child;
    //-------------
    private String personName;
    private Integer personNumber;

    public List<Grade> getChild() {
        return child;
    }

    public void setChild(List<Grade> child) {
        this.child = child;
    }

    public Integer getQuCount() {
        return quCount;
    }

    public void setQuCount(Integer quCount) {
        this.quCount = quCount;
    }

    public Integer getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(Integer personNumber) {
        this.personNumber = personNumber;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

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

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Double getRanking() {
        return ranking;
    }

    public void setRanking(Double ranking) {
        this.ranking = ranking;
    }

    public Double getDefen() {
        return defen;
    }

    public void setDefen(Double defen) {
        this.defen = defen;
    }
}
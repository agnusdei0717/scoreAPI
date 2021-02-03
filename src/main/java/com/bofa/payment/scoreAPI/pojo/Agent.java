package com.bofa.payment.scoreAPI.pojo;

import com.bofa.payment.scoreAPI.utils.ObjTransJsonUtil;

import javax.persistence.*;

@Entity
@Table(name = "agent")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自動增長主鍵
    private Integer id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String cname;

    @Column(nullable = false)
    private String ename;

    @Column(nullable = false)
    private Integer level;

    public Agent(){}

    public Agent(String password, String cname, String ename, Integer level) {
        this.password = password;
        this.cname = cname;
        this.ename = ename;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString(){
        try {
            return ObjTransJsonUtil.objToJson(this);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

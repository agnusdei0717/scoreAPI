package com.bofa.payment.scoreAPI.pojo;

import com.bofa.payment.scoreAPI.utils.ObjTransJsonUtil;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="rebuild")
public class Rebuild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自動增長主鍵
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date receiveDate;

    @Column(nullable = false)
    private Integer status;

    @Column
    private Integer agent;

    @Column
    private String situation;

    @Column
    private Date endDate;

    @Column
    private String uatResult;

    @Column
    private String prdResult;

    @Column(nullable = false)
    private String remark;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String month;

    @Column(nullable = false)
    private Integer type;

    public Rebuild(){}

    public Rebuild(Integer id){
        this.id = id;
    }

    public Rebuild(String name, Date receiveDate, Integer status, Integer agent, String situation, Date endDate, String uatResult, String prdResult, String remark, String year, String month, Integer type) {
        this.name = name;
        this.receiveDate = receiveDate;
        this.status = status;
        this.agent = agent;
        this.situation = situation;
        this.endDate = endDate;
        this.uatResult = uatResult;
        this.prdResult = prdResult;
        this.remark = remark;
        this.year = year;
        this.month = month;
        this.type = type;
    }

    public Rebuild(Integer id,String name, Date receiveDate, Integer status, Integer agent, String situation, Date endDate, String uatResult, String prdResult, String remark, String year, String month, Integer type) {
        this.id = id;
        this.name = name;
        this.receiveDate = receiveDate;
        this.status = status;
        this.agent = agent;
        this.situation = situation;
        this.endDate = endDate;
        this.uatResult = uatResult;
        this.prdResult = prdResult;
        this.remark = remark;
        this.year = year;
        this.month = month;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReceiveDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(this.receiveDate);
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAgent() {
        return agent;
    }

    public void setAgent(Integer agent) {
        this.agent = agent;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getEndDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(this.endDate);
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getUatResult() {
        return uatResult;
    }

    public void setUatResult(String uatResult) {
        this.uatResult = uatResult;
    }

    public String getPrdResult() {
        return prdResult;
    }

    public void setPrdResult(String prdResult) {
        this.prdResult = prdResult;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

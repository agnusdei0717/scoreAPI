package com.bofa.payment.scoreAPI.pojo;

import com.bofa.payment.scoreAPI.utils.ObjTransJsonUtil;

import javax.persistence.*;

@Entity
@Table(name="score_code")
public class ScoreCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自動增長主鍵
    private Integer id;

    @Column(nullable = false)
    private String codeKind;

    @Column(nullable = false)
    private String codeName;

    @Column(nullable = false)
    private Integer type;

    @Column(nullable = false)
    private String codeDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeKind() {
        return codeKind;
    }

    public void setCodeKind(String codeKind) {
        this.codeKind = codeKind;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
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

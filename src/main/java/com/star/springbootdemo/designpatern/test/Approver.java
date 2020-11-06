package com.star.springbootdemo.designpatern.test;

/**
 * @Author: StarC
 * @Date: 2020/4/13 10:07
 * @Description:
 */
public abstract class Approver {

    Approver approver;
    String name;
    ResponsibilityEntity responsibilityEntity;

    public Approver(String name){
        this.name = name;
    }

    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void processPequest(PurchaseRequest purchaseRequest);

}

package com.star.springbootdemo.designpatern.test;

/**
 * @Author: StarC
 * @Date: 2020/4/13 10:10
 * @Description:
 */
public class DepartmentApprove extends Approver {

    public DepartmentApprove(String name) {
        super(name);
    }

    @Override
    public void processPequest(PurchaseRequest purchaseRequest) {

    }
}

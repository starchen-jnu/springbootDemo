package com.star.springbootdemo.designpatern.iterator;

import java.util.Iterator;

/**
 * @Author: StarC
 * @Date: 2019/9/2 15:07
 * @Description:
 */
public interface College {

    public void getName();
    public void addDepartments(Department department);
    public Iterator iterator();
}

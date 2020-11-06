package com.star.springbootdemo.designpatern.iterator;

import java.util.Iterator;

/**
 * @Author: StarC
 * @Date: 2019/9/2 15:21
 * @Description:
 */
public class ComputerCollegeIterator implements Iterator {

    Department[] departments;
    private int position = 0;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if(position >= departments.length || departments[position] == null) {
            return false;
        }else {

            return true;
        }
    }

    @Override
    public Object next() {
        Department department = departments[position++];
        return department;
    }

    @Override
    public void remove() {

        /*if(departments.length <= 0 || departments[0] == null){
            throw new RuntimeException("空值");
        }
        Department[] newDepartments = new Department[departments.length-1];
        for(int i=0; i<newDepartments.length-1;i++){
            newDepartments[i] = departments[i];
        }
        departments = newDepartments;*/
    }
}

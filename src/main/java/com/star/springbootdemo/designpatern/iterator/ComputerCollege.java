package com.star.springbootdemo.designpatern.iterator;

import java.util.Iterator;

/**
 * @Author: StarC
 * @Date: 2019/9/2 15:07
 * @Description:
 */
public class ComputerCollege implements College {

    private Department[] departments;
    private int position = 0;

    public Department[] getDepartments() {
        return departments;
    }

    public ComputerCollege() {

        departments = new Department[0];
        /*departments = new Department[3];
        addDepartment(new Department("Java专业", " Java专业 "));
        addDepartment(new Department("Java专业1", " Java专业 1"));
        addDepartment(new Department("Java专业2", " Java专业 2"));*/
    }



    @Override
    public void addDepartments(Department department){
        Department[] temp = new Department[departments.length+1];
        for(int i=0; i<departments.length;i++){
            temp[i] = departments[i];
        }
        temp[departments.length]=department;
        departments = temp;


    }
    @Override
    public void getName() {

    }

  /*  @Override
    public void addDepartment(Department department) {
        departments[position++] = department;
    }*/

    @Override
    public Iterator iterator() {
        return new ComputerCollegeIterator(departments);
    }
}

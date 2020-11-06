package com.star.springbootdemo.designpatern.iterator;

/**
 * @Author: StarC
 * @Date: 2019/9/2 15:32
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        ComputerCollege computerCollege = new ComputerCollege();
        computerCollege.addDepartments(new Department("Java专业", " Java专业 "));
        computerCollege.addDepartments(new Department("Java专业1", " Java专业 "));
        computerCollege.addDepartments(new Department("Java专业2", " Java专业 "));
        ComputerCollegeIterator iter = new ComputerCollegeIterator(computerCollege.getDepartments());
        while(iter.hasNext()){
            Department department = (Department) iter.next();
            System.out.println(department.getName());



        }
    }
}

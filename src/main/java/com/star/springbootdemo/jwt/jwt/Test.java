package com.star.springbootdemo.jwt.jwt;

import com.star.springbootdemo.bean.Person;
import com.star.springbootdemo.designpatern.delegate.EmployeeA;

import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * @Author: StarC
 * @Date: 2019/10/29 9:22
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        test("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
    }
    public static  void test(String... identity){
        /*for(String params:identity){
            System.out.println(params);
        }
*/

        List<Entity1> entity1s = Arrays.asList(new Entity1("star", 1), new Entity1("star", 2));
        Set<Entity1>set = new HashSet<>(entity1s);
        Map<Integer,Entity1>map = new HashMap();
        int j=0;
         List<Entity1> list11 = new ArrayList<>(new LinkedHashSet<>(entity1s));
        Iterator<Entity1> iterator = set.iterator();
        while (iterator.hasNext()){
            map.put(j,iterator.next());
            j++;
        }
        System.out.println(set);
    }



}

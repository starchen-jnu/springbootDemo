package com.star.jvm;

import com.star.springbootdemo.bean.Person;
import org.apache.commons.collections.CollectionUtils;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Author: StarC
 * @Date: 2019/9/18 10:12
 * @Description:
 */
public class Test {
    public static void main(String[] args) {

        Supplier<Car> supplier = Car::new;
        Supplier<List<String>> listSupplier1 = ArrayList::new;
        List<String> list = listSupplier1.get();
        Optional<List<String>> listOptional = Optional.ofNullable(list);
        listOptional.ifPresent(l->{
            l.forEach(string ->{

            });
        });
        Car car = supplier.get();
        Supplier<Car> supplier1 = ()-> new Car(1,"coloe1");
        Supplier<Car> supplier2 = ()-> new Car(2,"coloe1");
        List<Car> alist =  Arrays.asList(supplier2.get(), supplier1.get());
        Comparator<Car>comparator = (Car car1,Car car2)-> car2.getPrice().compareTo(car1.getPrice());
        Map<String,String> map = new HashMap<>();
        map.put("JAN","1");
        alist.sort(comparator);
        System.out.println(alist);
        TreeMap<String,List<Car>> groupbyPricaMap = alist.stream().collect(Collectors.groupingBy(Car::getColour, TreeMap::new,Collectors.toList()));
        alist.forEach(s->{
            s.getColour();
        });
        map.entrySet().forEach(entry->{
            String value = entry.getValue();
            String key = entry.getKey();
        });
        Optional< List<Car> > optionalCars = Optional.ofNullable(alist);
        Supplier< List<Car>> listSupplier = ()->new ArrayList<>();
        listSupplier.get().add(supplier1.get());
        optionalCars.orElseGet(listSupplier);
        optionalCars.ifPresent(r->{
            r.forEach(entity->{
                System.out.println(entity.getPrice());
            });
        });

        try {
            Test  test = Test.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        Objects.requireNonNull(alist);

        //有输入，没输出
        Consumer<Integer> consumer = x->{
            int i = x+2;
            System.out.println(i);
        };
        consumer.accept(2);

        String s = "A01";
        System.out.println(s.substring(0,3));

        Predicate<Person> predicate = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                if(person.getAge()>30){
                    return true;
                }
                return false;
            }
        };

        Supplier<Person> personSupplier1 = ()->new Person("star",31);
        Supplier<Person> personSupplier2 = ()->new Person("star",29);
        Supplier<List<Person>> listSupplier2 = ()->new ArrayList<>();
        Supplier<List<Person>> listSupplier3 = ()->new ArrayList<>();
        List<Person> list2 = listSupplier2.get();
        List<Person> list3 = listSupplier3.get();
        System.out.println(personSupplier1.get());
        list2.add(personSupplier1.get());
        list2.add(personSupplier2.get());
        System.out.println("list2:"+list2);
        list2 .forEach(x->{
            if(predicate.test(x)){
                list3 .add(x);
            }
        });
        list3 .forEach(x->{
            System.out.println("object："+x);
        });
        System.out.println("list3:"+list2 );




      /* new Thread(()->{
           System.out.println(Thread.currentThread().getName());
       },"thread1").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        },"thread2").start();

        int i = 0;
        if(i==0){
            throw new NumberFormatException("数字异常");
        }*/

       /* List<OomObject> list = new ArrayList<>();
        while(true){
            list.add(new OomObject());
        }
*/

       OomObject oomObject = new OomObject();
//        try {
//            oomObject.stackLeak();
//        } catch (Exception e) {
//            System.out.println("length:"+oomObject.stackLength);
//            e.printStackTrace();
//        }

       /* AtomicInteger i = new AtomicInteger();
        Test1 test = new Test1();
        test.threadRun(i);*/
       /* List<String> aList = new ArrayList<>();
        aList.add("star");
        WeakReference<List<String>> list = new WeakReference<>(aList);

        System.out.println(list.get());
        System.gc();
        System.out.println(list.get());*/
   /*     Car car = new Car(22000,"silver");
        WeakReference<Car> weakCar = new WeakReference<Car>(car);
        int i=0;
        while(true){
            if(weakCar.get()!=null){
                i++;
                System.out.println("Object is alive for "+i+" loops - "+weakCar);
            }else{
                System.out.println("Object has been collected.");
                break;
            }
        }*/

        Map<String,Object> map1 = new HashMap<>();
        for(Map.Entry<String,Object> entry: map1.entrySet()){
            System.out.println("空值："+entry.getKey());
        }
        System.out.println(map1.size());
        BigDecimal bigDecimal = new BigDecimal("123.456");
        BigDecimal bigDecimal1 = new BigDecimal("123.456");
        double v = bigDecimal1.add(bigDecimal).doubleValue();


        System.out.println(v);


    }

    static class OomObject{
        int stackLength = 1;
        public void stackLeak(){
            stackLength++;
            stackLeak();
        }


    }

    public void threadRun(AtomicInteger i){
        while(true){
            new Thread(()->{
                stopThread();
            },i+"");
        }
    }

    public void stopThread(){
        while(true){

        }
    }

    static class Singleton{
        private static  Singleton singleton = null;
        public static Singleton getInstance(){
            if(singleton == null){
                synchronized (singleton) {
                    if(singleton == null) {
                        singleton = new Singleton();
                    }
                }
            }
            return singleton;
        }
        static class InstanceHondler{
            public static final Singleton instance = new Singleton();
        }
        public static Singleton getInstance1(){
            return InstanceHondler.instance;
        }
    }



}

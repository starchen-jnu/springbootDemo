package com.star.springbootdemo;

import com.star.springbootdemo.bean.Person;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.util.*;
import java.util.function.Function;


/**
 * @Author: StarC
 * @Date: 2019/11/7 15:52
 * @Description:
 */
public class Test1 {

   private static  Map<Integer, String> warnInfoMap = new HashMap<Integer, String>();
    public static void main(String[] args) {
       /* String reg = "^[0-9]{3,4}[A-Z]{0,1}|[0-9]{2}[A-Z]{1}$";
        String str = "884Z";
        //System.out.println(str.matches(reg));
        String apsdASendtimeReg = "\\.(([A-Z]{3})[0-9A-Z]{4})\\s+([A-Z]{2}/)?((0[1-9]|[1-2][0-9]|3[0-1])(20|21|22|23|[0-1]\\d)[0-5]\\d)\\s*\r?\n";

        String text = ".MUCKMOZ 180641";
        Pattern pattern = Pattern.compile(apsdASendtimeReg);
        Matcher m = pattern.matcher(text);
        if (m.find()) {
            String sender = m.group(1);
            String apsd = m.group(2);
            String sendTime = m.group(4);
            System.out.println(sender);
            System.out.println(apsd);
            System.out.println(sendTime);
        }*/

    /*    Calendar calendar = Calendar.getInstance();
        JunitTest junitTest = new JunitTest();
        junitTest.hashCode();
        Date date = new Date();
        String format = DateFormatUtils.format(date, "yyyyMMdd");
        System.out.println(format);
        NumberUtils.isDigits("1");*/






        //System.out.println(hyxM9.find());
       /* if(hyxM12.find()){
            System.out.println("货物："+hyxM12.group(2));
            System.out.println("邮件："+hyxM12.group(4));
            System.out.println("行李："+hyxM12.group(6));
        }*/


       // System.out.println(warnInfoMap);


        Person p1 = new Person("star",29);
        Person p2 = new Person("starchen",30);
        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        Optional.ofNullable(personList).ifPresent(persons->{
            for(Person person : persons){
                System.out.println(person.getLastName());
            }
        });
        Optional optional = Optional.ofNullable("ll");



        String oldDate ="02APR22";
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        try {
           date = DateUtils.parseDateStrictly(oldDate, Locale.ENGLISH, "ddMMMyy", "dMMMyy","ddMMM");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("end");
        List<Person>list = new ArrayList<>();
        list.sort(Comparator.comparing(Person::getAge));

        Person person = new Person();
        Optional<Person> opt = Optional.ofNullable(person);
        opt.ifPresent(p->{
            p.getAge();
        });
        FileInputStream fileInputStream = null;
        FileChannel fc = null;
        ByteBuffer buff =ByteBuffer.allocate(1024);
        //FileOutputStream out =null;
        FileOutputStream out1 =null;
        FileChannel fo = null;

      /*  try {

                 fileInputStream = new FileInputStream("D:/20200428.txt");
                 fc = fileInputStream.getChannel();

             //out = new FileOutputStream("D:/star.txt");
             out1 = new FileOutputStream("D:/star1.txt");
             fo = out1.getChannel();
            //fc.transferTo(0,fc.size(), Channels.newChannel(out));
                while(fc.read(buff) != -1){
                    buff.flip();
                    fo.write(buff);
                    buff.clear();
                }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fo.close();
                out1.close();
                fc.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/


        String[] arr = new String[]{"a","b","c"};
        String join = StringUtils.join(arr, ",");
        //System.out.println(join);
        System.out.println(Math.abs(toHash("2c907481715cd0ce01715cd815b0000a")));
    }

    public static Integer Feb(int n){

        if(n==0 || n==1){
            return 1;
        }else{
            Integer res = Feb(n-1)+Feb(n-2);
            return res;
        }
    }


    public static void init() {
        // 初始化预警信息的map
        String[] warnInfo = { "旅客人数数据源误差超过限定值", "行李件数数据源误差超过限定值", "行李重量数据源误差超过限定值", "货邮重量数据源误差超过限定值",
                "货物重量数据源误差超过限定值" };
        dfs(0, 0, warnInfo, "");

    }

    // 深度优先遍历设置map数据
    private static void dfs(int index, int key, String[] words, String res) {
        if (index == words.length) {
            if (key > 0) {
                warnInfoMap.put(key, res.substring(0, res.length() - 1));
            }
        } else {
            dfs(index + 1, key + (1 << index), words, res + words[index] + ",");
            dfs(index + 1, key, words, res);
        }
    }

    // 将字符串转成hash值
    public static int toHash(String key) {
        int arraySize = 11113; // 数组大小一般取质数
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) { // 从字符串的左边开始计算
            int letterValue = key.charAt(i) - 96;// 将获取到的字符串转换成数字，比如a的码值是97，则97-96=1
            // 就代表a的值，同理b=2；
            hashCode = ((hashCode << 5) + letterValue) % arraySize;// 防止编码溢出，对每步结果都进行取模运算
        }
        return hashCode;
    }





}

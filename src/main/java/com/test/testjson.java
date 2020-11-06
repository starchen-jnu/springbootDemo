package com.test;

import com.alibaba.fastjson.JSONArray;
import org.beetl.ext.fn.Print;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: StarC
 * @Date: 2020/7/8 11:22
 * @Description:
 */
public class testjson {
    public static void main(String[] args) {
       /* List<PingAnCheckListItemVo> list = new ArrayList<>();
        list.add(new PingAnCheckListItemVo("2c9d1ae17327f7d601732850a353000d","2c9d1ae17327f7d601732850a4aa000e","公共部分","2c9d1ae17327f7d601732850a54f000f","建设安排","2c9d1ae17327f7d601732850a61b0010","ff80808163bf1cdc0163bf2f2b210022","平安民航检查","2020-07-08"));
        list.add(new PingAnCheckListItemVo("2c9d1ae17327f7d601732850a353000d","2c9d1ae17327f7d601732850a4aa000e","公共部分","2c9d1ae17327f7d601732850a54f000f","建设安排","2c9d1ae17327f7d601732850a61b0010","ff80808163bf1cdc0163bf2f8a5e0024","平安民航检查","2020-07-08"));

        Object obj2 = JSONArray.toJSON(list);
        String json2 = obj2.toString();
        System.out.println("将List<Person>转成json:" + json2);*/
     /*  String[] name = {"star","chen"};
        List<String> collect = Arrays.stream(name).map(word -> word.split("")).flatMap(Arrays::stream).distinct().skip(2).collect(Collectors.toList());
        collect.forEach(System.out::println);*/

        List<PingAnCheckListItemVo> list = new ArrayList<>();
        list.add(new PingAnCheckListItemVo("2c9d1ae17327f7d601732850a353000d","2c9d1ae17327f7d601732850a4aa000e","公共部分","2c9d1ae17327f7d601732850a54f000f","建设安排","2","ff80808163bf1cdc0163bf2f2b210022","平安民航检查1","2020-07-08"));
        list.add(new PingAnCheckListItemVo("2c9d1ae17327f7d601732850a353000d","2c9d1ae17327f7d601732850a4aa000e","公共部分","2c9d1ae17327f7d601732850a54f000f","建设安排","2","ff80808163bf1cdc0163bf2f8a5e0024","平安民航检查2","2020-07-08"));
        list.add(new PingAnCheckListItemVo("2c9d1ae17327f7d601732850a353000d","2c9d1ae17327f7d601732850a4aa000e","公共部分","2c9d1ae17327f7d601732850a54f000f","建设安排","11","ff80808163bf1cdc0163bf2f8a5e0024","平安民航检查3","2020-07-08"));
        List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5);
        Integer reduce = asList.stream().filter(a->a%2==0).reduce(0, Integer::sum);
        String collect = list.stream().map(PingAnCheckListItemVo::getDepartId).distinct().collect(Collectors.joining(","));
        System.out.println(collect);

        Supplier<PingAnCheckListItemVo> supplier = ()->new PingAnCheckListItemVo();
        PingAnCheckListItemVo pingAnCheckListItemVo = supplier.get();
        Supplier<TreeMap<String,List<PingAnCheckListItemVo>>> treeMapsupplier = ()->new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return Integer.parseInt(o2)-Integer.parseInt(o1);
            }
        });
        TreeMap<String,List<PingAnCheckListItemVo>> treeMap = list.stream().collect(Collectors.groupingBy(PingAnCheckListItemVo::getProjectId,treeMapsupplier,Collectors.toList()));
        for(Map.Entry<String,List<PingAnCheckListItemVo>> entry:treeMap.entrySet()){
            String KEY = entry.getKey();
            List<PingAnCheckListItemVo> itemVos = entry.getValue();
        }
        List<Integer> asList1 = Arrays.asList(1,2,3,4,5);
        Optional<Integer> reduce1 = asList1.stream().reduce(Integer::sum);
        reduce1.get();
        PingAnCheckListItemVo pingAnCheckListItemVo1 = new PingAnCheckListItemVo("2c9d1ae17327f7d601732850a353000d","2c9d1ae17327f7d601732850a4aa000e","公共部分","2c9d1ae17327f7d601732850a54f000f","建设安排","2","ff80808163bf1cdc0163bf2f2b210022","平安民航检查1","2020-07-08");
        Optional<PingAnCheckListItemVo> entity = Optional.ofNullable(pingAnCheckListItemVo1);
        entity.orElse(pingAnCheckListItemVo1);
        entity.ifPresent(x->{
            String content = x.getContent();
        });

        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(""), StandardCharsets.UTF_8);
            String str = null;
            while((str = br.readLine()) != null){
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Path path = Paths.get("");
            List<Path> result = new LinkedList<Path>();
            Files.walkFileTree(path,new FindVisistor(result));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static class FindVisistor extends SimpleFileVisitor<Path> {
        private List<Path> result;
        public FindVisistor(List<Path> result) {
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if(file.toString().endsWith(".java")){
                result.add(file);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}



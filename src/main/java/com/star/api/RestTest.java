package com.star.api;

import com.alibaba.druid.support.json.JSONUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Supplier;

/**
 * @Author StarC
 * @Date 2020/9/22 11:40
 * @Description:
 */
@Slf4j

public class RestTest {
    public static void main(String[] args) throws Exception {
        HashMap<String,Object> map = new HashMap<>();
        map.put("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzZXMtY2FuIiwiZXhwIjoxNjAxNjA2ODYzLCJpYXQiOjE2MDA3NDI4NjN9.upod0ntbXzYXKq8UkkVWnMDL06dRl8uabg9oDc5DERTVRvB3mV9o4JS9VUTDZNXXnXwfoiSg94U8NV1FRE08EQ");
        String parma="currentPage=1&pageSize=10000";
        String url = "https://139.159.254.125:7790/api/yj";
//        map.put("currentPage",1);
//        map.put("pageSize",1);
        //String s = HttpUtils.sendGet(url, parma, map);
//        String message = JSONUtils.toJSONString(map);
//        String s = HttpRequest.sendPost(url, message);
      /* String  urlstrl = "https://139.159.254.125:7790/api/yj?currentPage=1&pageSize=1000";
        String s1 = HttpRequest.sendPost(urlstrl, "");*/


        /*String  urlstrl = "https://139.159.254.125:7790/api/yj?currentPage=1&pageSize=1000";
        HashMap<String,String> header = new HashMap<>();
        header.put("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzZXMtY2FuIiwiZXhwIjoxNjAxNjA2ODYzLCJpYXQiOjE2MDA3NDI4NjN9.upod0ntbXzYXKq8UkkVWnMDL06dRl8uabg9oDc5DERTVRvB3mV9o4JS9VUTDZNXXnXwfoiSg94U8NV1FRE08EQ");
        HttpResponse httpResponse = MyHttpUtils.doGet(urlstrl, header);
        JSONObject json = MyHttpUtils.getJson(httpResponse);
        JSONObject o = (JSONObject) json.get("data");
        JSONArray a = (JSONArray) o.get("list");
        System.out.println(a.toArray().length);
        List<BasisDto>list = JSON.parseArray(a.toJSONString(), BasisDto.class);
        System.out.println(list);*/


        //
    /*    String  urlprofession = "https://139.159.254.125:7790/api/zy";
        HashMap<String,String> headerprofession = new HashMap<>();
        headerprofession.put("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzZXMtY2FuIiwiZXhwIjoxNjAxNjA2ODYzLCJpYXQiOjE2MDA3NDI4NjN9.upod0ntbXzYXKq8UkkVWnMDL06dRl8uabg9oDc5DERTVRvB3mV9o4JS9VUTDZNXXnXwfoiSg94U8NV1FRE08EQ");
        HttpResponse httpResponseprofession = MyHttpUtils.doGet(urlprofession, headerprofession);
        JSONObject jsonprofession = MyHttpUtils.getJson(httpResponseprofession);
        System.out.println(jsonprofession);
        JSONObject oprofession = (JSONObject) jsonprofession .get("data");
        JSONArray aprofession = (JSONArray) oprofession.get("list");
        System.out.println(aprofession.toArray().length);
        List<SisMhProfessionDto>listprofession = JSON.parseArray(aprofession.toJSONString(), SisMhProfessionDto.class);
        System.out.println(listprofession);*/
       /* System.out.println(getToken());
        System.out.println("依据："+getBasisesList());
        System.out.println("标准："+getStandardList());
        System.out.println("内容："+getContentList());
        System.out.println("项目："+getItemList());
        System.out.println("业务："+getBusinessList());
        System.out.println("专业："+getProfessionList());*/
       SisMhProfessionDto d = new SisMhProfessionDto();
       d.setId("123");
       d.setBh("1");
        SisMhProfessionDto d2 = new SisMhProfessionDto();
        d2.setGlzyid("star");
        d2.setMName("hello");
        List<SisMhProfessionDto> sisMhProfessionDtoBuilders = Arrays.asList(d,d2);
        List<SisMhProfessionDto> sisMhProfessionDtoBuilders1 = new ArrayList<>();
        List<SisMhProfessionDto> sisMhProfessionDtos = copyList(sisMhProfessionDtoBuilders, SisMhProfessionDto.class);
        System.out.println(sisMhProfessionDtos);
    }

    //获取依据
    public static  List<SisMhBasisesDto> getBasisesList(){
        Map<String,String> header= getHeaderMap();
        List<SisMhBasisesDto> basisesList = null;
        HttpResponse httpResponse= null;
        String url = "https://139.159.254.125:7790/api/yj";
        try {
            httpResponse = MyHttpUtils.doGet(url, header);
            JSONObject json = MyHttpUtils.getJson(httpResponse);
            JSONObject basises = (JSONObject) json.get("data");
            JSONArray basisesArr = (JSONArray) basises.get("list");
            basisesList  = JSON.parseArray(basisesArr .toJSONString(), SisMhBasisesDto.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return basisesList ;
    }

    //获取标准
    public static  List<SisMhStandardDto> getStandardList(){
        Map<String,String> header= getHeaderMap();
        List<SisMhStandardDto> standardList = null;
        HttpResponse httpResponse= null;
        String url = "https://139.159.254.125:7790/api/bz";
        try {
            httpResponse = MyHttpUtils.doGet(url, header);
            JSONObject json = MyHttpUtils.getJson(httpResponse);
            JSONObject standard = (JSONObject) json.get("data");
            JSONArray standardArr = (JSONArray) standard.get("list");
            standardList  = JSON.parseArray(standardArr .toJSONString(), SisMhStandardDto.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return standardList ;
    }


    //获取内容
    public static  List<SisMhContentDto> getContentList(){
        Map<String,String> header= getHeaderMap();
        List<SisMhContentDto> contentList = null;
        HttpResponse httpResponse= null;
        String url = "https://139.159.254.125:7790/api/nr";
        try {
            httpResponse = MyHttpUtils.doGet(url, header);
            JSONObject json = MyHttpUtils.getJson(httpResponse);
            JSONObject content = (JSONObject) json.get("data");
            JSONArray contentArr = (JSONArray) content.get("list");
            contentList  = JSON.parseArray(contentArr .toJSONString(), SisMhContentDto.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return contentList ;
    }


    //获取项目
    public static  List<SisMhItemDto> getItemList(){
        Map<String,String> header= getHeaderMap();
        List<SisMhItemDto> itemList = null;
        HttpResponse httpResponse= null;
        String url = "https://139.159.254.125:7790/api/xm";
        try {
            httpResponse = MyHttpUtils.doGet(url, header);
            JSONObject json = MyHttpUtils.getJson(httpResponse);
            JSONObject item = (JSONObject) json.get("data");
            JSONArray itemArr = (JSONArray) item.get("list");
            itemList = JSON.parseArray(itemArr .toJSONString(), SisMhItemDto.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemList;
    }



    //获取业务
    public static List<SisMhBusinessesDto> getBusinessList(){
        Map<String,String> header= getHeaderMap();
        HttpResponse httpResponse = null;
        String url = "https://139.159.254.125:7790/api/yw";
        List<SisMhBusinessesDto>bussinessList = null;
        try {
            httpResponse = MyHttpUtils.doGet(url, header);
            JSONObject json = MyHttpUtils.getJson(httpResponse);
            JSONObject bussiness = (JSONObject) json.get("data");
            JSONArray bussinessArr = (JSONArray) bussiness.get("list");
            bussinessList = JSON.parseArray(bussinessArr.toJSONString(), SisMhBusinessesDto.class);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取民航token失败");
        }

        return bussinessList;
    }


    //获取专业信息
    public static List<SisMhProfessionDto> getProfessionList(){
        Map<String,String> header= getHeaderMap();
        HttpResponse httpResponse= null;
        String url = "https://139.159.254.125:7790/api/zy";
        List<SisMhProfessionDto>professionList = null;
        try {
            httpResponse = MyHttpUtils.doGet(url, header);
            JSONObject json = MyHttpUtils.getJson(httpResponse);
            JSONArray profession = (JSONArray) json.get("data");
            professionList = JSON.parseArray(profession.toJSONString(), SisMhProfessionDto.class);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取民航token失败");
        }

        return professionList;
    }
    private static String getToken(){
        String Authorization = "Bearer";
        String userName = "ses-can";
        String passwd = "bcd1a87d-4357-4bfe-84b0-2f31c65a0ca2";
        String url = "https://139.159.254.125:7790/api/get_token?username="+userName+"&password="+passwd;
        HashMap<String,String> header= new HashMap<>();
        header.put("Authorization",Authorization);
        HttpResponse httpResponseprofession = null;
        try {
            httpResponseprofession = MyHttpUtils.doGet(url, header);
            JSONObject json = MyHttpUtils.getJson(httpResponseprofession);
            JSONObject jsonData = (JSONObject) json.get("data");
            String token = (String) jsonData.get("token");
            return token;
        } catch (Exception e) {
            e.printStackTrace();
            //log.error("获取民航token失败");
        }
        return null;


    }
    private static Map<String,String> getHeaderMap(){
        String Authorization = "Bearer "+getToken();
        HashMap<String,String> header= new HashMap<>();
        header.put("Authorization",Authorization);
        return header;
    }

    public static  <T> List<T>copyList(List<?>sourceList,Class<T>clazz) {

        Supplier<List<T>> ListSupplier = ArrayList<T>::new;
        List<T> targetList = ListSupplier.get();
        sourceList.forEach(x->{
            try {
                T t = clazz.newInstance();
                BeanUtils.copyProperties(x,t);
                targetList.add(t);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


        });
        return targetList;
    }
}

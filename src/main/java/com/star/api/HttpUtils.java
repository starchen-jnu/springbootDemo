package com.star.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * @Author StarC
 * @Date 2020/9/15 11:38
 * @Description:restful调用API接口
 */
public class HttpUtils {
    public static String sendGet(String url, String param, Map<String, String> heads) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            URLConnection connection = realUrl.openConnection();
            if (heads != null ){
                for (Map.Entry<String, String> entry: heads.entrySet()) {
                    connection.setRequestProperty(entry.getKey(),entry.getValue());
                }
            }
            connection.connect();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}

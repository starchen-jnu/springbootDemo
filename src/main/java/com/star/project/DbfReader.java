package com.star.project;



import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Author: StarC
 * @Date: 2020/5/16 11:09
 * @Description:
 */
public class DbfReader {

    public static void main(String[] args) {
        DbfReader.readDBF("D:/test.dbf");

    }

    /**
     * ��ȡdbf
     *
     * @param path
     */
    public static void readDBF(String path) {
        InputStream fis = null;
        try {
            // ��ȡ�ļ���������
            fis = new FileInputStream(path);
            // ������������ʼ��һ��DBFReaderʵ����������ȡDBF�ļ���Ϣ
            DBFReader reader = new DBFReader(fis);
            // �������
            reader.setCharactersetName("GBK");
            // ����DBFReader��ʵ�������õ�path�ļ����ֶεĸ���
            int fieldsCount = reader.getFieldCount();
            // ȡ���ֶ���Ϣ
            for (int i = 0; i < fieldsCount; i++) {
                DBFField field = reader.getField(i);
                System.out.println(field.getName());
            }
            Object[] rowValues;
            // һ����ȡ��path�ļ��м�¼
            while ((rowValues = reader.nextRecord()) != null) {
                for (int i = 0; i < rowValues.length; i++) {
                    System.out.println(rowValues[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (Exception e) {
            }
        }
        System.out.println("end");
    }


}

package com.star.NIO_DEBUG;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author: StarC
 * @Date: 2020/7/23 10:51
 * @Description:
 */
public class NioDebug {

    public static void main(String[] args) {
        testTransferTo();
    }
    public static void testNIO(){

        int count ;
        Path filePath = Paths.get("D:\\test.txt");

        try(SeekableByteChannel fchan = Files.newByteChannel(filePath) ) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            do{
                count = fchan.read(byteBuffer);
                if(count != -1){
                    byteBuffer.rewind();
                    for(int i =0; i < count; i++){
                        System.out.println((char)byteBuffer.get());
                    }
                }
            }while (count != -1);

        }catch (IOException e){
            System.out.println("I/O ERROR"+e);

        }


    }

    public static void testTransferTo(){

        RandomAccessFile fromFile = null;
        RandomAccessFile toFile = null;
        try {
             fromFile = new RandomAccessFile("D:\\test.txt","rw");
             toFile = new RandomAccessFile("D:\\totest.txt","rw");
             FileChannel fromChannel = fromFile.getChannel();
             FileChannel toChannel = toFile.getChannel();
             long position = 0;
             long count = fromChannel.size();
             fromChannel.transferTo(position,count,toChannel);
        } catch (IOException  e) {
            e.printStackTrace();
        }finally {
            try {
                if(fromFile != null){
                    fromFile.close();
                }
                if(toFile != null){
                    toFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

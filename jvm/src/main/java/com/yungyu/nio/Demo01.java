package com.yungyu.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo01 {

    public static void main(String[] args){
        FileChannel fc = null;
        try {
            fc = new RandomAccessFile("./jms/pom.xml", "r").getChannel();
            ByteBuffer bf = ByteBuffer.allocate(100);
            //bf.flip();
            while(fc.read(bf) != -1){
                bf.flip();
                byte[] data = new byte[bf.limit()];
                bf.get(data);

                bf.clear();
                System.out.println(new String(data));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fc.isOpen()){
                try {
                    fc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

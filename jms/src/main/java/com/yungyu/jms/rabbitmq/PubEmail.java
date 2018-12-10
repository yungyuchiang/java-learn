package com.yungyu.jms.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PubEmail {

    public static final String QUEUE_NAME = "MAILQueue";

    //将对象序列化为字节
    public static byte[] ser(Object obj) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(obj);
        return bos.toByteArray();
    }

    //反序列化
    public static Object dser(byte[] src) throws Exception {
        ByteArrayInputStream bis = new ByteArrayInputStream(src);
        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }

    public static void main(String[] args) {
        //模拟一个任务，以发邮件为例
        Map map = new HashMap();
        map.put("sendto", "");
        map.put("subject", "测试邮件");
        map.put("content", "注册成功，你的验证码为" + System.currentTimeMillis());
        ConnectionFactory factory = null;
        Connection connection = null;
        Channel channel = null;
        try {
            factory = new ConnectionFactory();
            factory.setHost("127.0.0.1");
            factory.setPort(5672);
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, ser(map));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                //Thread.sleep(30 * 1000);
                if(channel != null){
                    channel.close();
                }
                if(connection != null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}





























package com.yungyu.jms.demo02;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

public class MsgSender {

    public static void main(String[] args){
        ConnectionFactory factory = null;
        Connection connection = null;
        Session session = null;
        Queue queue = null;
        try{
            factory = new ActiveMQConnectionFactory();//("tcp://localhost:61616");
            connection = factory.createConnection(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD);
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            queue = new ActiveMQQueue("testqueue");
            Message msg = session.createTextMessage("我叫王小二");
            MessageProducer producer = session.createProducer(queue);

            producer.send(msg);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(connection != null)
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}

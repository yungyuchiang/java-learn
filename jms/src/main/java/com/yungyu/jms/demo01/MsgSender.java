package com.yungyu.jms.demo01;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

public class MsgSender {

    public static void main(String[] args){
        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
            Connection connection = factory.createConnection();
            connection.start();

            Queue queue = new ActiveMQQueue("testQueue");
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Message msg = session.createTextMessage("Hello Jms");
            MessageProducer producer = session.createProducer(queue);

            producer.send(msg);

        } catch (Exception e){
          e.printStackTrace();
        }
    }

}

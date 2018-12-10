package com.yungyu.jms.demo02;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

public class MsgReceiver {

    public static void main(String[] args){
        ConnectionFactory factory = null;
        Connection connection = null;
        Session session = null;
        Queue queue = null;

        try {
            factory = new ActiveMQConnectionFactory();
            connection = factory.createConnection(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD);
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            connection.start();
            queue = new ActiveMQQueue("testqueue");

            MessageConsumer consumer = session.createConsumer(queue);
            consumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    TextMessage msg = (TextMessage) message;
                    try {
                        System.out.println(msg.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        }catch (JMSException e){
            e.printStackTrace();
        }finally {
//            if(connection != null){
//                try {
//                    //connection.close();
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

}

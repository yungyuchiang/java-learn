package com.yungyu.jms.activemq.demo01;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

public class MsgReceiver {

    public static void main(String[] args){
        try{
            ConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
            Connection connection = factory.createConnection();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = new ActiveMQQueue("testQueue");
            MessageConsumer consumer = session.createConsumer(queue);
            consumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println(textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

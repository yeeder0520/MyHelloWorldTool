package com.testRabbitMQ;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/11 下午 05:26
 **/
public class Send {
    private final static String QUEUE_NAME = "陳柏佑";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            System.out.println("channel.isOpen() = " + channel.isOpen());
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "123";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}

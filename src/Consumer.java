import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


public class Consumer {
    private static String url = "tcp://192.168.192.31:61616";
    // from producer
    private static String subjectFrom = "testQueue1";
    //adress to send it off to
    private static String subjectTo = "testQueue2";
    public static void main(String args[]) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination_fromQueue = session.createQueue(subjectFrom);
        MessageConsumer consumer = session.createConsumer(destination_fromQueue);
        // find way to kill this
        while(true){


        }
}}








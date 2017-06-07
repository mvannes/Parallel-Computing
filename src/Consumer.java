import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


public class Consumer {
    private static String url = "tcp://127.0.0.1:61616";
    // from producer
    private static String subjectFrom = "queue";
    //adress to send it off to

    public static void main(String args[]) throws Exception {


        int numberOfConsumers = Integer.parseInt(args[0]);
        int numberOfVerticies = Integer.parseInt(args[1]);

        Thread thread = new Thread(new InitializationConsumer(10));

        thread.start();
        thread.join();



}}

class InitializationConsumer implements Runnable {
    int node;
    int numberOfVertices;
    int count = 0;

    public InitializationConsumer(int numberOfVertices){
        this.numberOfVertices = numberOfVertices;
    }

    public void run() {

        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination_fromQueue = session.createQueue("queue");
            MessageConsumer consumer = session.createConsumer(destination_fromQueue);
            consumer.setMessageListener(new Listener());
//            while (count != numberOfVertices) {
//                try {
//                    // take node from queue acrtivemq
//                    node = consumer.
//                            node =
//                                    increaseInDegree(node);
//                    count++;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }

        } catch (JMSException e) {
            e.printStackTrace();
        }
        //POST SHIT TO GRAPH? INDEGREE?

    }
}

class Listener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        // do shit
        TextMessage textMessage = (TextMessage) message;
        try {
            String str = textMessage.getText();
            int node = Integer.parseInt(str);

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}









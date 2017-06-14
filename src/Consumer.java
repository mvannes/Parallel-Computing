import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


public class Consumer {
    private static String url = "tcp://169.254.1.1:61616";
    // from producer
    private static String subjectFrom = "queue";
    //adress to send it off to

    public Session session;
    public static void main(String args[]) throws Exception {


        int numberOfConsumers = Integer.parseInt(args[0]);

        Thread[] consumerThreads = new Thread[numberOfConsumers];

        for (int i = 0; i < numberOfConsumers; i++) {
            if (i == (numberOfConsumers - 1)) {
                consumerThreads[i] = new Thread(new InitializationConsumer(10));
            } else {
                consumerThreads[i] = new Thread(new InitializationConsumer(10));
            }
            consumerThreads[i].start();
        }

        for(Thread thread: consumerThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



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
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://169.254.1.1:61616");
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination_fromQueue = session.createQueue("queue");

            MessageConsumer consumer = session.createConsumer(destination_fromQueue);
            consumer.setMessageListener(new Listener(session));

        } catch (JMSException e) {
            e.printStackTrace();
        }
        //POST SHIT TO GRAPH? INDEGREE?

    }
}

class Listener implements MessageListener {

    Session session;
    public Listener(Session session){
        this.session = session;
    }
    @Override
    public void onMessage(Message message) {
        // do shit
        TextMessage textMessage = (TextMessage) message;
        try {
            String str = textMessage.getText();
            int node = Integer.parseInt(str);
            Destination destination_toQueue = session.createQueue("mainQueue");
            MessageProducer producer = session.createProducer(destination_toQueue);

            producer.send(textMessage);
            System.out.println("send :D");

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}









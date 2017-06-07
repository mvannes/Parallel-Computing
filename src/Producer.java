import java.util.LinkedList;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer implements Runnable {
	// either connect to the remote ActiveMQ running on the PI, or on the localhost

	int lowerBound;
	int upperBound;
	String destination;
	String ipAdres;
	LinkedList<Integer> adjacencies[];
	MessageProducer producer;
	Session session;



	public Producer(int lowerBound, int upperBound, String ipAdres, LinkedList<Integer> adjacencies[]) throws JMSException {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.adjacencies = adjacencies;
		destination = "queue";
		this.ipAdres = ipAdres;


		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("queue");
		this.producer = session.createProducer(destination);


	}


	@Override
	public void run() {
		for (int i = lowerBound; i  < upperBound; i++) {
			for (Integer node: adjacencies[i]) {

				TextMessage message;
				try {
					message = session.createTextMessage(node.toString());
					this.producer.send(message);
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
}


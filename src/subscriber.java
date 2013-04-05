import javax.jms.*;

import java.io.IOException;
import java.util.*;
import java.io.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

class SubscriberMain {
	
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(final String[] args) throws JMSException {
	
        while(true) {
	    subscribe(args[0],args[1], args[2]);
	}

    }

    public static void subscribe(final String topicName, final String script, String url) throws JMSException
    {

	final ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        final Connection connection = connectionFactory.createConnection();

	connection.start();
        
        Scanner in = new Scanner(System.in);

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        String topicname = topicName;

        Topic topic = session.createTopic(topicname);

        MessageConsumer consumer = session.createConsumer(topic);

        MessageListener listener = new MessageListener() {
            public void onMessage(Message message) {
                try {
                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        //System.out.println("Received message '" + textMessage.getText() + "'");
			String receivedMessage = textMessage.getText();
			String jobName = "gnome-terminal -x ./"+script+" "+topicName+" "+receivedMessage;
			Runtime.getRuntime().exec(jobName);
                    }
                } catch (Exception e) {
                    System.out.println("Caught:" + e);
                    e.printStackTrace();
                }
            }
        };
        
        consumer.setMessageListener(listener);
        try {
		System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}

        connection.close();
    }
}    

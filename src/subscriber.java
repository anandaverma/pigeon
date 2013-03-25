import javax.jms.*;

import java.io.IOException;
import java.util.*;
import java.io.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

class SubscriberMain {
	
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(final String[] args) throws JMSException {

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(args[2]);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        
        Scanner in = new Scanner(System.in);

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        String topicname = args[0];

        Topic topic = session.createTopic(topicname);

        MessageConsumer consumer = session.createConsumer(topic);

        MessageListener listner = new MessageListener() {
            public void onMessage(Message message) {
                try {
                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        System.out.println("Received message '" + textMessage.getText() + "'");
			Runtime.getRuntime().exec("gnome-terminal -e \""+"./"+args[1]+"\"");
                    }
                } catch (Exception e) {
                    System.out.println("Caught:" + e);
                    e.printStackTrace();
                }
            }
        };
        
        consumer.setMessageListener(listner);
        try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

        connection.close();

    }
}    

import javax.jms.*;
import java.util.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

class PublisherMain {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) throws JMSException {

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(args[2]);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        String topicname = args[0];

        Topic topic = session.createTopic(topicname);

        MessageProducer producer = session.createProducer(topic);

        TextMessage message = session.createTextMessage();
        
        String usermessage = args[1];

        message.setText(usermessage);
        
        producer.send(message);

        connection.close();
    }
}

package mybean.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by root on 15-4-1.
 */

@MessageDriven(
        activationConfig = { @ActivationConfigProperty(
                propertyName = "destination", propertyValue = "jms/queue/myTestQueue"), @ActivationConfigProperty(
                propertyName = "destinationType", propertyValue = "javax.jms.Queue"),@ActivationConfigProperty(propertyName = "connectionParameters", propertyValue = "host=http-remoting://localhost;port=8080")
        },
        mappedName = "jms/queue/myTestQueue")
public class MessageDrivenBean implements MessageListener {
    @Override
    public void onMessage(Message message) {

        try {
            TextMessage tMsg=(TextMessage) message;
            System.out.println("the first msg:"+tMsg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

package POC_Test;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import org.eclipse.paho.client.mqttv3.MqttMessage;
public  class Mqttclass  {
	
	public static void publishToTopic(String topicName,String payload) {
		//get the client which is initialized in 
		final String BROKER_URL = "tcp://127.0.0.1:61618";
		final String M2MIO_THING = "GM_92";
		MqttClient mqttClient = null;
		try {
			MqttConnectOptions connOpt = new MqttConnectOptions();
			connOpt.setCleanSession(true);
			connOpt.setKeepAliveInterval(30);
			mqttClient = new MqttClient(BROKER_URL, M2MIO_THING);
			mqttClient.connect(connOpt);
			//test.log(Status.INFO, "MqttClient connected");
			//String myTopic = M2MIO_STUFF + "/" + M2MIO_THING;
			MqttTopic topic = mqttClient.getTopic(topicName);
			MqttMessage message = new MqttMessage(payload.getBytes());
			int pubQoS = 0;
	    	message.setQos(pubQoS);
	    	message.setRetained(false);
	    	MqttDeliveryToken token = null;
	    	token = topic.publish(message);
	    	// test.log(Status.INFO, "MqttClient published messages to topic successfully");
	    	// Wait until the message has been delivered to the broker
			token.waitForCompletion();
		} catch (MqttException e) {
			e.printStackTrace();
			System.exit(-1);
		} finally {
			try {
				mqttClient.disconnect();
				// test.log(Status.INFO, "disconnected");
			} catch (MqttException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Connected to " + BROKER_URL);
	}

}

package POC_TestCases;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;


public class SimpleMqttClient implements MqttCallback {
	
	MqttClient mqttClient;
	
	public MqttClient getMqttClient() {
		if(mqttClient == null) {
			runClient();
		}
		return mqttClient;
	}
	
		
	MqttConnectOptions connOpt;

	static final String BROKER_URL = "tcp://127.0.0.1:61618";
	//static final String M2MIO_DOMAIN = "<Insert m2m.io domain here>";
	static final String M2MIO_STUFF = "measures";
	static final String M2MIO_THING = "GM_92";
	//static final String M2MIO_USERNAME = "<m2m.io username>";
	//static final String M2MIO_PASSWORD_MD5 = "<m2m.io password (MD5 sum of password)>";

	// the following two flags control whether this example is a publisher, a subscriber or both
	static final Boolean subscriber = true;
	static final Boolean publisher = true;

	/**
	 * 
	 * connectionLost
	 * This callback is invoked upon losing the MQTT connection.
	 * 
	 */
	public void connectionLost(Throwable t) {
		System.out.println("Connection lost!");
		// code to reconnect to the broker would go here if desired
	}



	/**
	 * 
	 * messageArrived
	 * This callback is invoked when a message is received on a subscribed topic.
	 * 
	 */
	public void messageArrived(MqttTopic topic, MqttMessage message) throws Exception {
		System.out.println("-------------------------------------------------");
		System.out.println("| Topic:" + topic.getName());
		System.out.println("| Message: " + new String(message.getPayload()));
		System.out.println("-------------------------------------------------");
	}

	public static void main(String[] args) {
		SimpleMqttClient smc = new SimpleMqttClient();
		smc.runClient();
	}
	
	/**
	 * 
	 * runClient
	 * The main functionality of this simple example.
	 * Create a MQTT client, connect to broker, pub/sub, disconnect.
	 * 
	 */
	public void runClient() {
		// setup MQTT Client
		String clientID = M2MIO_THING;
		connOpt = new MqttConnectOptions();
		
		connOpt.setCleanSession(true);
		connOpt.setKeepAliveInterval(30);
		//connOpt.setUserName("");
		//connOpt.setPassword("");
		
		// Connect to Broker
		try {
			mqttClient = new MqttClient(BROKER_URL, clientID);
			mqttClient.setCallback(this);
			mqttClient.connect(connOpt);
		} catch (MqttException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		System.out.println("Connected to " + BROKER_URL);

		// setup topic
		// topics on m2m.io are in the form <domain>/<stuff>/<thing>
		//String myTopic = M2MIO_DOMAIN + "/" + M2MIO_STUFF + "/" + M2MIO_THING;
		String myTopic = M2MIO_STUFF + "/" + M2MIO_THING;
		MqttTopic topic = mqttClient.getTopic(myTopic);

		// subscribe to topic if subscriber
		/*
		 * if (subscriber) { try { int subQoS = 0; mqttClient.subscribe(myTopic,
		 * subQoS); } catch (Exception e) { e.printStackTrace(); } }
		 */

		// publish messages if publisher
		/*if (publisher) {
			for (int i=1; i<=10; i++) {
		   		String pubMsg = getJsonMessage();
		   		int pubQoS = 0;
				MqttMessage message = new MqttMessage(pubMsg.getBytes());
		    	message.setQos(pubQoS);
		    	message.setRetained(false);

		    	// Publish the message
		    	System.out.println("Publishing to topic \"" + topic + "\" qos " + pubQoS);
		    	MqttDeliveryToken token = null;
		    	try {
		    		// publish message to broker
					token = topic.publish(message);
			    	// Wait until the message has been delivered to the broker
					token.waitForCompletion();
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}			
		}
		*/
		// disconnect
		/*
		 * try { // wait to ensure subscribed messages are delivered if (subscriber) {
		 * Thread.sleep(5000); } mqttClient.disconnect(); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
	}
	
	private String getJsonMessage() {
		/*
		 * JSONObject jsonObject = new JSONObject();
		 * jsonObject.put("sensorTypeAlternateId", "103");
		 * jsonObject.put("capabilityAlternateId", "edgal02");
		 * jsonObject.put("sensorAlternateId", "edgalt02"); JSONArray array = new
		 * JSONArray(); array.put("99.22"); array.put("99.09"); JSONArray array1 = new
		 * JSONArray(); array1.put(array); jsonObject.put("measures", array1); return
		 * jsonObject.toString();
		 */
		return "";
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		
	}
}
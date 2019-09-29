package om.server;

import om.common.Packet;

public class Main {

	public static void main(String[] args) {
		ConnectionReceiver connectionReceiver = new ConnectionReceiver();
		connectionReceiver.start();
		
	}
	
	public static void update(Packet packet) {
		/*
		 * Here is a method that's custom to every program. You will handle whatever the server receives in the packet.
		 * This method is called whenever a packet is received and that packet is passed as the parameter.
		 */
	}

}

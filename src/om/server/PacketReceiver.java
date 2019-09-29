package om.server;

import java.io.IOException;
import java.io.ObjectInputStream;

import om.common.Packet;

public class PacketReceiver extends Thread{
	
	private ObjectInputStream inputStream;
	private Boolean isListening = false;
	
	
	public PacketReceiver(ObjectInputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public void run() {
		while(isListening) {
			try {
				Main.update((Packet) this.inputStream.readObject());
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
				System.out.println("ERROR: The object read in the inputStream was not a Packet.");
			}
		}
	}
	
	public void setIsListening(boolean isListening) {
		this.isListening = isListening;
	}
	
	public boolean getIsListening() {
		return this.isListening;
	}
}

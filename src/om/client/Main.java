package om.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import om.common.Connection;
import om.common.Packet;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		String socketAddress = "XXX.XXX.XXX";
		InetSocketAddress sa = new InetSocketAddress(socketAddress, 4450);
		Socket socket = new Socket();
		socket.connect(sa);
		Connection connection = new Connection(socket, new ObjectOutputStream(socket.getOutputStream()), new ObjectInputStream(socket.getInputStream()));
		
		//Here you write your program and then write the data to the packet
		
		Packet packet = new Packet();
		packet.setNb(3);
		packet.setObj(new int[1]);
		
		//This simple examples fills the packet with a static array of 1 space and the number 3 in an integer
		
		connection.send(packet);
	}

}

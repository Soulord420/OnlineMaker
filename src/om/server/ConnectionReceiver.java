package om.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import om.common.Connection;

public class ConnectionReceiver extends Thread{
	
	protected Vector<Connection> connections = new Vector<Connection>();
	protected PacketReceiver packetReceiver;
	private ServerSocket serverSocket;
	private Socket socket;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private Connection connection;
	
	public void run() {
		try {
			this.serverSocket = new ServerSocket(4450);
		} catch (IOException e1) {
			System.out.println("This program is already running on this network. Closing...");
			System.exit(0);
		}
		while(true) {
			
			try {
				this.socket = this.serverSocket.accept();
				this.outputStream = new ObjectOutputStream(this.socket.getOutputStream());
				this.inputStream = new ObjectInputStream(this.socket.getInputStream());
				this.connection = new Connection(this.socket,this.outputStream,this.inputStream);
				this.connections.add(this.connection);
				this.packetReceiver = new PacketReceiver(this.inputStream);
				packetReceiver.start();
				this.connection.reset();
			
			} catch (IOException e) {
				System.out.println("Failed something");
			}
			
		}
	}
}

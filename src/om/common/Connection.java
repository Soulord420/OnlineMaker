package om.common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
 * Custom connection that contains a Socket and it's derivative
 */

public class Connection {
	private Socket socket;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;

	public Connection(Socket socket, ObjectOutputStream outputStream, ObjectInputStream inputStream) {
		this.socket = socket;
		this.inputStream = inputStream;
		this.outputStream = outputStream;
	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	public void setInputStream(ObjectInputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public void setOutputStream(ObjectOutputStream outputStream) {
		this.outputStream = outputStream;
	}
	
	public Socket getSocket() {
		return this.socket;
	}
	
	public ObjectOutputStream getOutputStream() {
		return this.outputStream;
	}
	
	public ObjectInputStream getInputStream() {
		return this.inputStream;
	}
	
	public void reset() {
		this.socket = null;
		this.outputStream = null;
		this.inputStream = null;
	}
	
	public void send(Packet packet) throws IOException {
		this.outputStream.writeObject(packet);
		this.outputStream.flush();
	}
}

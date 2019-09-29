package om.common;

public class Packet {
	/*
	 * Custom packet, depends on the utilization of this library
	 * In this example, it's a simple packet containing an object and a number
	 */
	
	private Object obj;
	private int nb;
	
	public Packet() {
	}
	
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	public Object getObj() {
		return obj;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}
	
	public int getNb() {
		return nb;
	}

}

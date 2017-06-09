import java.awt.Point;

public class Entrance {

	private int x;
	private int y;
	private String destination;
	private int dDoor;
	
	public Entrance(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setPairDoor(int d) {
		dDoor = d;
	}
	
	public void setDestination(String dest) {
		destination = dest;
	}
	
	public String getDest() {
		return destination;
	}
	
	public int getPaired() {
		return dDoor;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}

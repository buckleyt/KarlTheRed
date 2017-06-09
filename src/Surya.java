import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Surya extends Player{

	private int x;
	private int y;
	
	public Surya(String str) {
		super(str); 
		
	}
	
	public void move(int px, int py) {
		x += px;
		y += py;
	}
	
	public JLabel getLabel() {
		return new JLabel(new ImageIcon("Karl the Red.jpeg"));
	}

}

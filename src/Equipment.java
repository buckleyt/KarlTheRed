import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Equipment {
	
	private ImageIcon image;
	
	public Equipment(String imageName) {
		image = new ImageIcon(imageName);
	}
	
	public JLabel getLabel() {
		return new JLabel(image);
	}
	
}

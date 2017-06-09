import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Gooey {
	
	private static ArrayList<JLabel> healthLabels() {
		ArrayList<JLabel> v = new ArrayList<>();
		int healthFrac = (int) ((double) Player.getCurrentHealth() / Player.getMaxHealth()) * 294;
		for (int i = 0; i < healthFrac; i++) {
			JLabel j = new JLabel(new ImageIcon("Slither of Health.jpeg"));
			j.setLocation(-26 + i, 780);
			j.setSize(100, 100);
			v.add(j);
		}
		JLabel c = new JLabel(new ImageIcon("Health Bar.jpeg"));
		c.setLocation(20, 800);
		c.setSize(300, 60);
		v.add(c);
		return v;
	}
	
	private static ArrayList<JLabel> experience() {
		ArrayList<JLabel> v = new ArrayList<>();
		System.out.println(" ");
		System.out.println(Player.experience);
		System.out.println(Player.nextLevelXP);
		
		int xpFrac = (int) ((double) Player.experience / Player.nextLevelXP);
//		xpFrac *= 162;
//		xpFrac = 97;
//		System.out.println(Player.experience);
		System.out.println(xpFrac);
		for (int i = 0; i < xpFrac; i++) {
			JLabel j = new JLabel(new ImageIcon("Slither of Experience.png"));
			j.setLocation(20 + i, 740);
			j.setSize(300, 60);
			v.add(j);
		}
		JLabel c = new JLabel(new ImageIcon("Experience Bar.jpeg"));
		c.setLocation(20, 740);
		c.setSize(300, 60);
		v.add(c);
		c = new JLabel(new ImageIcon("Level Indicator.jpeg"));
		c.setLocation(-100, 740);
		c.setSize(300, 60);
		v.add(c);
		return v;
	}
	
	public static ArrayList<JLabel> drawGooey() {
		ArrayList<JLabel> v = new ArrayList<>();
		for (JLabel j : healthLabels()) {
			v.add(j);
		}
		for (JLabel j : experience()) {
			v.add(j);
		}
		return v;
	}
	
}

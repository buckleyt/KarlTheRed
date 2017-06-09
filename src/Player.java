import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player {

	private Armour armour;
	private static int maxHealth;
	private static int currentHealth;
	private static int level;
	public static int experience;
	public static int nextLevelXP;
	private static int xcord;
	private static int ycord;
	private ArrayList<Equipment> equipment;
	private static String facing;
	private static JLabel karl;
	private boolean[] moving; // Never eat shredded wheat, the muscles are very
								// chewy and fat wheat is a lot more tasty

	public Player(String str) {
		equipment = new ArrayList<>();
		level = 1;
		experience = 0;
		nextLevelXP = 10;
		xcord = 135;
		ycord = 60;
		facing = "NORTH";
		maxHealth = 20;
		currentHealth = 20;
		karl = new JLabel(new ImageIcon("Karl the Red Prison Down.png"));
		karl.setSize(70, 120);
		karl.setLocation(xcord, ycord);
		moving = new boolean[4];
	}

	public ArrayList<JLabel> characterComponents() {
		ArrayList<JLabel> labels = new ArrayList<>();
		labels.add(armour.getLabel());
		for (Equipment e : equipment) {
			labels.add(e.getLabel());
		}
		return labels;
	}

	public void setPos(int x, int y) {
		xcord = (x * 60) + 9;
		ycord = (y * 60) + 79;
	}
	
	public int x() {
		return xcord;
	}
	
	public int y() {
		return ycord;
	}
	
	public void setFacing(String str) {
		facing = str;
		if (str.equals("NORTH")) {
			moving[0] = true;
			moving[2] = false;
			karl.setIcon(new ImageIcon("Karl the Red Prison Back.png"));
		} else if (str.equals("SOUTH")) {
			moving[0] = false;
			moving[2] = true;
			karl.setIcon(new ImageIcon("Karl the Red Prison Down.png"));
		} else if (str.equals("WEST")) {
			moving[1] = false;
			moving[3] = true;
			karl.setIcon(new ImageIcon("Karl the Red Prison Left.png"));
		} else if (str.equals("EAST")) {
			moving[1] = true;
			moving[3] = false;
			karl.setIcon(new ImageIcon("Karl the Red Prison Right.png"));
		}
	}

	public void keyReleased(String str) {
		if (str.equals("NORTH")) {
			moving[0] = false;
		} else if (str.equals("SOUTH")) {
			moving[2] = false;
		} else if (str.equals("WEST")) {
			moving[3] = false;
		} else if (str.equals("EAST")) {
			moving[1] = false;
		}
	}

	public ArrayList<JLabel> getLabels() {
//		System.out.println((xcord + 9) + ", " + (ycord + 78));
		ArrayList<JLabel> v = new ArrayList<>();
		v.add(karl);
		if (moving[0] && LetsGetCreative.currentRoom.getMesh().walkable((xcord + 9) / 60, (ycord + 74) / 60)) {
			ycord -= 4;
		}
		else if (moving[1] && LetsGetCreative.currentRoom.getMesh().walkable((xcord + 13) / 60, (ycord + 79) / 60)) {
			xcord += 4;
		}
		else if (moving[2] && LetsGetCreative.currentRoom.getMesh().walkable((xcord + 9) / 60, (ycord + 83) / 60)) {
			ycord += 4;
		}
		else if (moving[3] && LetsGetCreative.currentRoom.getMesh().walkable((xcord + 5) / 60, (ycord + 79) / 60)) {
			xcord -= 4;
		} else {
//			System.out.println("can't move");
		}
		karl.setLocation(xcord, ycord);
		return v;
	}

	public static int getMaxHealth() {
		return maxHealth;
	}

	public static int getCurrentHealth() {
		return currentHealth;
	}

	public int getLevel() {
		return level;
	}

	public void getXP(int xp) {
		experience += xp;
		if (experience >= nextLevelXP) {
			level++;
			experience -= nextLevelXP;
			nextLevelXP *= 1.6;
		}
	}
	
	public int getXP() {
		return experience;
	}
	
	public int[] karlToMap(int x, int y) {
		int[] v = new int[2];
		v[0] = (x + 9) / 60;
		v[1] = (y + 79) / 60;
		return v;
	}
	
	public int[] karlOnMap() {
		int[] v = new int[2];
		v[0] = (xcord + 9) / 60;
		v[1] = (ycord + 79) / 60;
		return v;
	}

}

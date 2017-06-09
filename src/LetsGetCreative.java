import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LetsGetCreative extends JPanel implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Room currentRoom;
	private Player karl;
	private boolean justChanged;

	public LetsGetCreative() {
		setLayout(null);
		karl = new Player("Teymor");
		// ImageIcon pic = new ImageIcon("Opening Scene.png");
		// JLabel j = new JLabel(pic);
		// j.setLocation(0, 0);
		// j.setSize(1425, 800);
		// add(j);
		this.setBackground(new Color(10, 10, 10));
//		 currentRoom = new Room("Jail Warden's Office.txt");
		currentRoom = new Room("Main Jail Room.txt");
		// currentRoom = new Room("Boss Room.txt");
//		paintItBlack();
		drawKarl();
		drawGooey();
		drawRoom();
		karl.setPos(currentRoom.getEntrances().get(0).getX(), currentRoom.getEntrances().get(0).getY() - 2);
		// clear();
	}

	public void playGame() {
		long lastUpdate = System.currentTimeMillis();
		while (true) {
			if (System.currentTimeMillis() - lastUpdate > 10) {
				setLayout(null);
				this.setBackground(new Color(10, 10, 10));
				drawGooey();
				// drawRoom();
//				 this.removeAll();
				drawKarl();
//				paintItBlack();
				if (justChanged) {
					drawGooey();
					drawRoom();
					justChanged = false;
				}
//				drawGooey();
				this.repaint();
				lastUpdate = System.currentTimeMillis();
			}
		}
	}

	public void paintItBlack() {
		JLabel j = new JLabel(new ImageIcon("Paint it Black.jpeg"));
		j.setSize(2000, 2000);
		j.setLocation(-100, -100);
		add(j);
	}

	public void clear() {
		while (this.getComponentCount() > 1) {
			this.remove(this.getComponent(1));
		}
	}

	public void drawRoom() {
		for (JLabel j : currentRoom.getLabels()) {
			add(j);
		}
	}

	public void changeRoom(String name, int entrance) {
		currentRoom = new Room(name);
//		System.out.println(name);
		karl.setPos(currentRoom.getEntrances().get(entrance).getX(), currentRoom.getEntrances().get(entrance).getY() - 2);
		// clear();
		justChanged = true;
		this.removeAll();
		drawRoom();
		drawGooey();
		this.repaint();
		karl.getXP(2);
//		paintItBlack();
	}

	public void drawKarl() {
		// this.removeAll();
		for (JLabel j : karl.getLabels()) {
			this.add(j, 0);
		}
	}

	public void drawGooey() {
		for (JLabel j : Gooey.drawGooey()) {
			add(j);
		}
	}

	public void useDoor() {
		int[] c = karl.karlOnMap();
		int x = c[0];
		int y = c[1];
//		System.out.println(x + ", " + y);
		if (currentRoom.onDoor(x, y)) {
//			System.out.println("on door");
			changeRoom(currentRoom.door(x, y).getDest(), currentRoom.door(x, y).getPaired());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			karl.setFacing("NORTH");
			// System.out.println("You pressed w sir");
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			karl.setFacing("WEST");
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			karl.setFacing("SOUTH");
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			// System.out.println("Right away sir");
			karl.setFacing("EAST");
		} else if (e.getKeyCode() == KeyEvent.VK_F) {
			useDoor();
			// System.out.println("using door");
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			paintItBlack();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			karl.keyReleased("NORTH");
			// System.out.println("You pressed w sir");
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			karl.keyReleased("WEST");
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			karl.keyReleased("SOUTH");
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			// System.out.println("Right away sir");
			karl.keyReleased("EAST");
		}
	}

}

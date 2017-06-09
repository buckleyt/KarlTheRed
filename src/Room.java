import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Room {

	private ArrayList<Entrance> entrances;
	private ArrayList<ArrayList<JLabel>> grid;
	private Point topLeft;
	private int type;
	private String floor;
	private int num;
	private Mesh mesh;

	// public static void main(String[] args) {
	// Room r = new Room("Jail Warden's Office.txt");
	// }

	public Mesh getMesh() {
		return mesh;
	}

	public ArrayList<Entrance> getEntrances() {
		return entrances;
	}

	public Room(String str) {
		// System.out.println("How many new rooms are we making?");
		mesh = new Mesh();
		entrances = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = null;
		grid = new ArrayList<>();
		try {

			fr = new FileReader(str);
			br = new BufferedReader(fr);
			br = new BufferedReader(new FileReader(str));
			String sCurrentLine;
			int row = 0;
			int entrancesFull = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.charAt(0) == '|' || sCurrentLine.charAt(0) == '\\' || sCurrentLine.charAt(0) == 'd'
						|| sCurrentLine.charAt(0) == 'x') {
					// System.out.println(sCurrentLine);
					grid.add(new ArrayList<JLabel>());
					for (int i = 0; i < sCurrentLine.length(); i++) {
						grid.get(row).add(getLabel(sCurrentLine.charAt(i)));
						if (sCurrentLine.charAt(i) == 'D' || sCurrentLine.charAt(i) == 'd') {
							entrances.add(new Entrance(i, row));
						}
						mesh.walkable.add(new ArrayList<Boolean>());
						if (sCurrentLine.charAt(i) == ' ' || sCurrentLine.charAt(i) == 'd'
								|| sCurrentLine.charAt(i) == 'D') {
							mesh.setWalkable(i, row, true);
						} else {
							mesh.setWalkable(i, row, false);
						}
					}
					row++;
				}
				if (sCurrentLine.length() > 7 && sCurrentLine.substring(0, 6).equals("Door: ")) {
					sCurrentLine = sCurrentLine.substring(6);
					if (Character.isDigit(sCurrentLine.charAt(0))) {
						System.out.println(str);
						entrances.get(entrancesFull).setPairDoor(Character.getNumericValue(sCurrentLine.charAt(0)));
						sCurrentLine = sCurrentLine.substring(2);
						entrances.get(entrancesFull).setDestination(sCurrentLine);
						// System.out.println(sCurrentLine);
						entrancesFull++;
					}

				}
				if (sCurrentLine.length() > 7 && sCurrentLine.substring(0, 6).equals("Type: ")) {
					sCurrentLine = sCurrentLine.substring(6);
					System.out.println(str);
					if (Character.isDigit(sCurrentLine.charAt(0))) {
						type = Character.getNumericValue(sCurrentLine.charAt(0));
					}

				}
				if (str.equals("Garden.txt")) {
					type = 1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		// for (ArrayList<Boolean> v : mesh.walkable) {
		// for (Boolean b : v) {
		// if (b) {
		// System.out.print("T");
		// } else {
		// System.out.print("F");
		// }
		// }
		// System.out.println("");
		// }

	}

	public boolean onDoor(int x, int y) {
		for (Entrance e : entrances) {
			if (e.getX() == x && e.getY() == y) {
				return true;
			}
		}
		return false;
	}

	public Entrance door(int x, int y) {
		if (onDoor(x, y)) {
			for (Entrance e : entrances) {
				if (e.getX() == x && e.getY() == y) {
					return e;
				}
			}
		}
		return null;

	}

	public ArrayList<JLabel> getLabels() {
		ArrayList<JLabel> labels = new ArrayList<>();
		for (int i = 0; i < grid.size(); i++) {
			for (int j = 0; j < grid.get(i).size(); j++) {
				grid.get(i).get(j).setLocation(j * 60, i * 60);
				grid.get(i).get(j).setSize(100, 100);
				labels.add(grid.get(i).get(j));
			}
		}
		return labels;
	}

	private JLabel getLabel(char c) {
		if (type == 0) {
			if (c == '|' || c == '\\' || c == '_') {
				// return randomWall();
				return new JLabel(new ImageIcon("Prison Wall 2.jpeg"));
			} else if (c == 'D') {
				return new JLabel(new ImageIcon("Prison Door.jpeg"));
			} else if (c == 'd') {
				return new JLabel(new ImageIcon("Side Door.jpeg"));
			} else if (c == ' ') {
				return new JLabel(new ImageIcon("Prison Wall.jpeg"));
			} else if (c == 'T') {
				return new JLabel(new ImageIcon("Prison Table.jpeg"));
			} else if (c == 'B') {
				return new JLabel(new ImageIcon("Bookshelf.jpeg"));
			} else if (c == 'd') {
				return new JLabel(new ImageIcon("Dead.jpeg"));
			} else if (c == 'f') {
				return new JLabel(new ImageIcon("Fire Pit.jpeg"));
			} else if (c == 'x') {
				return new JLabel(new ImageIcon("Dead.png"));
			}
		} else if (type == 1) {
			if (c == '|' || c == '\\' || c == '_') {
				// return randomWall();
				return new JLabel(new ImageIcon("Garden Wall.jpeg"));
			} else if (c == 'D') {
				return new JLabel(new ImageIcon("Garden Gate.jpeg"));
			} else if (c == 'd') {
				return new JLabel(new ImageIcon("Side Gate.jpeg"));
			} else if (c == ' ') {
				return new JLabel(new ImageIcon("Grass.jpeg"));
			} else if (c == 'B') {
				return new JLabel(new ImageIcon("Bush.jpeg"));
			} else if (c == 'f') {
				return new JLabel(new ImageIcon("Flower.jpeg"));
			} else if (c == 'x') {
				return new JLabel(new ImageIcon("Dead.png"));
			}
		}
		return null;
	}

}

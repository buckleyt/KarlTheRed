import java.util.ArrayList;

public class Mesh {

	public ArrayList<ArrayList<Boolean>> walkable;

	public Mesh() {
		walkable = new ArrayList<>();
	}

	public void setWalkable(int r, int c, boolean b) {
		walkable.get(r).add(b);
	}

	public boolean walkable(int r, int c) {
		if (r >= walkable.size() || c >= walkable.get(r).size() || r < 0 || c < 0) {
			return false;
		} else {
			return walkable.get(r).get(c);
		}
	}

}

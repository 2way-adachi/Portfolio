package model;

public class Goal extends Position {
	private int x;
	private int y;
	private int width;
	private int height;
	public Goal(int[][] map,Current c) {
		this.setSize(map);
		do {
			int goalX = (int)(Math.random()*width);
			int goalY = (int)(Math.random()*height);
			if(map[goalY][goalX] != 1 && c.getX() != goalX && c.getY() != goalY) {
				this.x = goalX;this.y=goalY;
				break;
			}
		} while (true);
		map[this.y][this.x] = 3;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setSize(int[][] map) {
		this.width = map[0].length;
		this.height = map.length;
	}
}

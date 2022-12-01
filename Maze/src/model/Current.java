package model;

import java.time.format.DateTimeFormatter;

public class Current extends Position {
	private int x;
	private int y;
	private int width;
	private int height;
	private int start;
	private boolean goal = false;
	private int steps = 0;
	private long startTime;
	private String playTime ="";
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd/HH:mm:ss");

	public Current(int[][] map) {
		this.setSize(map);
		this.startTime = System.currentTimeMillis();
		do {
			int startX = (int) (Math.random() * width);
			int startY = (int) (Math.random() * height);
			if (map[startY][startX] != 1) {
				this.x = startX;
				this.y = startY;
				break;
			}
		} while (true);
		map[this.y][this.x] = 2;
	}

	public void setSize(int[][] map) {
		this.width = map[0].length;
		this.height = map.length;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getStart() {
		return start;
	}

	public int[][] moveCurrent(int[][] map, int x, int y) {
		int tx = this.x + x;
		int ty = this.y + y;
		if (0 <= tx && tx < map[0].length && 0 <= ty && ty < map.length && map[ty][tx] == 0) {
			map[ty][tx] = 2; // 移動先を現在地に
			map[this.y][this.x] = 0; // 居た場所を通路に
			//			System.out.println("moveC:true");
			this.x = tx;
			this.y = ty;
			this.steps += 1;
			return map;
		}
		if (map[ty][tx] == 3) {
			this.goal = true;
			long goalTime = System.currentTimeMillis();
			long playTimeMillis = goalTime - this.startTime;
//			System.out.println(this.startTime);
//			System.out.println(goalTime);
//			System.out.println(playTimeMillis);
			this.playTime += playTimeMillis/1000/60%60+ "分" + playTimeMillis/1000%60 + "秒" + playTimeMillis%1000 +"でした";
		}
		return map;
	}

	public String getPlayTime() {
		return playTime;
	}

	public int getSteps() {
		return steps;
	}

	public boolean isGoal() {
		return goal;
	}

}

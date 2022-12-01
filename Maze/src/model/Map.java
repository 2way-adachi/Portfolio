package model;

import java.util.ArrayList;
import java.util.Collections;

public class Map extends Position {
	private int[][] map;
	private String[][] viewMap;
	private ArrayList<CreateWallStartPosition> pillar = new ArrayList<CreateWallStartPosition>();
	private ArrayList<Direction> directions = new ArrayList<Direction>();

	// チェックする方向
	public void setDirections() {
		directions.add(new Direction(0, -1)); // U
		directions.add(new Direction(0, 1)); // D
		directions.add(new Direction(-1, 0)); // L
		directions.add(new Direction(1, 0)); // R
	}

	// コンストラクター
	// 受け取ったサイズから迷路の構造を作成
	public Map(int x, int y) {
		this.viewMap = new String[y][x];
//		上下左右の端を壁に
		this.map = new int[y][x];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (i == 0 || j == 0 || i == map.length - 1 || j == map[i].length - 1) {
					this.map[i][j] = 1;
				}
			}
		}
//		壁伸ばしスタートポイントの決定
		mapping(this.map);
//		チェック方向の登録
		setDirections();
//		壁を生やす
		createWallSet();
//		確認用
//		for (int i = 0; i < map.length; i++) {
//			for(int j = 0; j<map[i].length; j++) {
//				System.out.print(map[i][j]); 
//			}
//			System.out.println();
//		}
	}

//	壁を生やす壁のポイントを配列にセット
	public void mapping(int[][] map) {
		for (int y = 0; y < map.length; y += 2) {
			pillar.add(new CreateWallStartPosition(0, y));
			pillar.add(new CreateWallStartPosition(map[0].length-1, y));
		}
		for (int x = 0; x < map[0].length; x += 2) {
			pillar.add(new CreateWallStartPosition(x, 0));
			pillar.add(new CreateWallStartPosition(x, map.length-1));

		}
//		for(CreateWallStartPosition key:pillar)
//		{
//			System.out.print("x:"+key.getX()+"y:"+key.getY());
//			System.out.println();
//		}
//		Collections.shuffle(pillar);
//		System.out.println("shuffle");
//		for(CreateWallStartPosition key:pillar)
//		{
//			System.out.print("x:"+key.getX()+"y:"+key.getY());
//			System.out.println();
//		}
	}

//	壁スタートポイントが無くなるまで、先頭のポイントをcreateWallに渡し続ける
	public void createWallSet() {
		while (0 < pillar.size()) {
			CreateWallStartPosition next = pillar.remove(0);
//			System.out.println("nextX:"+next.getX()+"nextY"+next.getY());
			createWall(next.getX(), next.getY());
		}
	}

//	受け取ったスタートポイントから壁を生やす
	public void createWall(int x, int y) {
//		向きをランダムに決定
		Collections.shuffle(directions);
//		スタートから2マス先までの状況を確認
		for (Direction d : directions) {
			int tx = x + d.getX();
			int ty = y + d.getY();
			int tx2 = x + (d.getX() * 2);
			int ty2 = y + (d.getY() * 2);
//			生やせたら生やす
			if (0 <= tx2 && tx2 < this.map[0].length && 0 <= ty2 && ty2 < this.map.length) {
				if (map[ty][tx] == 0 && map[ty2][tx2] == 0) {
//					System.out.println("x:" + x + " y" + y);
					map[ty][tx] = 1;
					map[ty2][tx2] = 1;
//				生やせたら、続けて生やすために先頭に再度追加
					pillar.add(0, new CreateWallStartPosition(tx2, ty2));
//				他の向きはチェックしていないので、また後で生やせるようにするために後ろに追加
					pillar.add(pillar.size(), new CreateWallStartPosition(x, y));
					break;
				}
			}
		}
	}

	public String[][] displayMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				switch (map[i][j]) {
				case 0:
					this.viewMap[i][j] = "<span>&emsp;</span>";
					break; // 通路
				case 1:
					this.viewMap[i][j] = "<span style=\"background:black\">&emsp;</span>";
					break; // 壁
				case 2:
					this.viewMap[i][j] = "<span id=\"current\">現</span>";
					break; // 現在地
				case 3:
					this.viewMap[i][j] = "<span id=\"goal\">出</span>";
					break; // ゴール
				}
			}
		}
		return this.viewMap;
	}

	public void setMap(int[][] map) {
		this.map = map;
		this.viewMap = this.displayMap(this.map);
	}

//	げったー
	public int[][] getMap() {
		return this.map;
	}

	public String[][] getViewMap() {
		return this.viewMap;
	}
}

package model;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

@Data
public class CategoryNames implements Serializable {
	private ArrayList<String> names = new ArrayList<>();
	private ArrayList<String> displayNames = new ArrayList<>();
	private ArrayList<String> tax8nameList = new ArrayList<>();
	private ArrayList<String> tax10nameList = new ArrayList<>();

	private String take_out;
	private String frozen;
	private String health_foods;
	private String drink;
	private String snack;
	private String process;
	private String milk;
	private String instant;
	private String bread;
	private String meet_fish;
	private String vegetable;
	private String baby_food;
	private String spice;
	//	Tax10%
	private String wash;
	private String baby_goods;
	private String clean;
	private String paper;
	private String pet;
	private String body;
	private String hair;

	public CategoryNames() {
		//	Tax8%
		displayNames.add("弁当");
		displayNames.add("冷凍食品");
		displayNames.add("健康系食品");
		displayNames.add("飲み物類");
		displayNames.add("お菓子類");
		displayNames.add("加工食品");
		displayNames.add("乳／大豆製品・卵");
		displayNames.add("インスタント食品");
		displayNames.add("パン類");
		displayNames.add("肉・魚");
		displayNames.add("野菜・果物");
		displayNames.add("ミルク/離乳食");
		displayNames.add("調味料・粉類");
		//	Tax10%
		displayNames.add("洗濯用品");
		displayNames.add("子育て用品");
		displayNames.add("掃除用品");
		displayNames.add("トイレ・紙用品");
		displayNames.add("ペット用品");
		displayNames.add("ボディケア用品");
		displayNames.add("ヘアケア用品");

		//	Tax8%
		names.add("take_out");
		names.add("frozen");
		names.add("health_foods");
		names.add("drink");
		names.add("snack");
		names.add("process");
		names.add("milk");
		names.add("instant");
		names.add("bread");
		names.add("meet_fish");
		names.add("vegetable");
		names.add("baby_food");
		names.add("spice");
		addTax8List();

		//	Tax10%
		names.add("wash");
		names.add("baby_goods");
		names.add("clean");
		names.add("paper");
		names.add("pet");
		names.add("body");
		names.add("hair");
		addTax10List();
	}

	public void addTax8List() {
		for (int i = 0; i < this.names.size(); i++) {
			this.tax8nameList.add(this.names.get(i));
		}
	}

	public void addTax10List() {
		int size = (this.names.size()) - (this.tax8nameList.size());
		for (int i = 0; i < size; i++) {
			this.tax10nameList.add(this.names.get(i + this.tax8nameList.size()));
		}
	}

}

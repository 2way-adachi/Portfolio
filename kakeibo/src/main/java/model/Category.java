package model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Category implements Serializable{
	//	フィールド
	private String displayName;
	private String name;
	private String data;
	private String largeCategory;

	//	コンストラクタ
	public Category(String displayName, String name, String data) {
		super();
		this.displayName = displayName;
		this.name = name;
		this.data = data;
		setLargeCategory(name);
	}
	public void setLargeCategory(String s) {
		CategoryNames cn = new CategoryNames();
		if(cn.getTax8nameList().contains(s)) {
			this.largeCategory = "食費";
		}else if(cn.getTax10nameList().contains(s)) {
			this.largeCategory = "日用品";
		}
	}
}
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Data
@Component
@SessionScope
public class PostData extends CategoryNames implements Serializable{
	private String tax;
	private String comment;
	private String date;
	private ArrayList<Category> activeDataList = new ArrayList<>();
	private ArrayList<String> dataList = new ArrayList<>();
	
	
	public void replaceDate() {
		this.date = this.date.replace('-','/');
	}
	
	public void dataZeroCheck(String data,String name,String display) {
		this.dataList.add(data);
		if(!(data.equals("0"))) {
			this.activeDataList.add(new Category(display,name,data));
		}
	}
	public void addData() {
		dataZeroCheck(this.getTake_out(),getNames().get(0),getDisplayNames().get(0));
		dataZeroCheck(this.getFrozen(),getNames().get(1),getDisplayNames().get(1));
		dataZeroCheck(this.getHealth_foods(),getNames().get(2),getDisplayNames().get(2));
		dataZeroCheck(this.getDrink(),getNames().get(3),getDisplayNames().get(3));
		dataZeroCheck(this.getSnack(),getNames().get(4),getDisplayNames().get(4));
		dataZeroCheck(this.getProcess(),getNames().get(5),getDisplayNames().get(5));
		dataZeroCheck(this.getMilk(),getNames().get(6),getDisplayNames().get(6));
		dataZeroCheck(this.getInstant(),getNames().get(7),getDisplayNames().get(7));
		dataZeroCheck(this.getBread(),getNames().get(8),getDisplayNames().get(8));
		dataZeroCheck(this.getMeet_fish(),getNames().get(9),getDisplayNames().get(9));
		dataZeroCheck(this.getVegetable(),getNames().get(10),getDisplayNames().get(10));
		dataZeroCheck(this.getBaby_food(),getNames().get(11),getDisplayNames().get(11));
		dataZeroCheck(this.getSpice(),getNames().get(12),getDisplayNames().get(12));
//		Tax10%
		dataZeroCheck(this.getWash(),getNames().get(13),getDisplayNames().get(13));
		dataZeroCheck(this.getBaby_goods(),getNames().get(14),getDisplayNames().get(14));
		dataZeroCheck(this.getClean(),getNames().get(15),getDisplayNames().get(15));
		dataZeroCheck(this.getPaper(),getNames().get(16),getDisplayNames().get(16));
		dataZeroCheck(this.getPet(),getNames().get(17),getDisplayNames().get(17));
		dataZeroCheck(this.getBody(),getNames().get(18),getDisplayNames().get(18));
		dataZeroCheck(this.getHair(),getNames().get(19),getDisplayNames().get(19));
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostData other = (PostData) obj;
		return Objects.equals(comment, other.comment) && Objects.equals(date, other.date)
				&& Objects.equals(tax, other.tax);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(comment, date, tax);
		return result;
	}
}

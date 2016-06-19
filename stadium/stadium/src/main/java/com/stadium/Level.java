package stadium;

import java.util.ArrayList;

public class Level {
	private int level_id;
	private String level_name;
	private int level_price;
	private ArrayList<Rows> row;
//getters and setters for each level price
	public int getLevel_price() {
		return level_price;
	}

	public void setLevel_price(int level_price) {
		this.level_price = level_price;
	}
	//geetters and setters for each level name
	public String getLevel_name() {
		return level_name;
	}

	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}
//getters and setters for each levelid
	public int getLevel_id() {
		return level_id;
	}

	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}
	//in each level there are many rows
	public ArrayList<Rows> getrow() {
		return row;
	}

	public void setRows(ArrayList<Rows> row) {
		this.row = row;
	}

}

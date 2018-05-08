package food.vo;

public class Restaurant {

	private String name;
	private String type;
	private int price;
	private double rate;
	private int rperson;
	private int hits;
	private String phonenum;
	private String dtime;

	public Restaurant() {
	}

	public Restaurant(String name, String type, int price, String phonenum, String dtime) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.phonenum = phonenum;
		this.dtime = dtime;
	}

	public int getrperson() {
		return rperson;
	}

	public void setrperson(int rperson) {
		this.rperson = rperson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getHits() {
		return hits;
	}

	public String getDtime() {
		return dtime;
	}

	public void setDtime(String dtime) {
		this.dtime = dtime;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	@Override
	public String toString() {
		return type+"[음식점이름=" + name +",  가격=" + price + "원 , 평점=" + rate + ", 평점자 수 "
				+ rperson + ", 조회수=" + hits + ", 전화번호=" + phonenum + ", 시간/거리=" + dtime + "]";
	}

}

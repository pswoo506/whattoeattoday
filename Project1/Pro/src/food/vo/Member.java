package food.vo;

public class Member {
	private String id;
	private String pw;
	private int mileage;

	public Member() {
	}

	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return "[id:" + id + ", pw:" + pw + ", mileage:" + mileage + "]";
	}

}

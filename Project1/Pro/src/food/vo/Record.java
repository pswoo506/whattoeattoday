package food.vo;

public class Record {
	private String id;
	private int game1;
	private int game2;
	private int game3;
	

	public Record() {
	}

	public Record(String id) {
		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getGame1() {
		return game1;
	}

	public void setGame1(int game1) {
		this.game1 = game1;
	}

	public int getGame2() {
		return game2;
	}

	public void setGame2(int game2) {
		this.game2 = game2;
	}

	public int getGame3() {
		return game3;
	}

	public void setGame3(int game3) {
		this.game3 = game3;
	}


	@Override
	public String toString() {
		return "�������� [id:" + id + ", 2000�� ��������:" + game1 + "��, 3000�� ��������: " + game2 + "��, 5000�� ��������: " + game3 + "��" + "]";
	}

}

package event3;



/**
 * �÷��̾� ������ ������ Ŭ����
 * 
 *
 */
public class PlayerVO  {
	private String name;
	private int score;

	public PlayerVO(String name, int score) {
	
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "�̸� : " + name + "\t\t ����=" + score;
	}

}

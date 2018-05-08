package event3;



/**
 * 플레이어 정보를 저장할 클래스
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
		return "이름 : " + name + "\t\t 점수=" + score;
	}

}

package event3;

/**
 * 문제 정보를 가지고 있는 클래스
 * 문제에 공개되는 초성과 답을 출력
 *
 */
public class Quest {
	private String answer;
	private String ex;
	private String view;

	public Quest(String answer, String ex) {
		super();
		this.answer = answer;
		this.ex = ex;
	}

	public Quest() {
		// TODO Auto-generated constructor stub
	}

	public void showExample() {
		System.out.printf("%s\n", ex);
		System.out.printf("초성 : %s\n", view);
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getEx() {
		return ex;
	}

	public void setEx(String ex) {
		this.ex = ex;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

}

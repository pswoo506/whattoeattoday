package event3;

/**
 * ���� ������ ������ �ִ� Ŭ����
 * ������ �����Ǵ� �ʼ��� ���� ���
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
		System.out.printf("�ʼ� : %s\n", view);
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

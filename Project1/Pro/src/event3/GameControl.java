package event3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import event3.Quest;

/**
 * ���ӿ� �ʿ��� ������ �����ϴ� Ŭ����
 * ������ �ؽ�Ʈ���Ͽ� ����
 * questŬ�������� ����Ʈ�� �����ǰ�����
 * 
 * 
 *
 */
public class GameControl {
	private static GameControl instance = new GameControl();
	// ������ ����� ���� ���
	private File[] list;
	// ������ �о�� ��Ʈ��
	private BufferedReader br;
	// ��� �������� ������ ����Ʈ �迭
	private ArrayList<Quest> qlist[];

	/**
	 * �� �оߺ� �������� ������ ����Ʈ�� ����
	 */
	private GameControl() {
		super();
		// TODO Auto-generated constructor stub
		qlist = new ArrayList[5];
		for (int i = 0; i < qlist.length; i++) {
			qlist[i] = new ArrayList<Quest>();
		}
		list = new File[5];
		list[0] = new File("it.txt");
		list[1] = new File("movie.txt");
		list[2] = new File("singer.txt");
		list[3] = new File("singer2.txt");
		list[4] = new File("movie2.txt");
		loadQuest();
	}

	public static GameControl getInstance() {
		return instance;
	}

	/**
	 * ���� �о����
	 */
	public void loadQuest() {
		System.out.println("���� ���� ����...");
		try {
			String str;
			for (int i = 0; i < list.length; i++) {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(list[i])));
				while (true) {
					Quest q = new Quest();
					str = br.readLine();
					if (str == null)
						break;
					q.setEx(str);
					str = br.readLine();
					q.setAnswer(str);
					q.setView(makerView(str));
					qlist[i].add(q);
				}
			}
			System.out.println("���� ���� �Ϸ�!!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * �ʼ� ����� �޼���
	 */
	private String makerView(String str) {
		// TODO Auto-generated method stub
		String view = new String();
		for (int i = 0; i < str.length(); i++) {
			int no = str.charAt(i);
			view += convertor(no);
		}
		return view;
	}

	/**
	 * �ش� ���� �ڵ带 �м��Ͽ� �ش� �������� ����
	 * 	
	 *            �����ڵ�
	 * @return �ش� ���� ����
	 */
	private String convertor(int no) {
		// TODO Auto-generated method stub
		if (no >= '��' && no < '��')
			return "��";
		else if (no >= '��' && no < '��')
			return "��";
		else if (no >= '��' && no < '��')
			return "��";
		else if (no >= '��' && no < '��')
			return "��";
		else if (no >= '��' && no < '��')
			return "��";
		else if (no >= '��' && no < '��')
			return "��";
		else if (no >= '��' && no < '��')
			return "��";
		else if (no >= '��' && no < '��')
			return "��";
		else if (no >= '��' && no < '��')
			return "��";
		else if (no >= '��' && no < '��')
			return "��";
		else if (no >= '��' && no < '��')
			return "��";
		else if (no >= '��' && no < '��')
			return "��";
		else if (no >= '��' && no < '¥')
			return "��";
		else if (no >= '¥' && no < '��')
			return "��";
		else if (no >= '��' && no < 'ī')
			return "��";
		else if (no >= 'ī' && no < 'Ÿ')
			return "��";
		else if (no >= 'Ÿ' && no < '��')
			return "��";
		else if (no >= '��' && no < '��')
			return "��";
		else if (no >= '��' && no <= 55203)
			return "��";
		else
			return " ";
	}

	/**
	 * ���� ���� ����
	 * 
	 * @return ���� ������ ����� ����Ʈ
	 */
	public ArrayList<Quest> makeGame() {
		// TODO Auto-generated method stub
		ArrayList<Quest> list = new ArrayList<Quest>();
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		for (int i = 0; list.size() < 5; i++) {
			list.add(qlist[i].get(r.nextInt(qlist[i].size())));
		}
		return list;
	}
}

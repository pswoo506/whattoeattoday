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
 * 게임에 필요한 문제를 생성하는 클래스
 * 문제는 텍스트파일에 저장
 * quest클래스에서 리스트로 관리되고있음
 * 
 * 
 *
 */
public class GameControl {
	private static GameControl instance = new GameControl();
	// 문제가 저장된 파일 경로
	private File[] list;
	// 문제를 읽어올 스트림
	private BufferedReader br;
	// 모든 문제들을 저장할 리스트 배열
	private ArrayList<Quest> qlist[];

	/**
	 * 각 분야별 문제들을 저장할 리스트를 생성
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
	 * 문제 읽어오기
	 */
	public void loadQuest() {
		System.out.println("문제 생성 시작...");
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
			System.out.println("문제 생성 완료!!");
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
	 * 초성 만드는 메서드
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
	 * 해당 글자 코드를 분석하여 해당 자음으로 변경
	 * 	
	 *            유니코드
	 * @return 해당 자음 리턴
	 */
	private String convertor(int no) {
		// TODO Auto-generated method stub
		if (no >= '가' && no < '까')
			return "ㄱ";
		else if (no >= '까' && no < '나')
			return "ㄲ";
		else if (no >= '나' && no < '다')
			return "ㄴ";
		else if (no >= '다' && no < '따')
			return "ㄷ";
		else if (no >= '따' && no < '라')
			return "ㄸ";
		else if (no >= '라' && no < '마')
			return "ㄹ";
		else if (no >= '마' && no < '바')
			return "ㅁ";
		else if (no >= '바' && no < '빠')
			return "ㅂ";
		else if (no >= '빠' && no < '사')
			return "ㅃ";
		else if (no >= '사' && no < '싸')
			return "ㅅ";
		else if (no >= '싸' && no < '아')
			return "ㅆ";
		else if (no >= '아' && no < '자')
			return "ㅇ";
		else if (no >= '자' && no < '짜')
			return "ㅈ";
		else if (no >= '짜' && no < '차')
			return "ㅉ";
		else if (no >= '차' && no < '카')
			return "ㅊ";
		else if (no >= '카' && no < '타')
			return "ㅋ";
		else if (no >= '타' && no < '파')
			return "ㅌ";
		else if (no >= '파' && no < '하')
			return "ㅍ";
		else if (no >= '하' && no <= 55203)
			return "ㅎ";
		else
			return " ";
	}

	/**
	 * 게임 문제 생성
	 * 
	 * @return 게임 문제가 저장된 리스트
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

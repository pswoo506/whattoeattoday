package event3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import event3.GameControl;

import event3.Quest;


public class GameMain {
	private static int score = 0;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * ������ �����ϴ� ���θ޼���
	 */

	public static void showMenu() {
		System.out.println("1. ���� ����");
		
	}

	public static int startmain() {

		int count = 0;// TODO Auto-generated method stub
		try {
			do  {

				showMenu();
				System.out.print("�޴� ��ȣ �Է� : ");
				int no = Integer.parseInt(br.readLine());
				if (no == 1) {
					score = 0;
					String answer;
					ArrayList<Quest> list = GameControl.getInstance().makeGame();
					try {
						for (int i = 0; i < list.size(); i++) {
							System.out.println((i + 1) + "�� ����");
							list.get(i).showExample();
							System.out.print("��=>");
							answer = br.readLine();
							if (answer.equals(list.get(i).getAnswer())) {
								System.out.println("����");
								score += 20;
							} else {
								System.out.println("����");
								score -= 10;
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					} 
					
				}

				++count;
			}while(count < 1);	
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return score;
	} 
}
package event4;

/*
 * �ͼ�������� ���ڿ������ �����ϴ� Ŭ����
 * �迭�� �����Լ��̿��Ͽ� ������ ����
 */

import java.util.Scanner;


public class Quiz {
	

	public static int start() {

		int i = 0, i2 = 0, a = 0, b = 0, b2 = 0, c = 0, y = 0, z = 0, answer = 0, r = 0, q = 0, cal = 0;
		int array[] = new int[30];
		int array1 = 0;
		String answer1 = ""; 
		String answer2 = "";
		
		// i=���й�������, b2=�ͼ�����������, z=���� Ƚ��, r=�ѹ�����
		Scanner scan = new Scanner(System.in);
		int count = 0;
		do {
			
			z = 0;
			y = 0;
			array1 = 0;
			System.out.println("");
			System.out.println("�ͼ���/���� �����Դϴ�.");
			System.out.println("10������ 9�����̻� ����� 5õ���������� ����.");
			r = 10;
			
				for (a = 0; a < r; a++) {
				y += 1;
				System.out.println("");
				System.out.print("[" + y + "/" + r + "] " + y + "��° ����! : ");
				i2 = (int) (Math.random() * 2 + 1);
				if (i2 == 2) {
					i = (int) (Math.random() * 4 + 0);
					b = (int) (Math.random() * 50 + 0);
					c = (int) (Math.random() * 50 + 0);
					while (b < c)
						c = (int) (Math.random() * 50 + 0);
					if (i == 0) {
						System.out.print(b + " + " + c + " = ?");
						cal = b + c;
					} else if (i == 1) {
						System.out.println(b + " - " + c + " = ?");
						cal = b - c;
					} else if (i == 2) {
						c /= 3;
						System.out.println(b + " * " + c + " = ?");
						cal = b * c;
					} else if (i == 3) {
						System.out.println(b + " / " + c + " = ?");
						cal = b / c;
					} else {
						System.out.println(b + " % " + c + " = ?");
						cal = b % c;
					}
					System.out.print("\n����=>");				
					
					answer =scan.nextInt();				
					System.out.println("");
			
					if (answer == cal) {
						z += 1;
						System.out.println("����! (���� Ƚ�� : " + z + "/" + r + ")");
					} else
						System.out.println("����! (���� Ƚ�� : " + z + "/" + r + ") ������ " + cal + " �Դϴ�!");
				}

				if (i2 == 1) {
					b2 = (int) (Math.random() * 30 + 1);
					q = 0;
					while (q < 30) {

						if (array[q] == b2) {
							q = 0;
							b2 = (int) (Math.random() * 30 + 1);
						} else
							q++;
					}
					array[array1] = b2;
					array1++;

					if (b2 == 1) {
						System.out.println("�츮 ������ ����� �ϸ�?");
						answer2 = "���ֹ̾�";
					} else if (b2 == 2) {
						System.out.println("����� ���� ���� �� �ִ� �Ĺ���?");
						answer2 = "����";
					} else if (b2 == 3) {
						System.out.println("������� ��� ����ų �� �ִ� ���ڴ�?");
						answer2 = "�ټ�";
					} else if (b2 == 4) {
						System.out.println("���鿡�� ���� ����?");
						answer2 = "��";
					} else if (b2 == 5) {
						System.out.println("���� �Ծ�� ���ִ� ����?");
						answer2 = "����";
					} else if (b2 == 6) {
						System.out.println("������ ���� ���ߴ� �����ô� �ӱ���?");
						answer2 = "���걺";
					} else if (b2 == 7) {
						System.out.println("���Ҵ� 4�����ְ� ���ڴ� 2���� �ִ°���?");
						answer2 = "�ٸ�";
					} else if (b2 == 8) {
						System.out.println("�Ϲ����� ����Ʈ���� �ִ� ������ Ż �� ������?(���ڸ�)");
						answer2 = "9";
					} else if (b2 == 9) {
						System.out.println("���󿡼� ���� �߿� �ٴٴ�?");
						answer2 = "�䷷��";
					} else if (b2 == 10) {
						System.out.println("���ڴ� ���忡 ���ϰ� ���ڴ� ??�� ���ϴ�.");
						answer2 = "����";
					} else if (b2 == 11) {
						System.out.println("���迡�� ���� ���� ����?");
						answer2 = "ù��";
					} else if (b2 == 12) {
						System.out.println("����� �����԰� ���� ���� ��������? xxx");
						answer2 = "ö�鶧";
					} else if (b2 == 13) {
						System.out.println("���߿� ���� ���º���?");
						answer2 = "�̺�";
					} else if (b2 == 14) {
						System.out.println("������ ���� ������?");
						answer2 = "�����̾�";
					} else if (b2 == 15) {
						System.out.println("�� �ڰ� �Ȱ��� ���� ����?");
						answer2 = "�ⷯ��";
					} else if (b2 == 16) {
						System.out.println("������ ���?");
						answer2 = "���";
					} else if (b2 == 17) {
						System.out.println("�������� ����� 4���ڷ� �����ұ�?");
						answer2 = "���ξ���";
					} else if (b2 == 18) {
						System.out.println("������� �ٴϴ� ����б���?");
						answer2 = "�����";
					} else if (b2 == 19) {
						System.out.println("�Ż簡 �λ��Ҷ� �ϴ¸���?");
						answer2 = "�Ż��Ӵ�";
					} else if (b2 == 20) {
						System.out.println("�л����� �Ⱦ��ϴ� ���ڴ�? xxx");
						answer2 = "å����";
					} else if (b2 == 21) {
						System.out.println("����� ���� ����� ���� �� �ۿ����� ����?");
						answer2 = "����";
					} else if (b2 == 22) {
						System.out.println("�̼��� �ݴ���?");
						answer2 = "����";
					} else if (b2 == 23) {
						System.out.println("�Ϻ����� ���ø� ���� ���ϴ� �����?");
						answer2 = "�ٳ���";
					} else if (b2 == 24) {
						System.out.println("���󿡼� ���� ū ����?");
						answer2 = "������";
					} else if (b2 == 25) {
						System.out.println("���ڰ� ���� �����ϴ� ����?");
						answer2 = "����";
					} else if (b2 == 26) {
						System.out.println("���� �Ŵ����� Ư���� �ϴ� ���� ����?");
						answer2 = "�񸸰���";
					} else if (b2 == 27) {
						System.out.println("�Ź��� ȭ������?");
						answer2 = "�Ź߲�";
					} else if (b2 == 28) {
						System.out.println("�ϴÿ� �� ���� ���� �� ��������?(5����)");
						answer2 = "�ϴÿ����ޱ�";
					} else if (b2 == 29) {
						System.out.println("�ٳ����� ������?");
						answer2 = "�ٳ���ű";
					} else if (b2 == 30) {
						System.out.println("�ر��� �ٴϴ� ���б���?");
						answer2 = "�ù���";
					}

					System.out.print("\n����=>");
					answer1 = scan.next();
						
					System.out.println("");
					if (answer1.equals(answer2)) {
						z += 1;
						System.out.println("����! (���� Ƚ�� : " + z + "/" + r + ")");
					} else
						System.out.println("����! (���� Ƚ�� : " + z + "/" + r + ") ������ " + answer2 + " �Դϴ�!");
				}
				
				}
			System.out.println("");
			System.out.println("���\n\n���� �� : " + r + "\n���� Ƚ�� : " + z + "\nƲ�� Ƚ�� : " + (r - z) + "\n");
			
		
			for (int ii = 0; ii < 30; ii++) {
				array[ii] = 0;
			}
			++count;
		} while (count < 1);
		
		
		return z;
	}
}

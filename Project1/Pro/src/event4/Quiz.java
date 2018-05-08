package event4;

/*
 * 넌센스퀴즈와 숫자연산퀴즈를 생성하는 클래스
 * 배열과 랜덤함수이용하여 문제를 돌림
 */

import java.util.Scanner;


public class Quiz {
	

	public static int start() {

		int i = 0, i2 = 0, a = 0, b = 0, b2 = 0, c = 0, y = 0, z = 0, answer = 0, r = 0, q = 0, cal = 0;
		int array[] = new int[30];
		int array1 = 0;
		String answer1 = ""; 
		String answer2 = "";
		
		// i=수학문제갯수, b2=넌센스문제갯수, z=맞은 횟수, r=총문제수
		Scanner scan = new Scanner(System.in);
		int count = 0;
		do {
			
			z = 0;
			y = 0;
			array1 = 0;
			System.out.println("");
			System.out.println("넌센스/숫자 퀴즈입니다.");
			System.out.println("10문제중 9문제이상 맞출시 5천원할인쿠폰 지급.");
			r = 10;
			
				for (a = 0; a < r; a++) {
				y += 1;
				System.out.println("");
				System.out.print("[" + y + "/" + r + "] " + y + "번째 문제! : ");
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
					System.out.print("\n정답=>");				
					
					answer =scan.nextInt();				
					System.out.println("");
			
					if (answer == cal) {
						z += 1;
						System.out.println("정답! (맞은 횟수 : " + z + "/" + r + ")");
					} else
						System.out.println("오답! (맞은 횟수 : " + z + "/" + r + ") 정답은 " + cal + " 입니다!");
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
						System.out.println("우리 엄마를 영어로 하면?");
						answer2 = "마이애미";
					} else if (b2 == 2) {
						System.out.println("사람의 옷을 벗길 수 있는 식물은?");
						answer2 = "버섯";
					} else if (b2 == 3) {
						System.out.println("사람들을 모두 일으킬 수 있는 숫자는?");
						answer2 = "다섯";
					} else if (b2 == 4) {
						System.out.println("오백에서 백을 빼면?");
						answer2 = "오";
					} else if (b2 == 5) {
						System.out.println("남이 먹어야 맛있는 탕은?");
						answer2 = "골탕";
					} else if (b2 == 6) {
						System.out.println("수학을 가장 잘했던 조선시대 임금은?");
						answer2 = "연산군";
					} else if (b2 == 7) {
						System.out.println("젖소는 4개가있고 여자는 2개가 있는것은?");
						answer2 = "다리";
					} else if (b2 == 8) {
						System.out.println("일반적인 구명보트에는 최대 몇명까지 탈 수 있을까?(숫자만)");
						answer2 = "9";
					} else if (b2 == 9) {
						System.out.println("세상에서 가장 추운 바다는?");
						answer2 = "썰렁해";
					} else if (b2 == 10) {
						System.out.println("여자는 무드에 약하고 남자는 ??에 약하다.");
						answer2 = "누드";
					} else if (b2 == 11) {
						System.out.println("세계에서 가장 빠른 차는?");
						answer2 = "첫차";
					} else if (b2 == 12) {
						System.out.println("사람의 몸무게가 가장 많이 나갈때는? xxx");
						answer2 = "철들때";
					} else if (b2 == 13) {
						System.out.println("별중에 가장 슬픈별은?");
						answer2 = "이별";
					} else if (b2 == 14) {
						System.out.println("엄마가 길을 잃으면?");
						answer2 = "맘마미아";
					} else if (b2 == 15) {
						System.out.println("앞 뒤가 똑같이 생긴 새는?");
						answer2 = "기러기";
					} else if (b2 == 16) {
						System.out.println("오리가 얼먼?");
						answer2 = "언덕";
					} else if (b2 == 17) {
						System.out.println("벌레먹은 사과를 4글자로 뭐라할까?");
						answer2 = "파인애플";
					} else if (b2 == 18) {
						System.out.println("사오정이 다니는 고등학교는?");
						answer2 = "뭐라고";
					} else if (b2 == 19) {
						System.out.println("신사가 인사할때 하는말은?");
						answer2 = "신사임당";
					} else if (b2 == 20) {
						System.out.println("학생들이 싫어하는 피자는? xxx");
						answer2 = "책피자";
					} else if (b2 == 21) {
						System.out.println("편식이 심한 사람도 먹을 수 밖에없는 것은?");
						answer2 = "나이";
					} else if (b2 == 22) {
						System.out.println("미소의 반댓말은?");
						answer2 = "당기소";
					} else if (b2 == 23) {
						System.out.println("일본에서 낚시를 제일 잘하는 사람은?");
						answer2 = "다나까";
					} else if (b2 == 24) {
						System.out.println("세상에서 가장 큰 컵은?");
						answer2 = "월드컵";
					} else if (b2 == 25) {
						System.out.println("남자가 가장 좋아하는 집은?");
						answer2 = "계집";
					} else if (b2 == 26) {
						System.out.println("비의 매니져가 특별히 하는 일은 무엇?");
						answer2 = "비만관리";
					} else if (b2 == 27) {
						System.out.println("신발이 화가나면?");
						answer2 = "신발끈";
					} else if (b2 == 28) {
						System.out.println("하늘에 별 따기 보다 더 어려운것은?(5글자)");
						answer2 = "하늘에별달기";
					} else if (b2 == 29) {
						System.out.println("바나나가 웃으면?");
						answer2 = "바나나킥";
					} else if (b2 == 30) {
						System.out.println("팽귄이 다니는 중학교는?");
						answer2 = "냉방중";
					}

					System.out.print("\n정답=>");
					answer1 = scan.next();
						
					System.out.println("");
					if (answer1.equals(answer2)) {
						z += 1;
						System.out.println("정답! (맞은 횟수 : " + z + "/" + r + ")");
					} else
						System.out.println("오답! (맞은 횟수 : " + z + "/" + r + ") 정답은 " + answer2 + " 입니다!");
				}
				
				}
			System.out.println("");
			System.out.println("결과\n\n문제 수 : " + r + "\n맞은 횟수 : " + z + "\n틀린 횟수 : " + (r - z) + "\n");
			
		
			for (int ii = 0; ii < 30; ii++) {
				array[ii] = 0;
			}
			++count;
		} while (count < 1);
		
		
		return z;
	}
}

package food.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import food.service.FoodDAO;
import food.vo.*;
import event3.GameMain;
import event4.Quiz;

public class FoodUI {
	private FoodDAO dao;
	private Scanner sc;

	public FoodUI() {
		dao = new FoodDAO();
		sc = new Scanner(System.in);
	}

	public void startUI() {
		while (true) {
			System.out.println("┌──────────────────────────────┐");
			System.out.println("         오늘 뭐 먹지 ?	       ");
			System.out.println("└──────────────────────────────┘");
			System.out.println("┌──────────────────────────────┐");
			System.out.println(" 1. 회원	               ");
			System.out.println(" 2. 비회원		       ");
			System.out.println(" 3. 운영자	               ");
			System.out.println(" 4. 회원가입	               ");
			System.out.println(" 0. 종료	               ");
			System.out.println("└──────────────────────────────┘");
			System.out.print("메뉴번호를 선택하세요=> ");

			try {
				String num = sc.nextLine();
				int menuNum = Integer.parseInt(num);

				switch (menuNum) {
				case 1:// 회원
					try {
						Member m = login();

						if (m != null) {
							System.out.println("로그인 되었습니다");
							System.out.println("어서오세요 마일리지 100p가 지급되었습니다");
							Map<String, Object> map = new HashMap<String, Object>();
							String id = m.getId();
							int mileage = m.getMileage() + 100;
							map.put("id", id);
							map.put("mileage", mileage);
							dao.changeMile(map);
							this.memberUI();
						} else {
							System.out.println("존재하지않는 회원 또는 아이디나 비밀번호가 일치하지않습니다.");
						}

					} catch (Exception e) {
					}

					break;
				case 2: // 비회원

					this.nonMemberUI();
					break;
				case 3:// 운영자
					Member ad = login();
					try {
						if (ad.getId().equals("master")) {
							System.out.println("로그인되었습니다");
							this.adminUI();
						} else {
							System.out.println("운영자가 아닙니다");
						}
					} catch (Exception e) {
						System.out.println("아이디나 비밀번호가 틀립니다");
					}

					break;
				case 4: // 회원가입

					try {
						Member p = insertid();
						boolean insertid = dao.insertMember(p);
						if (insertid) {
							Record r = new Record(p.getId());
							dao.insertRecord(r);

							System.out.println("아이디가 생성되었습니다");

						}

					} catch (Exception e) {
						System.out.println("아이디 만들기 실패하였습니다");
					}

					break;
				case 0: // 프로그램 종료
					System.out.println("프로그램을 종료하겠습니다.");
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println("숫자를 입력해주세요");

			}
		}
	}

	public void memberUI() {

		while (true) {
			System.out.println("┌──────────────────────────────┐");
			System.out.println("	   회       원	       ");
			System.out.println("└──────────────────────────────┘");
			System.out.println("┌──────────────────────────────┐");
			System.out.println(" 1. 음식점 검색	           ");
			System.out.println(" 2. 이벤트	               ");
			System.out.println(" 3. 회원탈퇴	               ");
			System.out.println(" 0. 로그 아웃(종료)	       ");
			System.out.println("└──────────────────────────────┘");
			System.out.print("메뉴 번호를 선택하세요 =>");
			try {

				String menunum = sc.nextLine();
				int menuNum = Integer.parseInt(menunum);

				switch (menuNum) {
				case 1: // 음식점 검색
					this.findRes();
					break;
				case 2:// 이벤트
					this.event();
					break;
				case 3:
					System.out.println("다시 로그인 해주세요");
					Member dm = login();
					if (dm != null) {
						boolean resultId = dao.deleteMember(dm.getId());
						if (resultId) {
							System.out.println("아이디가 정상적으로 삭제되었습니다");
						} else {
							System.out.println("아이디 삭제가 실패하였습니다");
						}
					} else {
						System.out.println("아이디나 비밀번호가 틀립니다");
					}

				case 0: // 로그아웃(종료)
					System.out.println("로그아웃 성공! 프로그램을 종료합니다.");
					System.exit(0);
				}

			} catch (Exception e) {
				System.out.println("숫자를 입력해주세요");
			}
		}
	}

	private void findRes() {
		while (true) {
			System.out.println("┌──────────────────────────────────┐");
			System.out.println("        음식점 검색(회원전용)       ");
			System.out.println("└──────────────────────────────────┘");
			System.out.println("┌──────────────────────────────────┐");
			System.out.println(" 1. 종류별(한식,중식,일식,양식,기타)    ");
			System.out.println(" 2. 가격대별                ");
			System.out.println(" 3. 음식점 검색(댓글달기 및 평점)    ");
			System.out.println(" 0. 상위 메뉴                ");
			System.out.println("└──────────────────────────────────┘");
			System.out.print("메뉴 번호를 선택하세요 =>");
			try {

				String menunum = sc.nextLine();
				int menuNum = Integer.parseInt(menunum);

				switch (menuNum) {
				case 1: // 음식점 종류별검색
					searchType();
					break;
				case 2:// 가격대별 검색
					searchPrice();
					break;
				case 3:
					System.out.print("음식점 이름: ");
					String searchName = sc.nextLine();
					Restaurant searn = dao.searchRestaurant(searchName);
					if (searn != null) {
						dao.addHits(searchName);
						System.out.println(searn);
						getCommentary(searn);

					} else {
						System.out.println("찾으신 음식점이 없습니다");
					}
					break;
				case 0: // 상위메뉴
					return;
				}
			} catch (Exception e) {
				System.out.println("숫자를 입력해주세요");
			}
		}
	}

	private void event() {

		int menuNum;

		while (true) {
			System.out.println("┌──────────────────────────────┐");
			System.out.println("       이벤트 게임(회원전용)  ");
			System.out.println("└──────────────────────────────┘");
			System.out.println("┌──────────────────────────────┐");
			System.out.println(" 1. 가위바위보!(1번 20p)   	   ");
			System.out.println(" 2. 숫자 업 다운(1번 50p)      ");
			System.out.println(" 3. 초성 맞추기(1번 50p)   	   ");
			System.out.println(" 4. 넌센스/숫자 퀴즈(1번 50p)  ");
			System.out.println(" 5. 쿠폰 확인(보유마일리지) 	   ");
			System.out.println(" 0. 상위 메뉴       	           ");
			System.out.println("└──────────────────────────────┘");
			System.out.print("메뉴 번호를 선택하세요 =>");

			try {
				String menunum = sc.nextLine();
				menuNum = Integer.parseInt(menunum);

				switch (menuNum) {
				case 1: // 가위바위보1
					event1();
					break;
				case 2:// 숫자맞추기
					event2();
					break;
				case 3:// 초성맞추기
					event3();
					break;
				case 4:// 상식퀴즈
					event4();
					break;
				case 5:
					getResult();
					break;
				case 0: // 상위메뉴
					memberUI();
				default:
					System.out.println("다시입력해주세요.");
				}
			} catch (Exception e) {
				System.out.println("다시입력해주세요");
			}
		}
	}
	/*
	 * 배열과 랜덤함수 사용
	 */
	private void event1() {
		int user, com;
		Random rd = new Random();
		String[] Game = new String[] { "고민중", "가위", "바위", "보" }; //
		Member m = null;

		try {

			System.out.println("다시 로그인 해주세요.");
			m = login();
			int l = m.getMileage();

			if (m != null) {
				System.out.println("로그인 되었습니다");

				while (l >= 20) {
					System.out.println("보유 마일리지: " + l + "p");

					System.out.println("가위 바위 보 게임입니다!(1판당 20p 소모) 다음 메뉴중 선택해주세요");
					System.out.println("이길시 30p 획득, 비길시 본전입니다.");
					System.out.println("1.가위  2.바위  3.보  4.끝내기");
					System.out.print("번호를 선택해주세요: ");
					user = sc.nextInt();
					com = rd.nextInt(3);

					if (user > 4) {
						System.out.println("다시 선택해주세요");
						continue;
					} else if (user == 4) {
						System.out.println("이용해주셔서 감사합니다.");

						result(m, l);
					}
					if (user == com) {
						System.out.println("컴퓨터가 " + Game[com] + "를 냈습니다.");
						System.out.println("비겼습니다");
						l = l + 20;

					} else if (user == 0 ^ com == 0) { //배열 1번쨰 오류처리용.
						System.out.println("컴퓨터가 뭘 낼지 망설이다가 아무것도 내지 못했습니다.");
						System.out.println("당신의 승리입니다. 축하합니다");
						l = l + 30;

					} else if (user == 2 && com == 3 || com == 0) {
						System.out.println("컴퓨터가 " + Game[com] + "를 냈습니다.");
						System.out.println("당신이 졌습니다.");

					} else if (user == 1 && com == 3 || com == 0) {
						System.out.println("컴퓨터가 " + Game[com] + "를 냈습니다.");
						System.out.println("당신의 승리입니다. 축하합니다.");
						l = l + 30;

					} else if (user > com) {
						System.out.println("컴퓨터가 " + Game[com] + "를 냈습니다.");
						System.out.println("당신의 승리입니다. 축하합니다.");
						l = l + 30;

					} else {
						System.out.println("컴퓨터가 " + Game[com] + "를 냈습니다.");
						System.out.println("당신이 졌습니다.");

					}
					l = l - 20;
				}

				String id = m.getId();

				int mileage = l;
				Map<String, Object> map = new HashMap<>();
				map.put("id", id);
				map.put("mileage", mileage);
				dao.changeMile(map);

				System.out.println("마일리지가 부족합니다.");
				sc.nextLine();
				event();

			}

		} catch (Exception e) {

		}
	}

	public void result(Member m, int l) {
		String id = m.getId();

		int mileage = l;
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("mileage", mileage);
		dao.changeMile(map);
		sc.nextLine();
		event();

	}

	private void event2() {
		int answer = (int) (Math.random() * 1000 + 1), guess, t = 0;
		Member m = null;

		int l = 0;
		try {

			System.out.println("다시 로그인 해주세요.");
			m = login();
			l = m.getMileage();

			if (m != null) {
				System.out.println("로그인 되었습니다");

				if (l >= 50) {
					System.out.println("보유 마일리지: " + l);
					System.out.println("업 엔 다운 숫자 추측 게임입니다.");
					System.out.println("10번 시도만에 정답을 맞출시 3천원 할인쿠폰 지급.");
					do {

						System.out.print("정답을 추측해 보세요 : ");
						guess = sc.nextInt();
						t++;
						if (guess < answer) {
							System.out.println("up");

						}
						if (guess > answer)
							System.out.println("down");

					} while (guess != answer);

					System.out.println("정답입니다. 시도횟수=" + t);
					if (t <= 10) {

						dao.gainGame2(m.getId());
						System.out.println("3천원 할인쿠폰에 당첨되었습니다");
					}

					System.out.println("이용해주셔서 감사합니다");
					String id = m.getId();
					l = l - 50;
					int mileage = l;
					Map<String, Object> map = new HashMap<>();
					map.put("id", id);
					map.put("mileage", mileage);
					dao.changeMile(map);
					sc.nextLine();

					event();
				} else {
					System.out.println("마일리지가 부족합니다");
				}

			}
		} catch (Exception e) {

		}
	}

	private void event3() {
		GameMain g = new GameMain();

		System.out.println("다시 로그인 해주세요.");

		Member m = login();

		if (m != null) {
			System.out.println("로그인 되었습니다");
			String id = m.getId();
			int l = m.getMileage();

			if (l >= 50) {
				System.out.println("보유 마일리지: " + l);
				System.out.println("초성맞추기 게임입니다.");
			     System.out.println("5문제 전부 맞출시 2천원할인쿠폰 지급.");
				int score = g.startmain();
				l = l - 50;
				Map<String, Object> map = new HashMap<>();

				int mileage = l;
				map.put("id", id);
				map.put("mileage", mileage);
				dao.changeMile(map);
				if (score == 100) {
					
					dao.gainGame1(m.getId());
					System.out.println("2천원 할인 쿠폰에 당첨되었습니다.");
					System.out.println("이용해주셔서 감사합니다.");
				} else {
					System.out.println("이용해주셔서 감사합니다.");
				}
				
				event();
			} else {
				System.out.println("마일리지가 부족합니다.");
			}
		}
	}

	private void event4() {
		Quiz q = new Quiz();

		System.out.println("다시 로그인 해주세요.");

		Member m = login();

		if (m != null) {
			System.out.println("로그인 되었습니다");
			String id = m.getId();
			int l = m.getMileage();

			if (l >= 50) {
				System.out.println("보유 마일리지: " + l);
				int t = q.start();
				l = l - 50;
				Map<String, Object> map = new HashMap<>();

				int mileage = l;
				map.put("id", id);
				map.put("mileage", mileage);
				dao.changeMile(map);
				
				if (t >= 9) {
					
					dao.gainGame3(m.getId());
					System.out.println("5천원할인쿠폰에 당첨되셨습니다.");
				
				}
				System.out.println("이용해주셔서 감사합니다.");
			
			} else {
				System.out.println("마일리지가 부족합니다.");
			}
		}
	}

	public void getResult() {
		System.out.println("다시 로그인 해주세요.");

		Member m = login();
		if (m != null) {
			System.out.println("로그인 되었습니다");
			System.out.println("보유마일리지: " + m.getMileage());
			System.out.println(dao.allRecord(m.getId()));

		}

	}

	public void nonMemberUI() {
		while (true) {
			System.out.println("┌──────────────────────────────┐");
			System.out.println("           비  회  원           ");
			System.out.println("└──────────────────────────────┘");
			System.out.println("┌──────────────────────────────┐");
			System.out.println(" 1. 음식점 검색                 ");
			System.out.println(" 0. 상위 메뉴                  ");
			System.out.println("└──────────────────────────────┘");
			System.out.print("메뉴 번호를 선택하세요 =>");
			String menunum = sc.nextLine();
			int menuNum = Integer.parseInt(menunum);
			switch (menuNum) {
			case 1: // 비회원 음식점검색
				this.nonMemberFindRes();
				break;
			case 0: // 상위메뉴
				return;
			}
		}
	}

	private void nonMemberFindRes() {
		while (true) {
			System.out.println("┌─────────────────────────────────┐");
			System.out.println("         음식점 검색(비회원)         ");
			System.out.println("└─────────────────────────────────┘");
			System.out.println("┌─────────────────────────────────┐");
			System.out.println(" 1. 종류별(한식,중식,일식,양식,기타)    ");
			System.out.println(" 2. 가격대별                ");
			System.out.println(" 0. 상위 메뉴                ");
			System.out.println("└─────────────────────────────────┘");
			System.out.print("메뉴 번호를 선택하세요 =>");
			String menunum = sc.nextLine();
			int menuNum = Integer.parseInt(menunum);

			switch (menuNum) {
			case 1: // 음식점 검색
				searchType();
				break;
			case 2:// 가격대별
				searchPrice();
				break;
			case 0: // 상위메뉴
				return;
			}
		}
	}
	

	private void adminUI() {

		while (true) {
			System.out.println("┌──────────────────────────────┐");
			System.out.println("            운  영  자      	   ");
			System.out.println("└──────────────────────────────┘");
			System.out.println("┌──────────────────────────────┐");
			System.out.println(" 1. 음식점 관리                 ");
			System.out.println(" 2. 회원 관리                   ");
			System.out.println(" 0. 종료                        ");
			System.out.println("└──────────────────────────────┘");
			System.out.print("메뉴 번호를 선택하세요 =>");
			String menunum = sc.nextLine();
			int menuNum = Integer.parseInt(menunum);
			switch (menuNum) {
			case 1: // 음식점 관리
				manageRestaurant();
				break;
			case 2:// 회원 관리
				manageMember();
				break;
			case 0: // 종료
				System.out.println("프로그램을 종료하겠습니다");
				System.exit(0);
			}

		}
	}

	private void manageRestaurant() {
		while (true) {
			System.out.println("┌──────────────────────────────┐");
			System.out.println("           음식점 관리              ");
			System.out.println("└──────────────────────────────┘");
			System.out.println("┌──────────────────────────────┐");
			System.out.println(" 1. 음식점 등록                ");
			System.out.println(" 2. 음식점 삭제                ");
			System.out.println(" 0. 상위메뉴                   ");
			System.out.println("└──────────────────────────────┘");
			System.out.print("메뉴 번호를 선택하세요 =>");
			String menunum = sc.nextLine();
			int menuNum = Integer.parseInt(menunum);
			switch (menuNum) {
			case 1: // 음식점 등록
				Restaurant r = insertRestaurant();
				boolean insertRestaurant = dao.insertRestaurant(r);
				if (insertRestaurant) {
					System.out.println("음식점이 등록되었습니다");

				} else {
					System.out.println("음식점 등록이 실패하였습니다");

				}
				break;
			case 2:// 음식점 삭제
				deleteRestaurant();
				break;
			case 0: // 상위메뉴
				return;
			}

		}
	}

	public Restaurant insertRestaurant() {
		Restaurant r = null;

		System.out.println("== 음식점 등록 ==");
		System.out.print("음식점 이름 : ");
		String name = sc.nextLine();
		System.out.print("종류(한식,중식,일식,양식,기타):");
		String type = sc.nextLine();

		switch (type) {
		default:
			System.out.print("종류(한식,중식,일식,양식,기타):");
			type = sc.nextLine();
		case "한식":
		case "일식":
		case "중식":
		case "양식":
		case "기타":

			break;

		}
		System.out.print("가격 입력(숫자만): ");
		String pr = sc.nextLine();
		int price = Integer.parseInt(pr);
		System.out.print("음식점 전화번호: ");
		String phonenum = sc.nextLine();
		System.out.print("걸리는 시간(거리): ");
		String dtime = sc.nextLine();
		r = new Restaurant(name, type, price, phonenum, dtime);

		return r;
	}

	private void deleteRestaurant() {
		System.out.print("삭제할 음식점 이름: ");
		String deleteName = sc.nextLine();
		boolean resultR = dao.deleteRestaurant(deleteName);
		if (resultR) {
			System.out.println("음식점이 정상적으로 삭제되었습니다");
		} else {
			System.out.println("음식점 삭제를 실패하였습니다");
		}

	}

	private void manageMember() {
		while (true) {
			System.out.println("┌──────────────────────────────┐");
			System.out.println("            회 원 관 리              ");
			System.out.println("└──────────────────────────────┘");
			System.out.println("┌──────────────────────────────┐");
			System.out.println(" 1. 회원 전체조회                ");
			System.out.println(" 2. 회원 삭제                      ");
			System.out.println(" 3. 쿠폰 발송                    ");
			System.out.println(" 0. 상위메뉴                   ");
			System.out.println("└──────────────────────────────┘");
			System.out.print("메뉴 번호를 선택하세요 =>");
			String menunum = sc.nextLine();
			int menuNum = Integer.parseInt(menunum);
			switch (menuNum) {
			case 1: // 회원 전체조회
				allMemberList();
				break;
			case 2:// 회원 삭제
				deleteMember();
				break;
			case 3://쿠폰보내기
				couponSend();
				break;
			case 0: // 상위메뉴
				return;
			}
		}
	}
	private void couponSend() {
	while(true) {	
	memberCoupon();
	
	List<Record> list =dao.couponRecord();
	Map<String, Object> map1 = new HashMap<>();
	 Map<String, Object> map2 = new HashMap<>();
	 Map<String, Object> map3 = new HashMap<>();
	
		
	 
		// TODO: handle exception
	System.out.print("쿠폰 보낼 아이디:");
	String id =sc.nextLine();
	boolean name =false;
	int gg1=0; int gg2=0; int gg3=0;
	
	for (Record record : list) {
		if(record.getId().equals(id)) {
			name=true;
			gg1=record.getGame1();
			gg2=record.getGame2();
			gg3=record.getGame3();
					
		}
	
	}
	
	
	if(name) {System.out.print("보낼 쿠폰(2000원(1),3000원(2),5000원(3) : ");
	int num;
	try{String nu=sc.nextLine();
		 num =Integer.parseInt(nu);
	}catch (Exception e) {
		System.out.println("잘못입력하셨습니다.");
		System.out.print("보낼 쿠폰(2000원(1),3000원(2),5000원(3) : ");
		String nu=sc.nextLine();
		 num =Integer.parseInt(nu);
	}
	
		 	
	

	if(num==1){
		if(gg1<1) {
			System.out.println("보낼쿠폰이 없습니다.");
		break;
		}else {
		System.out.println("현재 쿠폰수: "+gg1);
		System.out.print("보낼 쿠폰 수: ");
		int g1 =sc.nextInt();
		int game1 =gg1-g1;
		map1.put("id", id);
		map1.put("game1", game1);
		dao.game1Send(map1);
		System.out.println("쿠폰이 정상적으로 보내졌습니다");
		sc.nextLine();
		break;}
	}else if(num==2) {
		if(gg2<1) {
			System.out.println("보낼쿠폰이 없습니다.");
		break;
		}else {
		
		
		System.out.println("현재 쿠폰수: "+gg2);
		System.out.print("보낼 쿠폰 수: ");
		int g2 =sc.nextInt();
		int game2 =gg2- g2;
		map2.put("id", id);
		map2.put("game2", game2);
		dao.game2Send(map2);
		System.out.println("쿠폰이 정상적으로 보내졌습니다");
		sc.nextLine();
		break;}
	}else if(num==3) {
		if(gg3<1) {
			System.out.println("보낼쿠폰이 없습니다.");
		break;
		}else {
		System.out.println("현재 쿠폰수: "+gg3);
		System.out.print("보낼 쿠폰 수: ");
		int g3 =sc.nextInt();
		int game3 =gg3- g3;
		map3.put("id", id);
		map3.put("game3", game3);
		dao.game3Send(map3);		
		System.out.println("쿠폰이 정상적으로 보내졌습니다");
		sc.nextLine();
		break;
		}
	
	}else {System.out.println("잘못입력하셨습니다");}	
	
	}
	else {System.out.println("아이디가 잘못되었습니다");
	}
		
	
	
	
	}
	
	}
		public void memberCoupon() {
		
			System.out.println("회원 쿠폰 정보");
		
			List<Record> list =dao.couponRecord();
			for (Record record : list) {
				System.out.println(record);
			}
							
			}
	
	
	
	
	
	private void allMemberList() {
		List<Member> l = dao.getMemberList();
		for (Member m : l) {
			System.out.println(m);
		}
	}

	private void deleteMember() {
		System.out.print("삭제할 아이디: ");
		String deleteId = sc.nextLine();
		boolean resultId = dao.deleteMember(deleteId);
		if (resultId) {
			System.out.println("아이디가 정상적으로 삭제되었습니다");
		} else {
			System.out.println("아이디 삭제가 실패하였습니다");
		}

	}

	// 아이디 만들기
	public Member insertid() {
		System.out.println("==  회원가입  ==");
		System.out.print("아이디: ");
		String id = sc.nextLine();
		System.out.print("비밀번호: ");
		String pw = sc.nextLine();
		System.out.print("비번확인: ");
		String repw = sc.nextLine();
		Member m = null;
		if (pw.equals(repw)) {
			m = new Member(id, pw);
		} else {
			System.out.println("비밀번호가  일치하지않습니다.");
		}
		return m;
	}

	// 로그인
	public Member login() {
		Member m = null;
		System.out.println("=====로그인=====");
		System.out.print("아이디: ");
		String id = sc.nextLine();
		System.out.print("비밀번호: ");
		String pw = sc.nextLine();

		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		m = dao.searchMember(map);

		return m;
	}

	// 음식점 검색(종류별)
	public void searchType() {

		System.out.println("==종류별 검색==");
		System.out.print("종류 입력=>");
		String type = sc.nextLine();
		List<Restaurant> l = dao.allRestaurant();

		for (Restaurant r : l) {
			if (type.equals(r.getType())) {
				System.out.println(r);
			}
		}

	}

	// 음식점 검색(가격대별)
	public void searchPrice() {

		System.out.println("==가격대별 검색==");
		System.out.print("최소가격 입력=>");
		String small = sc.nextLine();
		int sp = Integer.parseInt(small);
		System.out.print("최대가격 입력=>");
		String large = sc.nextLine();
		int lp = Integer.parseInt(large);
		List<Restaurant> l = dao.allRestaurant();
		for (Restaurant r : l) {
			if (sp <= r.getPrice() && r.getPrice() <= lp) {
				System.out.println(r);
			}

		}
	}

	// 리플 메뉴
	public void getCommentary(Restaurant r) {
		List<Commentary> cList = dao.getReplyList(r.getName());
		if (cList != null) {
			for (Commentary c : cList) {
				System.out.println(c);
			}
		}
		insertCommentary(r);
	}

	// 리플입력
	public void insertCommentary(Restaurant r) {
		while (true) {

			System.out.println("1. 댓글 달기");
			System.out.println("2. 평점매기기");
			System.out.println("3. 상위메뉴");
			System.out.print("메뉴선택=> ");
			String num = sc.nextLine();
			int mNum = Integer.parseInt(num);

			switch (mNum) {
			case 1:
				Member m = login();
				if (m != null) {

					System.out.print("content: ");
					String content = sc.nextLine();
					Commentary c = new Commentary(m.getId(), r.getName(), content);
					boolean result = dao.insertReply(c);
					if (result) {
						System.out.println("댓글 등록 성공");

						String id = m.getId();

						int mileage = m.getMileage() + 100;
						Map<String, Object> map = new HashMap<>();
						map.put("id", id);
						map.put("mileage", mileage);
						dao.changeMile(map);
						
					} else {
						System.out.println("댓글 등록 실패");
					}

				} else {
					System.out.println("아이디나 비밀번호가 틀립니다");

				}

				break;
			case 2:// 평점
				double ra = r.getRate();
				double rate = 0;
				System.out.println("0~5사이 숫자를 입력해주세요=>");
				String nu = sc.nextLine();
				int number = Integer.parseInt(nu);
				if (0 <= number && number <= 5) {
					dao.rperson(r.getName());
					int count = r.getrperson() + 1;
					if (count == 0) {
						rate = number;
					} else if (count != 0) {
						if (number == 0) {
							rate = ra / count;

						} else if (number != 0) {
							rate = (double) (ra * (count - 1) + number) / count;
						}
					}

					String name = r.getName();

					Map<String, Object> map = new HashMap<>();
					map.put("name", name);
					map.put("rate", rate);
					dao.avgRate(map);
					break;
				} else {
					System.out.println("다시입력해주세요");
					System.out.print("0~5사이 숫자를 입력해주세요=>");
					nu = sc.nextLine();

					number = Integer.parseInt(nu);
				}

			case 3:
				return;

			}
		}
	}
}
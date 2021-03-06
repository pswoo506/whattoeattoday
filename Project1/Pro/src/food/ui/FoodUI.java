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
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("         螃棺 凳 詳雖 ?	       ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println(" 1. �蛾�	               ");
			System.out.println(" 2. 綠�蛾�		       ");
			System.out.println(" 3. 遴艙濠	               ");
			System.out.println(" 4. �蛾灠㊣�	               ");
			System.out.println(" 0. 謙猿	               ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景廓�ㄧ� 摹鷗ж撮蹂=> ");

			try {
				String num = sc.nextLine();
				int menuNum = Integer.parseInt(num);

				switch (menuNum) {
				case 1:// �蛾�
					try {
						Member m = login();

						if (m != null) {
							System.out.println("煎斜檣 腎歷蝗棲棻");
							System.out.println("橫憮螃撮蹂 葆橾葬雖 100p陛 雖晝腎歷蝗棲棻");
							Map<String, Object> map = new HashMap<String, Object>();
							String id = m.getId();
							int mileage = m.getMileage() + 100;
							map.put("id", id);
							map.put("mileage", mileage);
							dao.changeMile(map);
							this.memberUI();
						} else {
							System.out.println("襄營ж雖彊朝 �蛾� 傳朝 嬴檜蛤釭 綠塵廓�ㄟ� 橾纂ж雖彊蝗棲棻.");
						}

					} catch (Exception e) {
					}

					break;
				case 2: // 綠�蛾�

					this.nonMemberUI();
					break;
				case 3:// 遴艙濠
					Member ad = login();
					try {
						if (ad.getId().equals("master")) {
							System.out.println("煎斜檣腎歷蝗棲棻");
							this.adminUI();
						} else {
							System.out.println("遴艙濠陛 嬴椎棲棻");
						}
					} catch (Exception e) {
						System.out.println("嬴檜蛤釭 綠塵廓�ㄟ� ぎ董棲棻");
					}

					break;
				case 4: // �蛾灠㊣�

					try {
						Member p = insertid();
						boolean insertid = dao.insertMember(p);
						if (insertid) {
							Record r = new Record(p.getId());
							dao.insertRecord(r);

							System.out.println("嬴檜蛤陛 儅撩腎歷蝗棲棻");

						}

					} catch (Exception e) {
						System.out.println("嬴檜蛤 虜菟晦 褒ぬж艘蝗棲棻");
					}

					break;
				case 0: // Щ煎斜極 謙猿
					System.out.println("Щ煎斜極擊 謙猿ж啊蝗棲棻.");
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println("璋濠蒂 殮溘п輿撮蹂");

			}
		}
	}

	public void memberUI() {

		while (true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("	   ��       錳	       ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println(" 1. 擠衝薄 匐儀	           ");
			System.out.println(" 2. 檜漸お	               ");
			System.out.println(" 3. �蛾躠酷�	               ");
			System.out.println(" 0. 煎斜 嬴醒(謙猿)	       ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景 廓�ㄧ� 摹鷗ж撮蹂 =>");
			try {

				String menunum = sc.nextLine();
				int menuNum = Integer.parseInt(menunum);

				switch (menuNum) {
				case 1: // 擠衝薄 匐儀
					this.findRes();
					break;
				case 2:// 檜漸お
					this.event();
					break;
				case 3:
					System.out.println("棻衛 煎斜檣 п輿撮蹂");
					Member dm = login();
					if (dm != null) {
						boolean resultId = dao.deleteMember(dm.getId());
						if (resultId) {
							System.out.println("嬴檜蛤陛 薑鼻瞳戲煎 餉薯腎歷蝗棲棻");
						} else {
							System.out.println("嬴檜蛤 餉薯陛 褒ぬж艘蝗棲棻");
						}
					} else {
						System.out.println("嬴檜蛤釭 綠塵廓�ㄟ� ぎ董棲棻");
					}

				case 0: // 煎斜嬴醒(謙猿)
					System.out.println("煎斜嬴醒 撩奢! Щ煎斜極擊 謙猿м棲棻.");
					System.exit(0);
				}

			} catch (Exception e) {
				System.out.println("璋濠蒂 殮溘п輿撮蹂");
			}
		}
	}

	private void findRes() {
		while (true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("        擠衝薄 匐儀(�蛾衋�辨)       ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println(" 1. 謙盟滌(и衝,醞衝,橾衝,曄衝,晦顫)    ");
			System.out.println(" 2. 陛問渠滌                ");
			System.out.println(" 3. 擠衝薄 匐儀(渤旋殖晦 塽 ゎ薄)    ");
			System.out.println(" 0. 鼻嬪 詭景                ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景 廓�ㄧ� 摹鷗ж撮蹂 =>");
			try {

				String menunum = sc.nextLine();
				int menuNum = Integer.parseInt(menunum);

				switch (menuNum) {
				case 1: // 擠衝薄 謙盟滌匐儀
					searchType();
					break;
				case 2:// 陛問渠滌 匐儀
					searchPrice();
					break;
				case 3:
					System.out.print("擠衝薄 檜葷: ");
					String searchName = sc.nextLine();
					Restaurant searn = dao.searchRestaurant(searchName);
					if (searn != null) {
						dao.addHits(searchName);
						System.out.println(searn);
						getCommentary(searn);

					} else {
						System.out.println("瓊戲褐 擠衝薄檜 橈蝗棲棻");
					}
					break;
				case 0: // 鼻嬪詭景
					return;
				}
			} catch (Exception e) {
				System.out.println("璋濠蒂 殮溘п輿撮蹂");
			}
		}
	}

	private void event() {

		int menuNum;

		while (true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("       檜漸お 啪歜(�蛾衋�辨)  ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println(" 1. 陛嬪夥嬪爾!(1廓 20p)   	   ");
			System.out.println(" 2. 璋濠 機 棻遴(1廓 50p)      ");
			System.out.println(" 3. 蟾撩 蜃蹺晦(1廓 50p)   	   ");
			System.out.println(" 4. 凱撫蝶/璋濠 襪鍔(1廓 50p)  ");
			System.out.println(" 5. 瓔ア �挫�(爾嶸葆橾葬雖) 	   ");
			System.out.println(" 0. 鼻嬪 詭景       	           ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景 廓�ㄧ� 摹鷗ж撮蹂 =>");

			try {
				String menunum = sc.nextLine();
				menuNum = Integer.parseInt(menunum);

				switch (menuNum) {
				case 1: // 陛嬪夥嬪爾1
					event1();
					break;
				case 2:// 璋濠蜃蹺晦
					event2();
					break;
				case 3:// 蟾撩蜃蹺晦
					event3();
					break;
				case 4:// 鼻衝襪鍔
					event4();
					break;
				case 5:
					getResult();
					break;
				case 0: // 鼻嬪詭景
					memberUI();
				default:
					System.out.println("棻衛殮溘п輿撮蹂.");
				}
			} catch (Exception e) {
				System.out.println("棻衛殮溘п輿撮蹂");
			}
		}
	}
	/*
	 * 寡翮婁 楠渾л熱 餌辨
	 */
	private void event1() {
		int user, com;
		Random rd = new Random();
		String[] Game = new String[] { "堅團醞", "陛嬪", "夥嬪", "爾" }; //
		Member m = null;

		try {

			System.out.println("棻衛 煎斜檣 п輿撮蹂.");
			m = login();
			int l = m.getMileage();

			if (m != null) {
				System.out.println("煎斜檣 腎歷蝗棲棻");

				while (l >= 20) {
					System.out.println("爾嶸 葆橾葬雖: " + l + "p");

					System.out.println("陛嬪 夥嬪 爾 啪歜殮棲棻!(1っ渡 20p 模賅) 棻擠 詭景醞 摹鷗п輿撮蹂");
					System.out.println("檜望衛 30p �僱�, 綠望衛 獄瞪殮棲棻.");
					System.out.println("1.陛嬪  2.夥嬪  3.爾  4.部頂晦");
					System.out.print("廓�ㄧ� 摹鷗п輿撮蹂: ");
					user = sc.nextInt();
					com = rd.nextInt(3);

					if (user > 4) {
						System.out.println("棻衛 摹鷗п輿撮蹂");
						continue;
					} else if (user == 4) {
						System.out.println("檜辨п輿敷憮 馬餌м棲棻.");

						result(m, l);
					}
					if (user == com) {
						System.out.println("闡У攪陛 " + Game[com] + "蒂 麻蝗棲棻.");
						System.out.println("綠啣蝗棲棻");
						l = l + 20;

					} else if (user == 0 ^ com == 0) { //寡翮 1廓�� 螃盟籀葬辨.
						System.out.println("闡У攪陛 劂 鳥雖 蜂撲檜棻陛 嬴鼠匙紫 頂雖 跤ц蝗棲棻.");
						System.out.println("渡褐曖 蝓葬殮棲棻. 蹴жм棲棻");
						l = l + 30;

					} else if (user == 2 && com == 3 || com == 0) {
						System.out.println("闡У攪陛 " + Game[com] + "蒂 麻蝗棲棻.");
						System.out.println("渡褐檜 螺蝗棲棻.");

					} else if (user == 1 && com == 3 || com == 0) {
						System.out.println("闡У攪陛 " + Game[com] + "蒂 麻蝗棲棻.");
						System.out.println("渡褐曖 蝓葬殮棲棻. 蹴жм棲棻.");
						l = l + 30;

					} else if (user > com) {
						System.out.println("闡У攪陛 " + Game[com] + "蒂 麻蝗棲棻.");
						System.out.println("渡褐曖 蝓葬殮棲棻. 蹴жм棲棻.");
						l = l + 30;

					} else {
						System.out.println("闡У攪陛 " + Game[com] + "蒂 麻蝗棲棻.");
						System.out.println("渡褐檜 螺蝗棲棻.");

					}
					l = l - 20;
				}

				String id = m.getId();

				int mileage = l;
				Map<String, Object> map = new HashMap<>();
				map.put("id", id);
				map.put("mileage", mileage);
				dao.changeMile(map);

				System.out.println("葆橾葬雖陛 睡褶м棲棻.");
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

			System.out.println("棻衛 煎斜檣 п輿撮蹂.");
			m = login();
			l = m.getMileage();

			if (m != null) {
				System.out.println("煎斜檣 腎歷蝗棲棻");

				if (l >= 50) {
					System.out.println("爾嶸 葆橾葬雖: " + l);
					System.out.println("機 縛 棻遴 璋濠 蹺難 啪歜殮棲棻.");
					System.out.println("10廓 衛紫虜縑 薑港擊 蜃轎衛 3繭錳 й檣瓔ア 雖晝.");
					do {

						System.out.print("薑港擊 蹺難п 爾撮蹂 : ");
						guess = sc.nextInt();
						t++;
						if (guess < answer) {
							System.out.println("up");

						}
						if (guess > answer)
							System.out.println("down");

					} while (guess != answer);

					System.out.println("薑港殮棲棻. 衛紫�蝦�=" + t);
					if (t <= 10) {

						dao.gainGame2(m.getId());
						System.out.println("3繭錳 й檣瓔ア縑 渡繩腎歷蝗棲棻");
					}

					System.out.println("檜辨п輿敷憮 馬餌м棲棻");
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
					System.out.println("葆橾葬雖陛 睡褶м棲棻");
				}

			}
		} catch (Exception e) {

		}
	}

	private void event3() {
		GameMain g = new GameMain();

		System.out.println("棻衛 煎斜檣 п輿撮蹂.");

		Member m = login();

		if (m != null) {
			System.out.println("煎斜檣 腎歷蝗棲棻");
			String id = m.getId();
			int l = m.getMileage();

			if (l >= 50) {
				System.out.println("爾嶸 葆橾葬雖: " + l);
				System.out.println("蟾撩蜃蹺晦 啪歜殮棲棻.");
			     System.out.println("5僥薯 瞪睡 蜃轎衛 2繭錳й檣瓔ア 雖晝.");
				int score = g.startmain();
				l = l - 50;
				Map<String, Object> map = new HashMap<>();

				int mileage = l;
				map.put("id", id);
				map.put("mileage", mileage);
				dao.changeMile(map);
				if (score == 100) {
					
					dao.gainGame1(m.getId());
					System.out.println("2繭錳 й檣 瓔ア縑 渡繩腎歷蝗棲棻.");
					System.out.println("檜辨п輿敷憮 馬餌м棲棻.");
				} else {
					System.out.println("檜辨п輿敷憮 馬餌м棲棻.");
				}
				
				event();
			} else {
				System.out.println("葆橾葬雖陛 睡褶м棲棻.");
			}
		}
	}

	private void event4() {
		Quiz q = new Quiz();

		System.out.println("棻衛 煎斜檣 п輿撮蹂.");

		Member m = login();

		if (m != null) {
			System.out.println("煎斜檣 腎歷蝗棲棻");
			String id = m.getId();
			int l = m.getMileage();

			if (l >= 50) {
				System.out.println("爾嶸 葆橾葬雖: " + l);
				int t = q.start();
				l = l - 50;
				Map<String, Object> map = new HashMap<>();

				int mileage = l;
				map.put("id", id);
				map.put("mileage", mileage);
				dao.changeMile(map);
				
				if (t >= 9) {
					
					dao.gainGame3(m.getId());
					System.out.println("5繭錳й檣瓔ア縑 渡繩腎樟蝗棲棻.");
				
				}
				System.out.println("檜辨п輿敷憮 馬餌м棲棻.");
			
			} else {
				System.out.println("葆橾葬雖陛 睡褶м棲棻.");
			}
		}
	}

	public void getResult() {
		System.out.println("棻衛 煎斜檣 п輿撮蹂.");

		Member m = login();
		if (m != null) {
			System.out.println("煎斜檣 腎歷蝗棲棻");
			System.out.println("爾嶸葆橾葬雖: " + m.getMileage());
			System.out.println(dao.allRecord(m.getId()));

		}

	}

	public void nonMemberUI() {
		while (true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("           綠  ��  錳           ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println(" 1. 擠衝薄 匐儀                 ");
			System.out.println(" 0. 鼻嬪 詭景                  ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景 廓�ㄧ� 摹鷗ж撮蹂 =>");
			String menunum = sc.nextLine();
			int menuNum = Integer.parseInt(menunum);
			switch (menuNum) {
			case 1: // 綠�蛾� 擠衝薄匐儀
				this.nonMemberFindRes();
				break;
			case 0: // 鼻嬪詭景
				return;
			}
		}
	}

	private void nonMemberFindRes() {
		while (true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("         擠衝薄 匐儀(綠�蛾�)         ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println(" 1. 謙盟滌(и衝,醞衝,橾衝,曄衝,晦顫)    ");
			System.out.println(" 2. 陛問渠滌                ");
			System.out.println(" 0. 鼻嬪 詭景                ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景 廓�ㄧ� 摹鷗ж撮蹂 =>");
			String menunum = sc.nextLine();
			int menuNum = Integer.parseInt(menunum);

			switch (menuNum) {
			case 1: // 擠衝薄 匐儀
				searchType();
				break;
			case 2:// 陛問渠滌
				searchPrice();
				break;
			case 0: // 鼻嬪詭景
				return;
			}
		}
	}
	

	private void adminUI() {

		while (true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("            遴  艙  濠      	   ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println(" 1. 擠衝薄 婦葬                 ");
			System.out.println(" 2. �蛾� 婦葬                   ");
			System.out.println(" 0. 謙猿                        ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景 廓�ㄧ� 摹鷗ж撮蹂 =>");
			String menunum = sc.nextLine();
			int menuNum = Integer.parseInt(menunum);
			switch (menuNum) {
			case 1: // 擠衝薄 婦葬
				manageRestaurant();
				break;
			case 2:// �蛾� 婦葬
				manageMember();
				break;
			case 0: // 謙猿
				System.out.println("Щ煎斜極擊 謙猿ж啊蝗棲棻");
				System.exit(0);
			}

		}
	}

	private void manageRestaurant() {
		while (true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("           擠衝薄 婦葬              ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println(" 1. 擠衝薄 蛔煙                ");
			System.out.println(" 2. 擠衝薄 餉薯                ");
			System.out.println(" 0. 鼻嬪詭景                   ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景 廓�ㄧ� 摹鷗ж撮蹂 =>");
			String menunum = sc.nextLine();
			int menuNum = Integer.parseInt(menunum);
			switch (menuNum) {
			case 1: // 擠衝薄 蛔煙
				Restaurant r = insertRestaurant();
				boolean insertRestaurant = dao.insertRestaurant(r);
				if (insertRestaurant) {
					System.out.println("擠衝薄檜 蛔煙腎歷蝗棲棻");

				} else {
					System.out.println("擠衝薄 蛔煙檜 褒ぬж艘蝗棲棻");

				}
				break;
			case 2:// 擠衝薄 餉薯
				deleteRestaurant();
				break;
			case 0: // 鼻嬪詭景
				return;
			}

		}
	}

	public Restaurant insertRestaurant() {
		Restaurant r = null;

		System.out.println("== 擠衝薄 蛔煙 ==");
		System.out.print("擠衝薄 檜葷 : ");
		String name = sc.nextLine();
		System.out.print("謙盟(и衝,醞衝,橾衝,曄衝,晦顫):");
		String type = sc.nextLine();

		switch (type) {
		default:
			System.out.print("謙盟(и衝,醞衝,橾衝,曄衝,晦顫):");
			type = sc.nextLine();
		case "и衝":
		case "橾衝":
		case "醞衝":
		case "曄衝":
		case "晦顫":

			break;

		}
		System.out.print("陛問 殮溘(璋濠虜): ");
		String pr = sc.nextLine();
		int price = Integer.parseInt(pr);
		System.out.print("擠衝薄 瞪�食醽�: ");
		String phonenum = sc.nextLine();
		System.out.print("勘葬朝 衛除(剪葬): ");
		String dtime = sc.nextLine();
		r = new Restaurant(name, type, price, phonenum, dtime);

		return r;
	}

	private void deleteRestaurant() {
		System.out.print("餉薯й 擠衝薄 檜葷: ");
		String deleteName = sc.nextLine();
		boolean resultR = dao.deleteRestaurant(deleteName);
		if (resultR) {
			System.out.println("擠衝薄檜 薑鼻瞳戲煎 餉薯腎歷蝗棲棻");
		} else {
			System.out.println("擠衝薄 餉薯蒂 褒ぬж艘蝗棲棻");
		}

	}

	private void manageMember() {
		while (true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("            �� 錳 婦 葬              ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println(" 1. �蛾� 瞪羹褻��                ");
			System.out.println(" 2. �蛾� 餉薯                      ");
			System.out.println(" 3. 瓔ア 嫦歎                    ");
			System.out.println(" 0. 鼻嬪詭景                   ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景 廓�ㄧ� 摹鷗ж撮蹂 =>");
			String menunum = sc.nextLine();
			int menuNum = Integer.parseInt(menunum);
			switch (menuNum) {
			case 1: // �蛾� 瞪羹褻��
				allMemberList();
				break;
			case 2:// �蛾� 餉薯
				deleteMember();
				break;
			case 3://瓔ア爾頂晦
				couponSend();
				break;
			case 0: // 鼻嬪詭景
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
	System.out.print("瓔ア 爾鳥 嬴檜蛤:");
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
	
	
	if(name) {System.out.print("爾鳥 瓔ア(2000錳(1),3000錳(2),5000錳(3) : ");
	int num;
	try{String nu=sc.nextLine();
		 num =Integer.parseInt(nu);
	}catch (Exception e) {
		System.out.println("澀跤殮溘ж樟蝗棲棻.");
		System.out.print("爾鳥 瓔ア(2000錳(1),3000錳(2),5000錳(3) : ");
		String nu=sc.nextLine();
		 num =Integer.parseInt(nu);
	}
	
		 	
	

	if(num==1){
		if(gg1<1) {
			System.out.println("爾鳥瓔ア檜 橈蝗棲棻.");
		break;
		}else {
		System.out.println("⑷營 瓔ア熱: "+gg1);
		System.out.print("爾鳥 瓔ア 熱: ");
		int g1 =sc.nextInt();
		int game1 =gg1-g1;
		map1.put("id", id);
		map1.put("game1", game1);
		dao.game1Send(map1);
		System.out.println("瓔ア檜 薑鼻瞳戲煎 爾頂螺蝗棲棻");
		sc.nextLine();
		break;}
	}else if(num==2) {
		if(gg2<1) {
			System.out.println("爾鳥瓔ア檜 橈蝗棲棻.");
		break;
		}else {
		
		
		System.out.println("⑷營 瓔ア熱: "+gg2);
		System.out.print("爾鳥 瓔ア 熱: ");
		int g2 =sc.nextInt();
		int game2 =gg2- g2;
		map2.put("id", id);
		map2.put("game2", game2);
		dao.game2Send(map2);
		System.out.println("瓔ア檜 薑鼻瞳戲煎 爾頂螺蝗棲棻");
		sc.nextLine();
		break;}
	}else if(num==3) {
		if(gg3<1) {
			System.out.println("爾鳥瓔ア檜 橈蝗棲棻.");
		break;
		}else {
		System.out.println("⑷營 瓔ア熱: "+gg3);
		System.out.print("爾鳥 瓔ア 熱: ");
		int g3 =sc.nextInt();
		int game3 =gg3- g3;
		map3.put("id", id);
		map3.put("game3", game3);
		dao.game3Send(map3);		
		System.out.println("瓔ア檜 薑鼻瞳戲煎 爾頂螺蝗棲棻");
		sc.nextLine();
		break;
		}
	
	}else {System.out.println("澀跤殮溘ж樟蝗棲棻");}	
	
	}
	else {System.out.println("嬴檜蛤陛 澀跤腎歷蝗棲棻");
	}
		
	
	
	
	}
	
	}
		public void memberCoupon() {
		
			System.out.println("�蛾� 瓔ア 薑爾");
		
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
		System.out.print("餉薯й 嬴檜蛤: ");
		String deleteId = sc.nextLine();
		boolean resultId = dao.deleteMember(deleteId);
		if (resultId) {
			System.out.println("嬴檜蛤陛 薑鼻瞳戲煎 餉薯腎歷蝗棲棻");
		} else {
			System.out.println("嬴檜蛤 餉薯陛 褒ぬж艘蝗棲棻");
		}

	}

	// 嬴檜蛤 虜菟晦
	public Member insertid() {
		System.out.println("==  �蛾灠㊣�  ==");
		System.out.print("嬴檜蛤: ");
		String id = sc.nextLine();
		System.out.print("綠塵廓��: ");
		String pw = sc.nextLine();
		System.out.print("綠廓�挫�: ");
		String repw = sc.nextLine();
		Member m = null;
		if (pw.equals(repw)) {
			m = new Member(id, pw);
		} else {
			System.out.println("綠塵廓�ㄟ�  橾纂ж雖彊蝗棲棻.");
		}
		return m;
	}

	// 煎斜檣
	public Member login() {
		Member m = null;
		System.out.println("=====煎斜檣=====");
		System.out.print("嬴檜蛤: ");
		String id = sc.nextLine();
		System.out.print("綠塵廓��: ");
		String pw = sc.nextLine();

		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		m = dao.searchMember(map);

		return m;
	}

	// 擠衝薄 匐儀(謙盟滌)
	public void searchType() {

		System.out.println("==謙盟滌 匐儀==");
		System.out.print("謙盟 殮溘=>");
		String type = sc.nextLine();
		List<Restaurant> l = dao.allRestaurant();

		for (Restaurant r : l) {
			if (type.equals(r.getType())) {
				System.out.println(r);
			}
		}

	}

	// 擠衝薄 匐儀(陛問渠滌)
	public void searchPrice() {

		System.out.println("==陛問渠滌 匐儀==");
		System.out.print("譆模陛問 殮溘=>");
		String small = sc.nextLine();
		int sp = Integer.parseInt(small);
		System.out.print("譆渠陛問 殮溘=>");
		String large = sc.nextLine();
		int lp = Integer.parseInt(large);
		List<Restaurant> l = dao.allRestaurant();
		for (Restaurant r : l) {
			if (sp <= r.getPrice() && r.getPrice() <= lp) {
				System.out.println(r);
			}

		}
	}

	// 葬Ы 詭景
	public void getCommentary(Restaurant r) {
		List<Commentary> cList = dao.getReplyList(r.getName());
		if (cList != null) {
			for (Commentary c : cList) {
				System.out.println(c);
			}
		}
		insertCommentary(r);
	}

	// 葬Ы殮溘
	public void insertCommentary(Restaurant r) {
		while (true) {

			System.out.println("1. 渤旋 殖晦");
			System.out.println("2. ゎ薄衙晦晦");
			System.out.println("3. 鼻嬪詭景");
			System.out.print("詭景摹鷗=> ");
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
						System.out.println("渤旋 蛔煙 撩奢");

						String id = m.getId();

						int mileage = m.getMileage() + 100;
						Map<String, Object> map = new HashMap<>();
						map.put("id", id);
						map.put("mileage", mileage);
						dao.changeMile(map);
						
					} else {
						System.out.println("渤旋 蛔煙 褒ぬ");
					}

				} else {
					System.out.println("嬴檜蛤釭 綠塵廓�ㄟ� ぎ董棲棻");

				}

				break;
			case 2:// ゎ薄
				double ra = r.getRate();
				double rate = 0;
				System.out.println("0~5餌檜 璋濠蒂 殮溘п輿撮蹂=>");
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
					System.out.println("棻衛殮溘п輿撮蹂");
					System.out.print("0~5餌檜 璋濠蒂 殮溘п輿撮蹂=>");
					nu = sc.nextLine();

					number = Integer.parseInt(nu);
				}

			case 3:
				return;

			}
		}
	}
}
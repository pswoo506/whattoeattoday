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
			System.out.println("����������������������������������������������������������������");
			System.out.println("         ���� �� ���� ?	       ");
			System.out.println("����������������������������������������������������������������");
			System.out.println("����������������������������������������������������������������");
			System.out.println(" 1. ȸ��	               ");
			System.out.println(" 2. ��ȸ��		       ");
			System.out.println(" 3. ���	               ");
			System.out.println(" 4. ȸ������	               ");
			System.out.println(" 0. ����	               ");
			System.out.println("����������������������������������������������������������������");
			System.out.print("�޴���ȣ�� �����ϼ���=> ");

			try {
				String num = sc.nextLine();
				int menuNum = Integer.parseInt(num);

				switch (menuNum) {
				case 1:// ȸ��
					try {
						Member m = login();

						if (m != null) {
							System.out.println("�α��� �Ǿ����ϴ�");
							System.out.println("������� ���ϸ��� 100p�� ���޵Ǿ����ϴ�");
							Map<String, Object> map = new HashMap<String, Object>();
							String id = m.getId();
							int mileage = m.getMileage() + 100;
							map.put("id", id);
							map.put("mileage", mileage);
							dao.changeMile(map);
							this.memberUI();
						} else {
							System.out.println("���������ʴ� ȸ�� �Ǵ� ���̵� ��й�ȣ�� ��ġ�����ʽ��ϴ�.");
						}

					} catch (Exception e) {
					}

					break;
				case 2: // ��ȸ��

					this.nonMemberUI();
					break;
				case 3:// ���
					Member ad = login();
					try {
						if (ad.getId().equals("master")) {
							System.out.println("�α��εǾ����ϴ�");
							this.adminUI();
						} else {
							System.out.println("��ڰ� �ƴմϴ�");
						}
					} catch (Exception e) {
						System.out.println("���̵� ��й�ȣ�� Ʋ���ϴ�");
					}

					break;
				case 4: // ȸ������

					try {
						Member p = insertid();
						boolean insertid = dao.insertMember(p);
						if (insertid) {
							Record r = new Record(p.getId());
							dao.insertRecord(r);

							System.out.println("���̵� �����Ǿ����ϴ�");

						}

					} catch (Exception e) {
						System.out.println("���̵� ����� �����Ͽ����ϴ�");
					}

					break;
				case 0: // ���α׷� ����
					System.out.println("���α׷��� �����ϰڽ��ϴ�.");
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println("���ڸ� �Է����ּ���");

			}
		}
	}

	public void memberUI() {

		while (true) {
			System.out.println("����������������������������������������������������������������");
			System.out.println("	   ȸ       ��	       ");
			System.out.println("����������������������������������������������������������������");
			System.out.println("����������������������������������������������������������������");
			System.out.println(" 1. ������ �˻�	           ");
			System.out.println(" 2. �̺�Ʈ	               ");
			System.out.println(" 3. ȸ��Ż��	               ");
			System.out.println(" 0. �α� �ƿ�(����)	       ");
			System.out.println("����������������������������������������������������������������");
			System.out.print("�޴� ��ȣ�� �����ϼ��� =>");
			try {

				String menunum = sc.nextLine();
				int menuNum = Integer.parseInt(menunum);

				switch (menuNum) {
				case 1: // ������ �˻�
					this.findRes();
					break;
				case 2:// �̺�Ʈ
					this.event();
					break;
				case 3:
					System.out.println("�ٽ� �α��� ���ּ���");
					Member dm = login();
					if (dm != null) {
						boolean resultId = dao.deleteMember(dm.getId());
						if (resultId) {
							System.out.println("���̵� ���������� �����Ǿ����ϴ�");
						} else {
							System.out.println("���̵� ������ �����Ͽ����ϴ�");
						}
					} else {
						System.out.println("���̵� ��й�ȣ�� Ʋ���ϴ�");
					}

				case 0: // �α׾ƿ�(����)
					System.out.println("�α׾ƿ� ����! ���α׷��� �����մϴ�.");
					System.exit(0);
				}

			} catch (Exception e) {
				System.out.println("���ڸ� �Է����ּ���");
			}
		}
	}

	private void findRes() {
		while (true) {
			System.out.println("������������������������������������������������������������������������");
			System.out.println("        ������ �˻�(ȸ������)       ");
			System.out.println("������������������������������������������������������������������������");
			System.out.println("������������������������������������������������������������������������");
			System.out.println(" 1. ������(�ѽ�,�߽�,�Ͻ�,���,��Ÿ)    ");
			System.out.println(" 2. ���ݴ뺰                ");
			System.out.println(" 3. ������ �˻�(��۴ޱ� �� ����)    ");
			System.out.println(" 0. ���� �޴�                ");
			System.out.println("������������������������������������������������������������������������");
			System.out.print("�޴� ��ȣ�� �����ϼ��� =>");
			try {

				String menunum = sc.nextLine();
				int menuNum = Integer.parseInt(menunum);

				switch (menuNum) {
				case 1: // ������ �������˻�
					searchType();
					break;
				case 2:// ���ݴ뺰 �˻�
					searchPrice();
					break;
				case 3:
					System.out.print("������ �̸�: ");
					String searchName = sc.nextLine();
					Restaurant searn = dao.searchRestaurant(searchName);
					if (searn != null) {
						dao.addHits(searchName);
						System.out.println(searn);
						getCommentary(searn);

					} else {
						System.out.println("ã���� �������� �����ϴ�");
					}
					break;
				case 0: // �����޴�
					return;
				}
			} catch (Exception e) {
				System.out.println("���ڸ� �Է����ּ���");
			}
		}
	}

	private void event() {

		int menuNum;

		while (true) {
			System.out.println("����������������������������������������������������������������");
			System.out.println("       �̺�Ʈ ����(ȸ������)  ");
			System.out.println("����������������������������������������������������������������");
			System.out.println("����������������������������������������������������������������");
			System.out.println(" 1. ����������!(1�� 20p)   	   ");
			System.out.println(" 2. ���� �� �ٿ�(1�� 50p)      ");
			System.out.println(" 3. �ʼ� ���߱�(1�� 50p)   	   ");
			System.out.println(" 4. �ͼ���/���� ����(1�� 50p)  ");
			System.out.println(" 5. ���� Ȯ��(�������ϸ���) 	   ");
			System.out.println(" 0. ���� �޴�       	           ");
			System.out.println("����������������������������������������������������������������");
			System.out.print("�޴� ��ȣ�� �����ϼ��� =>");

			try {
				String menunum = sc.nextLine();
				menuNum = Integer.parseInt(menunum);

				switch (menuNum) {
				case 1: // ����������1
					event1();
					break;
				case 2:// ���ڸ��߱�
					event2();
					break;
				case 3:// �ʼ����߱�
					event3();
					break;
				case 4:// �������
					event4();
					break;
				case 5:
					getResult();
					break;
				case 0: // �����޴�
					memberUI();
				default:
					System.out.println("�ٽ��Է����ּ���.");
				}
			} catch (Exception e) {
				System.out.println("�ٽ��Է����ּ���");
			}
		}
	}
	/*
	 * �迭�� �����Լ� ���
	 */
	private void event1() {
		int user, com;
		Random rd = new Random();
		String[] Game = new String[] { "�����", "����", "����", "��" }; //
		Member m = null;

		try {

			System.out.println("�ٽ� �α��� ���ּ���.");
			m = login();
			int l = m.getMileage();

			if (m != null) {
				System.out.println("�α��� �Ǿ����ϴ�");

				while (l >= 20) {
					System.out.println("���� ���ϸ���: " + l + "p");

					System.out.println("���� ���� �� �����Դϴ�!(1�Ǵ� 20p �Ҹ�) ���� �޴��� �������ּ���");
					System.out.println("�̱�� 30p ȹ��, ���� �����Դϴ�.");
					System.out.println("1.����  2.����  3.��  4.������");
					System.out.print("��ȣ�� �������ּ���: ");
					user = sc.nextInt();
					com = rd.nextInt(3);

					if (user > 4) {
						System.out.println("�ٽ� �������ּ���");
						continue;
					} else if (user == 4) {
						System.out.println("�̿����ּż� �����մϴ�.");

						result(m, l);
					}
					if (user == com) {
						System.out.println("��ǻ�Ͱ� " + Game[com] + "�� �½��ϴ�.");
						System.out.println("�����ϴ�");
						l = l + 20;

					} else if (user == 0 ^ com == 0) { //�迭 1���� ����ó����.
						System.out.println("��ǻ�Ͱ� �� ���� �����̴ٰ� �ƹ��͵� ���� ���߽��ϴ�.");
						System.out.println("����� �¸��Դϴ�. �����մϴ�");
						l = l + 30;

					} else if (user == 2 && com == 3 || com == 0) {
						System.out.println("��ǻ�Ͱ� " + Game[com] + "�� �½��ϴ�.");
						System.out.println("����� �����ϴ�.");

					} else if (user == 1 && com == 3 || com == 0) {
						System.out.println("��ǻ�Ͱ� " + Game[com] + "�� �½��ϴ�.");
						System.out.println("����� �¸��Դϴ�. �����մϴ�.");
						l = l + 30;

					} else if (user > com) {
						System.out.println("��ǻ�Ͱ� " + Game[com] + "�� �½��ϴ�.");
						System.out.println("����� �¸��Դϴ�. �����մϴ�.");
						l = l + 30;

					} else {
						System.out.println("��ǻ�Ͱ� " + Game[com] + "�� �½��ϴ�.");
						System.out.println("����� �����ϴ�.");

					}
					l = l - 20;
				}

				String id = m.getId();

				int mileage = l;
				Map<String, Object> map = new HashMap<>();
				map.put("id", id);
				map.put("mileage", mileage);
				dao.changeMile(map);

				System.out.println("���ϸ����� �����մϴ�.");
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

			System.out.println("�ٽ� �α��� ���ּ���.");
			m = login();
			l = m.getMileage();

			if (m != null) {
				System.out.println("�α��� �Ǿ����ϴ�");

				if (l >= 50) {
					System.out.println("���� ���ϸ���: " + l);
					System.out.println("�� �� �ٿ� ���� ���� �����Դϴ�.");
					System.out.println("10�� �õ����� ������ ����� 3õ�� �������� ����.");
					do {

						System.out.print("������ ������ ������ : ");
						guess = sc.nextInt();
						t++;
						if (guess < answer) {
							System.out.println("up");

						}
						if (guess > answer)
							System.out.println("down");

					} while (guess != answer);

					System.out.println("�����Դϴ�. �õ�Ƚ��=" + t);
					if (t <= 10) {

						dao.gainGame2(m.getId());
						System.out.println("3õ�� ���������� ��÷�Ǿ����ϴ�");
					}

					System.out.println("�̿����ּż� �����մϴ�");
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
					System.out.println("���ϸ����� �����մϴ�");
				}

			}
		} catch (Exception e) {

		}
	}

	private void event3() {
		GameMain g = new GameMain();

		System.out.println("�ٽ� �α��� ���ּ���.");

		Member m = login();

		if (m != null) {
			System.out.println("�α��� �Ǿ����ϴ�");
			String id = m.getId();
			int l = m.getMileage();

			if (l >= 50) {
				System.out.println("���� ���ϸ���: " + l);
				System.out.println("�ʼ����߱� �����Դϴ�.");
			     System.out.println("5���� ���� ����� 2õ���������� ����.");
				int score = g.startmain();
				l = l - 50;
				Map<String, Object> map = new HashMap<>();

				int mileage = l;
				map.put("id", id);
				map.put("mileage", mileage);
				dao.changeMile(map);
				if (score == 100) {
					
					dao.gainGame1(m.getId());
					System.out.println("2õ�� ���� ������ ��÷�Ǿ����ϴ�.");
					System.out.println("�̿����ּż� �����մϴ�.");
				} else {
					System.out.println("�̿����ּż� �����մϴ�.");
				}
				
				event();
			} else {
				System.out.println("���ϸ����� �����մϴ�.");
			}
		}
	}

	private void event4() {
		Quiz q = new Quiz();

		System.out.println("�ٽ� �α��� ���ּ���.");

		Member m = login();

		if (m != null) {
			System.out.println("�α��� �Ǿ����ϴ�");
			String id = m.getId();
			int l = m.getMileage();

			if (l >= 50) {
				System.out.println("���� ���ϸ���: " + l);
				int t = q.start();
				l = l - 50;
				Map<String, Object> map = new HashMap<>();

				int mileage = l;
				map.put("id", id);
				map.put("mileage", mileage);
				dao.changeMile(map);
				
				if (t >= 9) {
					
					dao.gainGame3(m.getId());
					System.out.println("5õ������������ ��÷�Ǽ̽��ϴ�.");
				
				}
				System.out.println("�̿����ּż� �����մϴ�.");
			
			} else {
				System.out.println("���ϸ����� �����մϴ�.");
			}
		}
	}

	public void getResult() {
		System.out.println("�ٽ� �α��� ���ּ���.");

		Member m = login();
		if (m != null) {
			System.out.println("�α��� �Ǿ����ϴ�");
			System.out.println("�������ϸ���: " + m.getMileage());
			System.out.println(dao.allRecord(m.getId()));

		}

	}

	public void nonMemberUI() {
		while (true) {
			System.out.println("����������������������������������������������������������������");
			System.out.println("           ��  ȸ  ��           ");
			System.out.println("����������������������������������������������������������������");
			System.out.println("����������������������������������������������������������������");
			System.out.println(" 1. ������ �˻�                 ");
			System.out.println(" 0. ���� �޴�                  ");
			System.out.println("����������������������������������������������������������������");
			System.out.print("�޴� ��ȣ�� �����ϼ��� =>");
			String menunum = sc.nextLine();
			int menuNum = Integer.parseInt(menunum);
			switch (menuNum) {
			case 1: // ��ȸ�� �������˻�
				this.nonMemberFindRes();
				break;
			case 0: // �����޴�
				return;
			}
		}
	}

	private void nonMemberFindRes() {
		while (true) {
			System.out.println("����������������������������������������������������������������������");
			System.out.println("         ������ �˻�(��ȸ��)         ");
			System.out.println("����������������������������������������������������������������������");
			System.out.println("����������������������������������������������������������������������");
			System.out.println(" 1. ������(�ѽ�,�߽�,�Ͻ�,���,��Ÿ)    ");
			System.out.println(" 2. ���ݴ뺰                ");
			System.out.println(" 0. ���� �޴�                ");
			System.out.println("����������������������������������������������������������������������");
			System.out.print("�޴� ��ȣ�� �����ϼ��� =>");
			String menunum = sc.nextLine();
			int menuNum = Integer.parseInt(menunum);

			switch (menuNum) {
			case 1: // ������ �˻�
				searchType();
				break;
			case 2:// ���ݴ뺰
				searchPrice();
				break;
			case 0: // �����޴�
				return;
			}
		}
	}
	

	private void adminUI() {

		while (true) {
			System.out.println("����������������������������������������������������������������");
			System.out.println("            ��  ��  ��      	   ");
			System.out.println("����������������������������������������������������������������");
			System.out.println("����������������������������������������������������������������");
			System.out.println(" 1. ������ ����                 ");
			System.out.println(" 2. ȸ�� ����                   ");
			System.out.println(" 0. ����                        ");
			System.out.println("����������������������������������������������������������������");
			System.out.print("�޴� ��ȣ�� �����ϼ��� =>");
			String menunum = sc.nextLine();
			int menuNum = Integer.parseInt(menunum);
			switch (menuNum) {
			case 1: // ������ ����
				manageRestaurant();
				break;
			case 2:// ȸ�� ����
				manageMember();
				break;
			case 0: // ����
				System.out.println("���α׷��� �����ϰڽ��ϴ�");
				System.exit(0);
			}

		}
	}

	private void manageRestaurant() {
		while (true) {
			System.out.println("����������������������������������������������������������������");
			System.out.println("           ������ ����              ");
			System.out.println("����������������������������������������������������������������");
			System.out.println("����������������������������������������������������������������");
			System.out.println(" 1. ������ ���                ");
			System.out.println(" 2. ������ ����                ");
			System.out.println(" 0. �����޴�                   ");
			System.out.println("����������������������������������������������������������������");
			System.out.print("�޴� ��ȣ�� �����ϼ��� =>");
			String menunum = sc.nextLine();
			int menuNum = Integer.parseInt(menunum);
			switch (menuNum) {
			case 1: // ������ ���
				Restaurant r = insertRestaurant();
				boolean insertRestaurant = dao.insertRestaurant(r);
				if (insertRestaurant) {
					System.out.println("�������� ��ϵǾ����ϴ�");

				} else {
					System.out.println("������ ����� �����Ͽ����ϴ�");

				}
				break;
			case 2:// ������ ����
				deleteRestaurant();
				break;
			case 0: // �����޴�
				return;
			}

		}
	}

	public Restaurant insertRestaurant() {
		Restaurant r = null;

		System.out.println("== ������ ��� ==");
		System.out.print("������ �̸� : ");
		String name = sc.nextLine();
		System.out.print("����(�ѽ�,�߽�,�Ͻ�,���,��Ÿ):");
		String type = sc.nextLine();

		switch (type) {
		default:
			System.out.print("����(�ѽ�,�߽�,�Ͻ�,���,��Ÿ):");
			type = sc.nextLine();
		case "�ѽ�":
		case "�Ͻ�":
		case "�߽�":
		case "���":
		case "��Ÿ":

			break;

		}
		System.out.print("���� �Է�(���ڸ�): ");
		String pr = sc.nextLine();
		int price = Integer.parseInt(pr);
		System.out.print("������ ��ȭ��ȣ: ");
		String phonenum = sc.nextLine();
		System.out.print("�ɸ��� �ð�(�Ÿ�): ");
		String dtime = sc.nextLine();
		r = new Restaurant(name, type, price, phonenum, dtime);

		return r;
	}

	private void deleteRestaurant() {
		System.out.print("������ ������ �̸�: ");
		String deleteName = sc.nextLine();
		boolean resultR = dao.deleteRestaurant(deleteName);
		if (resultR) {
			System.out.println("�������� ���������� �����Ǿ����ϴ�");
		} else {
			System.out.println("������ ������ �����Ͽ����ϴ�");
		}

	}

	private void manageMember() {
		while (true) {
			System.out.println("����������������������������������������������������������������");
			System.out.println("            ȸ �� �� ��              ");
			System.out.println("����������������������������������������������������������������");
			System.out.println("����������������������������������������������������������������");
			System.out.println(" 1. ȸ�� ��ü��ȸ                ");
			System.out.println(" 2. ȸ�� ����                      ");
			System.out.println(" 3. ���� �߼�                    ");
			System.out.println(" 0. �����޴�                   ");
			System.out.println("����������������������������������������������������������������");
			System.out.print("�޴� ��ȣ�� �����ϼ��� =>");
			String menunum = sc.nextLine();
			int menuNum = Integer.parseInt(menunum);
			switch (menuNum) {
			case 1: // ȸ�� ��ü��ȸ
				allMemberList();
				break;
			case 2:// ȸ�� ����
				deleteMember();
				break;
			case 3://����������
				couponSend();
				break;
			case 0: // �����޴�
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
	System.out.print("���� ���� ���̵�:");
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
	
	
	if(name) {System.out.print("���� ����(2000��(1),3000��(2),5000��(3) : ");
	int num;
	try{String nu=sc.nextLine();
		 num =Integer.parseInt(nu);
	}catch (Exception e) {
		System.out.println("�߸��Է��ϼ̽��ϴ�.");
		System.out.print("���� ����(2000��(1),3000��(2),5000��(3) : ");
		String nu=sc.nextLine();
		 num =Integer.parseInt(nu);
	}
	
		 	
	

	if(num==1){
		if(gg1<1) {
			System.out.println("���������� �����ϴ�.");
		break;
		}else {
		System.out.println("���� ������: "+gg1);
		System.out.print("���� ���� ��: ");
		int g1 =sc.nextInt();
		int game1 =gg1-g1;
		map1.put("id", id);
		map1.put("game1", game1);
		dao.game1Send(map1);
		System.out.println("������ ���������� ���������ϴ�");
		sc.nextLine();
		break;}
	}else if(num==2) {
		if(gg2<1) {
			System.out.println("���������� �����ϴ�.");
		break;
		}else {
		
		
		System.out.println("���� ������: "+gg2);
		System.out.print("���� ���� ��: ");
		int g2 =sc.nextInt();
		int game2 =gg2- g2;
		map2.put("id", id);
		map2.put("game2", game2);
		dao.game2Send(map2);
		System.out.println("������ ���������� ���������ϴ�");
		sc.nextLine();
		break;}
	}else if(num==3) {
		if(gg3<1) {
			System.out.println("���������� �����ϴ�.");
		break;
		}else {
		System.out.println("���� ������: "+gg3);
		System.out.print("���� ���� ��: ");
		int g3 =sc.nextInt();
		int game3 =gg3- g3;
		map3.put("id", id);
		map3.put("game3", game3);
		dao.game3Send(map3);		
		System.out.println("������ ���������� ���������ϴ�");
		sc.nextLine();
		break;
		}
	
	}else {System.out.println("�߸��Է��ϼ̽��ϴ�");}	
	
	}
	else {System.out.println("���̵� �߸��Ǿ����ϴ�");
	}
		
	
	
	
	}
	
	}
		public void memberCoupon() {
		
			System.out.println("ȸ�� ���� ����");
		
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
		System.out.print("������ ���̵�: ");
		String deleteId = sc.nextLine();
		boolean resultId = dao.deleteMember(deleteId);
		if (resultId) {
			System.out.println("���̵� ���������� �����Ǿ����ϴ�");
		} else {
			System.out.println("���̵� ������ �����Ͽ����ϴ�");
		}

	}

	// ���̵� �����
	public Member insertid() {
		System.out.println("==  ȸ������  ==");
		System.out.print("���̵�: ");
		String id = sc.nextLine();
		System.out.print("��й�ȣ: ");
		String pw = sc.nextLine();
		System.out.print("���Ȯ��: ");
		String repw = sc.nextLine();
		Member m = null;
		if (pw.equals(repw)) {
			m = new Member(id, pw);
		} else {
			System.out.println("��й�ȣ��  ��ġ�����ʽ��ϴ�.");
		}
		return m;
	}

	// �α���
	public Member login() {
		Member m = null;
		System.out.println("=====�α���=====");
		System.out.print("���̵�: ");
		String id = sc.nextLine();
		System.out.print("��й�ȣ: ");
		String pw = sc.nextLine();

		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		m = dao.searchMember(map);

		return m;
	}

	// ������ �˻�(������)
	public void searchType() {

		System.out.println("==������ �˻�==");
		System.out.print("���� �Է�=>");
		String type = sc.nextLine();
		List<Restaurant> l = dao.allRestaurant();

		for (Restaurant r : l) {
			if (type.equals(r.getType())) {
				System.out.println(r);
			}
		}

	}

	// ������ �˻�(���ݴ뺰)
	public void searchPrice() {

		System.out.println("==���ݴ뺰 �˻�==");
		System.out.print("�ּҰ��� �Է�=>");
		String small = sc.nextLine();
		int sp = Integer.parseInt(small);
		System.out.print("�ִ밡�� �Է�=>");
		String large = sc.nextLine();
		int lp = Integer.parseInt(large);
		List<Restaurant> l = dao.allRestaurant();
		for (Restaurant r : l) {
			if (sp <= r.getPrice() && r.getPrice() <= lp) {
				System.out.println(r);
			}

		}
	}

	// ���� �޴�
	public void getCommentary(Restaurant r) {
		List<Commentary> cList = dao.getReplyList(r.getName());
		if (cList != null) {
			for (Commentary c : cList) {
				System.out.println(c);
			}
		}
		insertCommentary(r);
	}

	// �����Է�
	public void insertCommentary(Restaurant r) {
		while (true) {

			System.out.println("1. ��� �ޱ�");
			System.out.println("2. �����ű��");
			System.out.println("3. �����޴�");
			System.out.print("�޴�����=> ");
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
						System.out.println("��� ��� ����");

						String id = m.getId();

						int mileage = m.getMileage() + 100;
						Map<String, Object> map = new HashMap<>();
						map.put("id", id);
						map.put("mileage", mileage);
						dao.changeMile(map);
						
					} else {
						System.out.println("��� ��� ����");
					}

				} else {
					System.out.println("���̵� ��й�ȣ�� Ʋ���ϴ�");

				}

				break;
			case 2:// ����
				double ra = r.getRate();
				double rate = 0;
				System.out.println("0~5���� ���ڸ� �Է����ּ���=>");
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
					System.out.println("�ٽ��Է����ּ���");
					System.out.print("0~5���� ���ڸ� �Է����ּ���=>");
					nu = sc.nextLine();

					number = Integer.parseInt(nu);
				}

			case 3:
				return;

			}
		}
	}
}
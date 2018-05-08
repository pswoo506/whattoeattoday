package food.service;

import java.util.List;
import java.util.Map;

import food.vo.Commentary;
import food.vo.Record;
import food.vo.Member;
import food.vo.Restaurant;

public interface FoodMapper {
	// ȸ�� ���
	public boolean insertMember(Member m);

	// ȸ�� �˻�
	public Member searchMember(Map<String, Object> map);

	// ȸ�� Ż��
	public boolean deleteMember(String id);

	// ȸ�� ��ü ���
	public List<Member> getMemberList();

	// ���ϸ��� ����
	public boolean changeMile(Map<String, Object> map);

	// ----------------������----------------
	// ������ ���
	public boolean insertRestaurant(Restaurant r);

	// ������ �˻�
	public Restaurant searchRestaurant(String name);

	// ������ ����
	public boolean deleteRestaurant(String name);

	// ������ ��ü�˻�
	public List<Restaurant> allRestaurant();

	// ��ȸ�� ����
	public int addHits(String name);

	// ����
	public boolean avgRate(Map<String, Object> map);

	// ���� �ű� �����
	public int rperson(String name);
	// ----------------���------------------

	// ��� ���
	public boolean insertReply(Commentary c);

	// ��� ��������
	public List<Commentary> getReplyList(String name);

	// ---------------����------------------

	// ���� ����
	public boolean insertRecord(Record r);

	public int gainGame1(String id);

	public int gainGame2(String id);

	public int gainGame3(String id);

	public boolean game1Send(Map<String, Object> map);
	
	public boolean game2Send(Map<String, Object> map);
	
	public boolean game3Send(Map<String, Object> map);
	
	public List<Record> allRecord(String id);

	public List<Record> couponRecord();
}

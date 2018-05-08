package food.service;

import java.util.List;
import java.util.Map;

import food.vo.Commentary;
import food.vo.Record;
import food.vo.Member;
import food.vo.Restaurant;

public interface FoodMapper {
	// 회원 등록
	public boolean insertMember(Member m);

	// 회원 검색
	public Member searchMember(Map<String, Object> map);

	// 회원 탈퇴
	public boolean deleteMember(String id);

	// 회원 전체 목록
	public List<Member> getMemberList();

	// 마일리지 변동
	public boolean changeMile(Map<String, Object> map);

	// ----------------음식점----------------
	// 음식점 등록
	public boolean insertRestaurant(Restaurant r);

	// 음식점 검색
	public Restaurant searchRestaurant(String name);

	// 음식점 삭제
	public boolean deleteRestaurant(String name);

	// 음식점 전체검색
	public List<Restaurant> allRestaurant();

	// 조회수 증가
	public int addHits(String name);

	// 평점
	public boolean avgRate(Map<String, Object> map);

	// 평점 매긴 사람수
	public int rperson(String name);
	// ----------------댓글------------------

	// 댓글 등록
	public boolean insertReply(Commentary c);

	// 댓글 가져오기
	public List<Commentary> getReplyList(String name);

	// ---------------게임------------------

	// 게임 생성
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

package food.service;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import food.vo.Commentary;
import food.vo.Member;
import food.vo.Record;
import food.vo.Restaurant;

public class FoodDAO implements FoodMapper {
	private SqlSessionFactory factory = MyBatisConfig.getSqlSessionFactory();

	@Override
	public boolean insertMember(Member m) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		boolean result = false;
		try {
			result = fm.insertMember(m);
			result = true;
			session.commit();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public Member searchMember(Map<String, Object> map) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		Member m = null;
		try {
			m = fm.searchMember(map);

		} finally {
			session.close();
		}
		return m;
	}

	@Override
	public boolean deleteMember(String id) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		boolean result = false;
		try {
			result = fm.deleteMember(id);
			session.commit();
			result = true;
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<Member> getMemberList() {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		List<Member> list = null;
		try {
			list = fm.getMemberList();

		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public boolean changeMile(Map<String, Object> map) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		boolean result = false;
		try {
			result = fm.changeMile(map);
			session.commit();
			result = true;
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public boolean insertRestaurant(Restaurant r) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		boolean result = false;
		try {
			result = fm.insertRestaurant(r);

			session.commit();
			result = true;
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public Restaurant searchRestaurant(String name) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		Restaurant r = null;
		try {
			r = fm.searchRestaurant(name);

		} finally {
			session.close();
		}
		return r;
	}

	@Override
	public boolean deleteRestaurant(String name) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		boolean result = false;
		try {
			result = fm.deleteRestaurant(name);
			session.commit();
			result = true;

		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<Restaurant> allRestaurant() {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		List<Restaurant> list = null;
		try {
			list = fm.allRestaurant();

		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int addHits(String name) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		int n = 0;
		try {
			n = fm.addHits(name);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

	public boolean avgRate(Map<String, Object> map) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		boolean result = false;
		try {
			result = fm.avgRate(map);
			session.commit();
			result = true;
		} finally {
			session.close();
		}
		return result;
	}

	public int rperson(String name) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		int n = 0;
		try {
			n = fm.rperson(name);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

	@Override
	public boolean insertReply(Commentary c) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		boolean result = false;
		try {
			result = fm.insertReply(c);
			session.commit();
			result = true;
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<Commentary> getReplyList(String name) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		List<Commentary> list = null;
		try {
			list = fm.getReplyList(name);

		} finally {
			session.close();
		}
		return list;
	}

	public boolean insertRecord(Record r) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		boolean result = false;
		try {
			result = fm.insertRecord(r);
			session.commit();
			result = true;
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int gainGame1(String id) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		int n = 0;
		try {
			n = fm.gainGame1(id);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

	@Override
	public int gainGame2(String id) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		int n = 0;
		try {
			n = fm.gainGame2(id);
			session.commit();

		} finally {
			session.close();
		}
		return n;
	}

	@Override
	public int gainGame3(String id) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		int n = 0;
		try {
			n = fm.gainGame3(id);
			session.commit();

		} finally {
			session.close();
		}
		return n;
	}
	public boolean game1Send(Map<String, Object> map) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
	boolean result =false;
		try {result =fm.game1Send(map);
			session.commit();
			result =true;
		} finally {
		session.close();
	}
		return result;
	}
	
	
	public boolean game2Send(Map<String, Object> map) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
	boolean result =false;
		try {result =fm.game2Send(map);
		
		session.commit();
			result =true;
		} finally {
		session.close();
	}
		return result;
	}
	
	public boolean game3Send(Map<String, Object> map) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
	boolean result =false;
		try {result =fm.game3Send(map);
			session.commit();
			result =true;
		} finally {
		session.close();
	}
		return result;
	}

	@Override
	public List<Record> allRecord(String id) {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		List<Record> list = null;
		try {
			list = fm.allRecord(id);

		} finally {
			session.close();
		}
		return list;
	}
	public List<Record> couponRecord() {
		SqlSession session = factory.openSession();
		FoodMapper fm = session.getMapper(FoodMapper.class);
		List<Record> list = null;
		try {
			list = fm.couponRecord();

		} finally {
			session.close();
		}
		return list;
	}




}

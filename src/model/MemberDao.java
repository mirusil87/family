package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mapper.MemberMapper;

public class MemberDao {
	private static final String ns="mapper.MemberMapper.";
	public Member selectOne(String name) { 
		SqlSession session = DBConnection.getConnection();
		try {
			Map map = new HashMap();
			map.put("name", name);
			return session.selectOne(ns+"select",map); // db의 id에 해당하는 member 테이블의 레코드 저장한 Bean객체
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null; // 조회된 레코드가 없는 경우.
	}
	public List<Member> selectList(String name) {
		SqlSession session = DBConnection.getConnection();
		try {
			Map map = new HashMap();
			map.put("name", name);
			List<Member> list = session.selectList(ns+"select",map);
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
		DBConnection.close(session);
		}
		return null;
	}
	public int insert(Member mem) {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(MemberMapper.class).insert(mem); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0; 
	}
	public int delete(String name) {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(MemberMapper.class).delete(name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
	public List<Member> list() {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.selectList(ns+"select");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null;
	}
	public int update(Member mem) {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(MemberMapper.class).update(mem); // 레코드 변경된 수 여기선 0 아니면 1개
		} catch (Exception e) { // 기본값이 작성되지 않을 때 발생 및 SQL 오류가 뜨면 오류
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0; 
	}
}

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
			return session.selectOne(ns+"select",map); // db�� id�� �ش��ϴ� member ���̺��� ���ڵ� ������ Bean��ü
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null; // ��ȸ�� ���ڵ尡 ���� ���.
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
			return session.getMapper(MemberMapper.class).update(mem); // ���ڵ� ����� �� ���⼱ 0 �ƴϸ� 1��
		} catch (Exception e) { // �⺻���� �ۼ����� ���� �� �߻� �� SQL ������ �߸� ����
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0; 
	}
}

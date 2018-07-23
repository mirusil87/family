package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mapper.BoardMapper;
import mapper.PrivatMapper;

public class PrivatDao {
	private static final String ns = "mapper.PrivatMapper.";
	public int insert(Privat board) {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(PrivatMapper.class).insert(board);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
	public int maxNum() {
		SqlSession session = DBConnection.getConnection();
		try {
			int result = session.getMapper(PrivatMapper.class).maxNum();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
	public int boardCount(String family_num, String name) {
		SqlSession session = DBConnection.getConnection();
		try {
			Map map = new HashMap();
			map.put("name", name);
			map.put("family_num", family_num);
			return session.selectOne(ns+"boardCount",map); //현재 등록된 게시물 건수 리턴 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
	public List<Privat> list(int pageNum,int limit, String family_num, String name) {
		SqlSession session = DBConnection.getConnection();
		int startrow = (pageNum - 1) * limit;
		Map map = new HashMap();
		map.put("startrow", startrow);
		map.put("limit", limit);
		map.put("name", name);
		map.put("family_num", family_num);
		try {
			List<Privat> list = session.selectList(ns+"select",map);
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
		DBConnection.close(session);
		}
		return null;
	}
	public Privat selectOne(String num, String name, String family_num) {
		SqlSession session = DBConnection.getConnection();
		try {
			Map map = new HashMap();
			map.put("num",num);
			map.put("name", name);
			map.put("family_num", family_num);
			return session.selectOne(ns+"select",map);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return null;
	}
	public void addReadCnt(String num) {
		SqlSession session = DBConnection.getConnection();
		try {
			session.getMapper(PrivatMapper.class).addReadCnt(num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
	}
	
	public int update(Privat board) {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(PrivatMapper.class).update(board);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return 0;
	}
	public int delete(String num) {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(PrivatMapper.class).delete(num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return 0;
	}
}

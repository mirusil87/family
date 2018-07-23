package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mapper.BoardMapper;
import mapper.CalMapper;

public class CalDao {
	private static final String ns = "mapper.CalMapper.";
	public int insert(Cal cal) {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(CalMapper.class).insert(cal);
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
			int result = session.getMapper(CalMapper.class).maxNum();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
	public List<Cal> list(String family_num) {
		SqlSession session = DBConnection.getConnection();
		Map map = new HashMap();
		map.put("family_num", family_num);
		try {
			List<Cal> list = session.selectList(ns+"select",map);
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
		DBConnection.close(session);
		}
		return null;
	}
	public Cal selectOne(int num) {
		SqlSession session = DBConnection.getConnection();
		try {
			Map map = new HashMap();
			map.put("num",num);
			return session.selectOne(ns+"select",map);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return null;
	}
	public int update(Cal cal) {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(CalMapper.class).update(cal);
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
			return session.getMapper(BoardMapper.class).delete(num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return 0;
	}
}

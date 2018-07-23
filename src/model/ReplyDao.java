package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mapper.ReplyMapper;

public class ReplyDao {
	private static final String ns ="mapper.ReplyMapper.";
	
	public int insert(Reply reply) {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(ReplyMapper.class).insert(reply);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}

	public List<Reply> select(int bnum) {
		SqlSession session = DBConnection.getConnection();
		Map map = new HashMap();
		map.put("bnum", bnum);
		try {
			List <Reply> list1 = session.selectList(ns + "select", map);
			return list1;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null;
	}

	public int replycnt(int no) {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(ReplyMapper.class).replycnt(no);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}

	public int count(int no) {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(ReplyMapper.class).count(no);
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return 0;
	}

	public Reply select2(int bnum, int renum) {
		SqlSession session = DBConnection.getConnection();
		Map map = new HashMap();
		map.put("bnum", bnum);
		map.put("renum", renum);
		try {
			Reply reply = session.selectOne(ns+"select3", map);
			return reply;
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return null;
	}

	public int update(Reply reply) {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(ReplyMapper.class).update(reply);
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return 0;
	}
	public int deletereply(Reply reply) {
		SqlSession session = DBConnection.getConnection();

		try {
			return session.getMapper(ReplyMapper.class).deletereply(reply);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return 0;
	}
}
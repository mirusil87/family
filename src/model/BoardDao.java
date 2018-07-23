package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mapper.BoardMapper;

public class BoardDao {
	private static final String ns = "mapper.BoardMapper.";
	public int insert(Board board) {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(BoardMapper.class).insert(board);
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
			int result = session.getMapper(BoardMapper.class).maxNum();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
	public int boardCount(String column, String find, String family_num) {
		SqlSession session = DBConnection.getConnection();
		try {
			Map map = new HashMap();
			map.put("column", column);
			map.put("find", find);
			map.put("family_num", family_num);
			return session.selectOne(ns+"boardCount",map); //���� ��ϵ� �Խù� �Ǽ� ���� 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
	public List<Board> list(int pageNum,int limit, String column, String find, String family_num) {
		SqlSession session = DBConnection.getConnection();
		int startrow = (pageNum - 1) * limit;
		Map map = new HashMap();
		map.put("startrow", startrow);
		map.put("limit", limit);
		map.put("column", column);
		map.put("find", find);
		map.put("family_num", family_num);
		try {
			List<Board> list = session.selectList(ns+"select",map);
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
		DBConnection.close(session);
		}
		return null;
	}
	public Board selectOne(String num) {
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
	public void addReadCnt(String num) {
		SqlSession session = DBConnection.getConnection();
		try {
			session.getMapper(BoardMapper.class).addReadCnt(num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
	}
	public boolean reply(Board board) {
		//board �� ����� num�� �ִ밪 ����; 
		int num = this.maxNum();
		int ref = board.getRef();   //������ ref ��
		int reflevel = board.getReflevel();  //������ reflevel ��
		int refstep = board.getRefstep();    //������ refstep ��
		SqlSession session = DBConnection.getConnection();
		try {
			session.getMapper(BoardMapper.class).reply(board);
		}catch(Exception	e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		board.setRef(ref); //������ ref�� ���� ���ƾ� �ϹǷ� ���� �� �ʿ䰡 ���� ������ �ص� �ȴ�. 
		board.setReflevel(++reflevel);
		board.setRefstep(++refstep);
		board.setNum(++num);
		int result = this.insert(board);
		if(result > 0 )	
			return true;
		else 
			return false;
	}
	public int update(Board board) {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(BoardMapper.class).update(board);
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

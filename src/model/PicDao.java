package model;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class PicDao {
	private static final String ns="mapper.PicMapper.";
	public Pic selectOne(int familynum) { 
		SqlSession session = DBConnection.getConnection();
		try {
			Map map = new HashMap();
			map.put("familynum", familynum);
			return session.selectOne(ns+"select",map); // db�� id�� �ش��ϴ� member ���̺��� ���ڵ� ������ Bean��ü
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null; // ��ȸ�� ���ڵ尡 ���� ���.
	}
}

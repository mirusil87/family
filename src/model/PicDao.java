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
			return session.selectOne(ns+"select",map); // db의 id에 해당하는 member 테이블의 레코드 저장한 Bean객체
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null; // 조회된 레코드가 없는 경우.
	}
}

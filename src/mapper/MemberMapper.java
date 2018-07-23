package mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Member;

public interface MemberMapper {
	
	@Delete("delete from member where name=#{value}")
	int delete(String name);
	
	@Insert("insert into member (family_num, pass, name, relation, tel, address,birth)" 
			+ " values(#{family_num},#{pass},#{name},#{relation},#{tel},#{address},#{birth})")
	int insert(Member mem);
	
	@Update("update member set pass=#{pass}, relation=#{relation}, "
			+ "address=#{address}, tel=#{tel} where name=#{name}")
	int update(Member mem);

	
}

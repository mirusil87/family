package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Privat;

public interface PrivatMapper {

	@Insert("insert into private "
		+ "(num,name,subject,content,readcnt,regdate,family_num)"
		+ "values(#{num},#{name},#{subject},#{content}"
		+ ",#{readcnt},now(),#{family_num})")
	int insert(Privat board);

	@Select("select ifnull(max(num),0) from private")
	int maxNum();
	
	@Delete("delete from private where num=#{value}")
	int delete(String num);

	@Update("update private set name = #{name}, subject = #{subject}, content = #{content} "
			+ " where num = #{num}")
	int update(Privat board);
	
	@Update("update board set readcnt = readcnt + 1 where num = #{value}")
	void addReadCnt(String num);

}

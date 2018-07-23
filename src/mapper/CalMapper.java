package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Board;
import model.Cal;

public interface CalMapper {
	@Insert("insert into calendar "
			+ "(num,start_regdate,subject,end_regdate,color,family_num)"
			+ "values(#{num},#{start_regdate},#{subject},#{end_regdate}"
			+ ",#{color},#{family_num})")
		int insert(Cal cal);

	@Select("select ifnull(max(num),0) from calendar")
	int maxNum();
	
	@Update("update calendar set subject = #{subject}, color = #{color}, "
			+ "start_regdate = #{start_regdate}, end_regdate=#{end_regdate},"
			+ "family_num = #{family_num} where num = #{num}")
	int update(Cal cal);
	
	@Delete("delete from board where num=#{value}")
	int delete(String num);
}

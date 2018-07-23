package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Board;

public interface BoardMapper {

	@Insert("insert into board "
		+ "(num,name,pass,subject,content,file1,readcnt,ref,reflevel,refstep,regdate,family_num)"
		+ "values(#{num},#{name},#{pass},#{subject},#{content},#{file1},0"
		+ ",#{ref},#{reflevel},#{refstep},now(),#{family_num})")
	int insert(Board board);

	@Select("select ifnull(max(num),0) from board")
	int maxNum();
	
	@Delete("delete from board where num=#{value}")
	int delete(String num);

	@Update("update board set name = #{name}, subject = #{subject}, content = #{content}, "
			+ "file1 = #{file1} where num = #{num}")
	int update(Board board);
	
	@Update("update board set readcnt = readcnt + 1 where num = #{value}")
	void addReadCnt(String num);

	@Update("update board set refstep = refstep + 1"
			+ " where ref=#{ref} and refstep > #{refstep}")
	void reply(Board board);
	

}

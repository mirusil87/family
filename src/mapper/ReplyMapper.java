package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Reply;

public interface ReplyMapper {

	@Insert("insert into reply (renum, bnum, writer, content, regdate) values(#{renum}, #{bnum},#{writer},#{content},now()) ")
	int insert(Reply reply);

	@Delete("delete from reply where bnum = #{bnum}")
	void delete(int board_no);
	
	@Delete("delete from reply where writer=#{member_ID}")
	int deleteallreply(String member_ID);

	@Select("select count(*) from reply where bnum = #{bnum}")
	int replycnt(int no);
	
	@Select("select count(*) from reply where bnum=#{bnum}")
	int count(int board_no);

	@Update("update reply set content = #{content} where bnum=#{bnum} and renum=#{renum}")
	int update(Reply reply);

	@Delete("delete from reply where bnum=#{bnum} and renum=#{renum}")
	int deletereply(Reply reply);

}
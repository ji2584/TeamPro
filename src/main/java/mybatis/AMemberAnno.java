package mybatis;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Amem;

public interface AMemberAnno {
   @Insert("insert into amem values (#{id}, #{nickname},#{pass},#{name},#{tel},#{email},#{address},#{bank},#{account},#{numberid},#{adminchk})")
   int insertMember(Amem amem);

   @Select("select * from amem where id =#{id}")
   Amem oneMember(String id);

   @Update("update amem set name=#{name},tel=#{tel},email=#{email} where id =#{id}")
   int updateMember(Amem amem);

   @Delete("delete amem where id =#{id}")
   int deleteMember(String id);

   @Update("update amem set pass =#{pass} where id = #{id}")
   int passMember(Map map);

}
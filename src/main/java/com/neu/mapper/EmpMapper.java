package com.neu.mapper;

import com.neu.pojo.Attendrecord;
import com.neu.pojo.Staffsalary;
import com.neu.pojo.chidaoList;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select eid,reasontype,reason,money,createTime,changeTime from attendrecord where eid=#{eid}")
    List<Attendrecord> atlist(int eid);

    @Select("select id,typetype,reason,money,update_time from staffsalary where id = #{id}")
    List<Staffsalary> getSalaryList(int id);

    //获取考勤的奖惩总金额
    @Select("select sum(money) from attendrecord group by eid having eid=#{id}")
    float getmoney1(@Param("id") int id);

    @Insert("insert into attendrecord (eid,reasontype,reason,createTime) values(#{id},'3',#{reason},#{createTime}) ")
    int qingjia(@Param("id") Integer id, @Param("reason") String reason, @Param("createTime") LocalDateTime createTime);

    @Insert("insert into attendrecord (eid,reasontype,reason,createTime) values(#{id},'2',#{reason},#{createTime}) ")
    int jiaban(@Param("id") Integer id, @Param("reason") String reason, @Param("createTime") LocalDateTime createTime);

    @Insert("insert into attendrecord (eid,reasontype,reason,createTime) values(#{id},'4',#{reason},#{createTime}) ")
    int chidao(@Param("id") Integer id, @Param("reason") String reason, @Param("createTime") LocalDateTime createTime);

    @Insert("insert into attendrecord (eid,reasontype,createTime) values(#{id},'1',#{createTime}) ")
    int checkWork(@Param("id") Integer id, @Param("createTime") LocalDateTime createTime);

    @Update("update attendrecord set changeTime = #{changeTime} where eid = #{id} and createTime between #{beginTime} and #{endTime} ")
    int checkRest(@Param("id")Integer id,@Param("changeTime") LocalDateTime changeTime, @Param("beginTime") LocalDateTime beginTime,@Param("endTime") LocalDateTime endTime);

    @Select("select idid,eid,reason,createTime,changeTime from attendrecord where eid=#{id} order by createTime desc")
    List<chidaoList> getchidaoList(@Param("id") Integer id);

    @Update("update attendrecord set reason=#{reason} where idid=#{idid}")
    int postchidao(@Param("idid") Integer idid,@Param("reason")String reason);


}

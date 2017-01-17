package com.seeu.user.dao;

import com.seeu.user.model.UserInterest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserInterestMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_interest
     *
     * @mbggenerated Sat Jan 14 14:13:51 CST 2017
     */
    @Delete({
        "delete from user_interest",
        "where UID = #{UID,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer UID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_interest
     *
     * @mbggenerated Sat Jan 14 14:13:51 CST 2017
     */
    @Insert({
        "insert into user_interest (UID, label)",
        "values (#{UID,jdbcType=INTEGER}, #{label,jdbcType=LONGVARCHAR})"
    })
    int insert(UserInterest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_interest
     *
     * @mbggenerated Sat Jan 14 14:13:51 CST 2017
     */
    @InsertProvider(type=UserInterestSqlProvider.class, method="insertSelective")
    int insertSelective(UserInterest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_interest
     *
     * @mbggenerated Sat Jan 14 14:13:51 CST 2017
     */
    @Select({
        "select",
        "UID, label",
        "from user_interest",
        "where UID = #{UID,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="UID", property="UID", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="label", property="label", jdbcType=JdbcType.LONGVARCHAR)
    })
    UserInterest selectByPrimaryKey(Integer UID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_interest
     *
     * @mbggenerated Sat Jan 14 14:13:51 CST 2017
     */
    @UpdateProvider(type=UserInterestSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserInterest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_interest
     *
     * @mbggenerated Sat Jan 14 14:13:51 CST 2017
     */
    @Update({
        "update user_interest",
        "set label = #{label,jdbcType=LONGVARCHAR}",
        "where UID = #{UID,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(UserInterest record);
}
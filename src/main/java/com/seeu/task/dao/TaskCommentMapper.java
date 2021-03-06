package com.seeu.task.dao;

import com.seeu.task.model.TaskComment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface TaskCommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_comment
     *
     * @mbggenerated Thu Jan 19 04:28:43 CST 2017
     */
    @Delete({
        "delete from task_comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Delete({
            "delete from task_comment",
            "where id = #{id,jdbcType=INTEGER}",
            "and commentUID = #{commentUID,jdbcType=INTEGER}"
    })
    int deleteCommentByIDandUID(Integer id,Integer commentUID);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_comment
     *
     * @mbggenerated Thu Jan 19 04:28:43 CST 2017
     */
    @Insert({
        "insert into task_comment (id, TID, ",
        "commentUID, liker_num, ",
        "time, comment)",
        "values (#{id,jdbcType=INTEGER}, #{TID,jdbcType=INTEGER}, ",
        "#{commentUID,jdbcType=INTEGER}, #{liker_num,jdbcType=INTEGER}, ",
        "#{time,jdbcType=TIMESTAMP}, #{comment,jdbcType=LONGVARCHAR})"
    })
    int insert(TaskComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_comment
     *
     * @mbggenerated Thu Jan 19 04:28:43 CST 2017
     */
    @InsertProvider(type=TaskCommentSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertSelective(TaskComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_comment
     *
     * @mbggenerated Thu Jan 19 04:28:43 CST 2017
     */
    @Select({
        "select",
        "id, TID, commentUID, liker_num, time, comment",
        "from task_comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="TID", property="TID", jdbcType=JdbcType.INTEGER),
        @Result(column="commentUID", property="commentUID", jdbcType=JdbcType.INTEGER),
        @Result(column="liker_num", property="liker_num", jdbcType=JdbcType.INTEGER),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="comment", property="comment", jdbcType=JdbcType.LONGVARCHAR)
    })
    TaskComment selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_comment
     *
     * @mbggenerated Thu Jan 19 04:28:43 CST 2017
     */
    @UpdateProvider(type=TaskCommentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TaskComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_comment
     *
     * @mbggenerated Thu Jan 19 04:28:43 CST 2017
     */
    @Update({
        "update task_comment",
        "set TID = #{TID,jdbcType=INTEGER},",
          "commentUID = #{commentUID,jdbcType=INTEGER},",
          "liker_num = #{liker_num,jdbcType=INTEGER},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "comment = #{comment,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(TaskComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_comment
     *
     * @mbggenerated Thu Jan 19 04:28:43 CST 2017
     */
    @Update({
        "update task_comment",
        "set TID = #{TID,jdbcType=INTEGER},",
          "commentUID = #{commentUID,jdbcType=INTEGER},",
          "liker_num = #{liker_num,jdbcType=INTEGER},",
          "time = #{time,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TaskComment record);
}
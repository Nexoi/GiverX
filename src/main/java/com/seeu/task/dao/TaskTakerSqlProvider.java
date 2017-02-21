package com.seeu.task.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.seeu.task.model.TaskTaker;

public class TaskTakerSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_taker
     *
     * @mbggenerated Thu Jan 19 15:05:24 CST 2017
     */
    public String insertSelective(TaskTaker record) {
        BEGIN();
        INSERT_INTO("task_taker");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTID() != null) {
            VALUES("TID", "#{TID,jdbcType=INTEGER}");
        }
        
        if (record.getTakerUID() != null) {
            VALUES("takerUID", "#{takerUID,jdbcType=INTEGER}");
        }
        
        if (record.getRole() != null) {
            VALUES("role", "#{role,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_taker
     *
     * @mbggenerated Thu Jan 19 15:05:24 CST 2017
     */
    public String updateByPrimaryKeySelective(TaskTaker record) {
        BEGIN();
        UPDATE("task_taker");
        
        if (record.getTID() != null) {
            SET("TID = #{TID,jdbcType=INTEGER}");
        }
        
        if (record.getTakerUID() != null) {
            SET("takerUID = #{takerUID,jdbcType=INTEGER}");
        }
        
        if (record.getRole() != null) {
            SET("role = #{role,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}
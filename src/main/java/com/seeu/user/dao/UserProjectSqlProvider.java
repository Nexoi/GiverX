package com.seeu.user.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.seeu.user.model.UserProjectWithBLOBs;

public class UserProjectSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_proj
     *
     * @mbggenerated Wed Jan 18 15:24:24 CST 2017
     */
    public String insertSelective(UserProjectWithBLOBs record) {
        BEGIN();
        INSERT_INTO("user_proj");
        
        if (record.getRecordID() != null) {
            VALUES("recordID", "#{recordID,jdbcType=INTEGER}");
        }
        
        if (record.getUID() != null) {
            VALUES("UID", "#{UID,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getRole() != null) {
            VALUES("role", "#{role,jdbcType=VARCHAR}");
        }
        
        if (record.getTime_start() != null) {
            VALUES("time_start", "#{time_start,jdbcType=VARCHAR}");
        }
        
        if (record.getTime_end() != null) {
            VALUES("time_end", "#{time_end,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            VALUES("note", "#{note,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getPictures() != null) {
            VALUES("pictures", "#{pictures,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getPerformance() != null) {
            VALUES("performance", "#{performance,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_proj
     *
     * @mbggenerated Wed Jan 18 15:24:24 CST 2017
     */
    public String updateByPrimaryKeySelective(UserProjectWithBLOBs record) {
        BEGIN();
        UPDATE("user_proj");
        
        if (record.getUID() != null) {
            SET("UID = #{UID,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getRole() != null) {
            SET("role = #{role,jdbcType=VARCHAR}");
        }
        
        if (record.getTime_start() != null) {
            SET("time_start = #{time_start,jdbcType=VARCHAR}");
        }
        
        if (record.getTime_end() != null) {
            SET("time_end = #{time_end,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            SET("note = #{note,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getPictures() != null) {
            SET("pictures = #{pictures,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getPerformance() != null) {
            SET("performance = #{performance,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("recordID = #{recordID,jdbcType=INTEGER}");
        
        return SQL();
    }
}
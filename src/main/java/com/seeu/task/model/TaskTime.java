package com.seeu.task.model;

import java.util.Date;

public class TaskTime {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_time.TID
     *
     * @mbggenerated Wed Jan 18 05:06:10 CST 2017
     */
    private Integer TID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_time.start
     *
     * @mbggenerated Wed Jan 18 05:06:10 CST 2017
     */
    private Date start;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_time.end
     *
     * @mbggenerated Wed Jan 18 05:06:10 CST 2017
     */
    private Date end;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_time.TID
     *
     * @return the value of task_time.TID
     *
     * @mbggenerated Wed Jan 18 05:06:10 CST 2017
     */
    public Integer getTID() {
        return TID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_time.TID
     *
     * @param TID the value for task_time.TID
     *
     * @mbggenerated Wed Jan 18 05:06:10 CST 2017
     */
    public void setTID(Integer TID) {
        this.TID = TID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_time.start
     *
     * @return the value of task_time.start
     *
     * @mbggenerated Wed Jan 18 05:06:10 CST 2017
     */
    public Date getStart() {
        return start;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_time.start
     *
     * @param start the value for task_time.start
     *
     * @mbggenerated Wed Jan 18 05:06:10 CST 2017
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_time.end
     *
     * @return the value of task_time.end
     *
     * @mbggenerated Wed Jan 18 05:06:10 CST 2017
     */
    public Date getEnd() {
        return end;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_time.end
     *
     * @param end the value for task_time.end
     *
     * @mbggenerated Wed Jan 18 05:06:10 CST 2017
     */
    public void setEnd(Date end) {
        this.end = end;
    }
}
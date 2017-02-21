package com.seeu.task.service;

import com.TP;
import com.TurnBackUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.seeu.task.dao.TaskBasicMapper;
import com.seeu.task.model.TaskBasic;
import com.seeu.task.model.TaskBasicWithBLOBs;
import com.seeu.user.dao.UserBasicMapper;
import com.seeu.user.model.UserBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by neo on 19/01/2017.
 */

/**
 * 返回该用户可寻到的所有 task 纪录，分页: 13 or 7 条/页
 * <p>
 * 操作都直接写在对应的 Mapper SQL 映射里面了。
 * <p>
 * <p>
 * 当前筛选规则：
 * <p>
 * 直接读表查询所有记录
 * <p>
 * 改进方向：
 * 1. 根据用户关注情况查询
 * 2. 根据地域查询
 * 3. 根据用户兴趣查询
 */
@Service
public class QueryTaskService {

    @Autowired
    TaskBasicMapper taskBasicMapper;
    @Autowired
    UserBasicMapper userBasicMapper;
    @Autowired
    TurnBackUtil turnBackUtil;


    /**
     * @param TID
     * @return
     */
    public String queryByTID(Integer TID) {
        if (TID == null)
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "请输入 TID", null);
        TaskBasicWithBLOBs task = taskBasicMapper.selectByPrimaryKey(TID);
        if (task != null)
            return turnBackUtil.formIt(TP.RESCODE_TASKQUERY_SUCCESS_NOCLEAN, "详情信息查询成功", reformTask(task));
        else
            return turnBackUtil.formIt(TP.RESCODE_TASKQUERY_NOSUCHTASK, "无此任务信息", null);
    }


    /**
     * 加载更多：
     * 加载 TID 大于 currentTID 的记录
     */
    public String queryMoreOldByUID(Integer UID, Integer currentTID) {
        int limit = 7;
        List<TaskBasicWithBLOBs> tasks = taskBasicMapper.selectByPrimaryKeyMoreOld(currentTID, limit);
        if (tasks == null || tasks.size() == 0)
            return turnBackUtil.formIt(TP.RESCODE_TASKQUERY_NONEEDMORE, "没有更多的任务了", null);
        else
            return turnBackUtil.formIt(TP.RESCODE_TASKQUERY_SUCCESS_NOCLEAN, "查询成功，请将该数据与本地原有数据拼接", reformWithUserInfo(tasks));
    }

    /**
     * 加载最新：
     * 从 fromTID 加载是不行滴～
     * <p>
     * 默认加载 13 条，如果加载未满 13 条，则返回记录并提示: 和以前的数据可以连接在一起
     * 如果 加载足够有 13 条，则返回记录并提示: 清空以前的数据
     * <p>
     * 正确姿势：
     * 1. 根据条件（地点时间等）访问最新记录
     * 2. 加载到 TID == fromTID 的时候，停止加载，返回数据（不返回当前fromTID的数据）
     * <p>
     * （ TID是可以大小比较的～所以还ok啦。。）
     */
    // 返回的数据每条都要加上发布者用户信息（UID、icon、name）, 用户点击头像即可进入个人名片
    public String queryNewFromWhichTID(Integer UID, Integer fromTID) {
        int limit = 13;
        List<TaskBasicWithBLOBs> tasks = taskBasicMapper.selectByPrimaryKeyMoreNew(fromTID, limit);
        if (tasks == null || tasks.size() == 0)
            return turnBackUtil.formIt(TP.RESCODE_TASKQUERY_NONEEDMORE, "没有更多的任务了", null);
        if (tasks.size() >= limit) {
            return turnBackUtil.formIt(TP.RESCODE_TASKQUERY_SUCCESS_CLEAN, "查询成功，请将本地缓存清空，并更新为该数据", reformWithUserInfo(tasks));
        } else {
            return turnBackUtil.formIt(TP.RESCODE_TASKQUERY_SUCCESS_NOCLEAN, "查询成功，请将该数据与本地原有数据拼接", reformWithUserInfo(tasks));
        }
    }

    private JSONArray reformWithUserInfo(List<TaskBasicWithBLOBs> tasks) {
        JSONArray ja = new JSONArray();
        for (TaskBasicWithBLOBs task : tasks) {
            ja.add(reformTask(task));
        }
        return ja;
    }

    private JSONObject reformTask(TaskBasicWithBLOBs task) {
        Integer UID = task.getUID();
        JSONObject jo = new JSONObject();
        jo.put("TID", task.getTID());
        jo.put("title", task.getTitle());
        jo.put("tag", task.getTag());
        jo.put("time", task.getTime());
        jo.put("like_num", task.getLiker_num());
        jo.put("read_num", task.getRead_num());
        jo.put("comment_num", task.getComment_num());
        jo.put("status", task.getStatus());
        jo.put("money", task.getMoney());
        jo.put("note", task.getNote());
        jo.put("pictures", JSONArray.parse(task.getPictures()));
        jo.put("UID", UID);
        UserBasic user = userBasicMapper.selectPureByPrimaryKey(UID);
        if (user != null) {
            jo.put("user_name", user.getName());
            jo.put("user_icon", user.getIcon());
            jo.put("user_gender", user.getGender());
            jo.put("user_sign", user.getSign());
        }
        return jo;
    }
}

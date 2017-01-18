package com.seeu.user.service;

import com.TP;
import com.TurnBackUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.seeu.user.dao.*;
import com.seeu.user.model.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by neo on 14/01/2017.
 */
@Service
public class UserLoadInfoService {
    private static final Logger logger = LogManager.getLogger(UserLoadInfoService.class);
    @Autowired
    TurnBackUtil turnBackUtil;

    @Autowired
    UserBasicMapper userBasicMapper;

    @Autowired
    UserBusinessMapper userBusinessMapper;

    @Autowired
    UserEducationMapper userEducationMapper;

    @Autowired
    UserInterestMapper userInterestMapper;

    @Autowired
    UserRealProfileMapper userRealProfileMapper;

    @Autowired
    UserSocialNetMapper userSocialNetMapper;

    @Autowired
    UserProjectMapper userProjectMapper;

    public String getmyBasic(Integer UID) {
        UserBasic user = userBasicMapper.selectByPrimaryKey(UID);
        if (user == null)
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "无此用户信息", null);
        Object json = JSONObject.toJSON(user);
//        logger.info("Request UserBascInfo UID : " + UID);
        return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "获取个人基本信息成功", json);
    }

    public String getmyBusiness(Integer UID) {
        List<UserBusiness> list = userBusinessMapper.selectByUID(UID);
        if (list == null || list.size() == 0)
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "无工作信息", null);
        JSONArray ja = new JSONArray();
        for (UserBusiness user : list) {
            Object json = JSONObject.toJSON(user);
            ja.add(json);
        }
        return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "获取个人工作信息成功", ja);
    }

    public String getmyEducation(Integer UID) {
        List<UserEducation> list = userEducationMapper.selectByUID(UID);
        if (list == null || list.size() == 0)
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "无教育信息", null);
        JSONArray ja = new JSONArray();
        for (UserEducation user : list) {
            Object json = JSONObject.toJSON(user);
            ja.add(json);
        }
//        logger.info("Request UserBascInfo UID : " + UID);
        return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "获取个人教育信息成功", ja);
    }

    public String getmyInterest(Integer UID) {
        UserInterest user = userInterestMapper.selectByPrimaryKey(UID);
        if (user == null)
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "无兴趣标签信息", null);
        Object json = JSONObject.toJSON(user);
//        logger.info("Request UserBascInfo UID : " + UID);
        return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "获取个人兴趣信息成功", json);
    }

    public String getmyRealProfile(Integer UID) {
        UserRealProfile user = userRealProfileMapper.selectByPrimaryKey(UID);
        if (user == null)
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "无此用户信息", null);
        Object json = JSONObject.toJSON(user);
//        logger.info("Request UserBascInfo UID : " + UID);
        return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "获取个人真实信息成功", json);
    }

    public String getmySocialNet(Integer UID) {
        UserSocialNet user = userSocialNetMapper.selectByPrimaryKey(UID);
        if (user == null)
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "无社交帐号信息", null);
        Object json = JSONObject.toJSON(user);
//        logger.info("Request UserBascInfo UID : " + UID);
        return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "获取个人社交帐号信息成功", json);
    }

    public String getMyProject(Integer UID) {
        List<UserProjectWithBLOBs> list = userProjectMapper.selectByUID(UID);
        if (list != null && list.size() != 0) {
            JSONArray ja = new JSONArray();
            for (UserProjectWithBLOBs userProject : list) {
                JSONObject jo = new JSONObject();
                jo.put("recordID", userProject.getRecordID());
                jo.put("UID", userProject.getUID());
                jo.put("type", userProject.getType());
                jo.put("title", userProject.getTitle());
                jo.put("url", userProject.getUrl());
                jo.put("role", userProject.getRole());
                jo.put("time_start", userProject.getTime_start());
                jo.put("time_end", userProject.getTime_end());
                jo.put("note", userProject.getNote());
                jo.put("performance", userProject.getPerformance());
                jo.put("pictures", JSONArray.parse(userProject.getPictures()));
                ja.add(jo);
            }
            return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "获取个人项目信息成功", ja);
        } else
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "无项目经验信息", null);
    }
}

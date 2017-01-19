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

/**
 * Created by neo on 17/01/2017.
 */
@Service
public class UpdateUserInfoService {
    private static final Logger logger = LogManager.getLogger(UpdateUserInfoService.class);

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

    @Autowired
    TurnBackUtil turnBackUtil;


    /**
     * @未来这些操作方式可以更新改进
     */
    public String updateMyBusiness(UserBusiness user, Integer UID) {
        if (user.getRecordID() == null) {
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "更新失败，请确认 recordID 是否正确", null);
        }
        try {
            // 必须要有 recordID
            user.setUID(UID);
            userBusinessMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "更新失败，请勿重复更新", null);
        }
        try {
            UserBusiness userBusiness = userBusinessMapper.selectByPrimaryKey(UID);
            if (userBusiness != null) {
                Object jo = JSONObject.toJSON(userBusiness);
                return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "更新成功", jo);// 返回更新后的信息
            } else
                return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "无此用户数据可更新", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "更新失败", null);
        }
    }

    public String updateMyEducation(UserEducation user, Integer UID) {
        if (user.getRecordID() == null) {
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "更新失败，请确认 recordID 是否正确", null);
        }
        try {
            user.setUID(UID);
            userEducationMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "更新失败，请勿重复更新", null);
        }
        try {
            UserEducation userEducation = userEducationMapper.selectByPrimaryKey(UID);
            if (userEducation != null) {
                Object jo = JSONObject.toJSON(userEducation);
                return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "更新成功", jo);// 返回更新后的信息
            } else
                return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "无此用户数据可更新", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "更新失败", null);
        }
    }

    public String updateMyProject(UserProjectWithBLOBs user, Integer UID) {
        if (user.getRecordID() == null) {
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "更新失败，请确认 recordID 是否正确", null);
        }
        try {
            if (!isPicturesNameAvaliable(user.getPictures()))
                return turnBackUtil.formIt(TP.RESCODE_FAILURE, "更新失败，请检查图片格式是否正确", null);
            user.setUID(UID);
            userProjectMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "更新失败，请勿重复更新", null);
        }
        try {
            UserProjectWithBLOBs userProject = userProjectMapper.selectByPrimaryKey(UID);
            if (userProject != null) {
                Object jo = JSONObject.toJSON(userProject);
                return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "更新成功", jo);// 返回更新后的信息
            } else
                return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "无此用户数据可更新", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "更新失败", null);
        }
    }

    private boolean isPicturesNameAvaliable(String pictures) {
        if (pictures == null) return true;
        try {
            Object jsonArray = JSONArray.parse(pictures);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String updateMyInterest(UserInterest user, Integer UID) {
        try {
            user.setUID(UID);
            userInterestMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "更新失败，请勿重复更新", null);
        }
        try {
            UserInterest userInterest = userInterestMapper.selectByPrimaryKey(UID);
            if (userInterest != null) {
                Object jo = JSONObject.toJSON(userInterest);
                return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "更新成功", jo);// 返回更新后的信息
            } else
                return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "无此用户数据可更新", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "更新失败", null);
        }
    }

    public String updateMyRealProfile(UserRealProfile user, Integer UID) {
        try {
            user.setUID(UID);
            userRealProfileMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "更新失败，请勿重复更新", null);
        }
        try {
            UserRealProfile userRealProfile = userRealProfileMapper.selectByPrimaryKey(UID);
            if (userRealProfile != null) {
                Object jo = JSONObject.toJSON(userRealProfile);
                return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "更新成功", jo);// 返回更新后的信息
            } else
                return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "无此用户数据可更新", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "更新失败", null);
        }
    }

    public String updateMySocialNet(UserSocialNet user, Integer UID) {
        try {
            user.setUID(UID);
            userSocialNetMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "更新失败，请勿重复更新", null);
        }
        try {
            UserSocialNet userSocialNet = userSocialNetMapper.selectByPrimaryKey(UID);
            if (userSocialNet != null) {
                Object jo = JSONObject.toJSON(userSocialNet);
                return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "更新成功", jo);// 返回更新后的信息
            } else
                return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "无此用户数据可更新", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "更新失败", null);
        }
    }

}

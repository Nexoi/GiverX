package com.seeu.user.service;

import com.TP;
import com.TurnBackUtil;
import com.seeu.user.dao.UserBusinessMapper;
import com.seeu.user.dao.UserEducationMapper;
import com.seeu.user.model.UserBusiness;
import com.seeu.user.model.UserEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by neo on 17/01/2017.
 */
@Service
public class AddRecordInfoService {
    @Autowired
    UserBusinessMapper userBusinessMapper;
    @Autowired
    UserEducationMapper userEducationMapper;
    @Autowired
    TurnBackUtil turnBackUtil;

    public String addBusiness(UserBusiness userBusiness) {
        if (userBusiness != null) {
            userBusinessMapper.insertSelective(userBusiness);
            return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "添加成功", null);
        } else
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "添加失败", null);
    }


    public String addEducation(UserEducation userEducation) {
        if (userEducation != null) {
            userEducationMapper.insertSelective(userEducation);
            return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "添加成功", null);
        } else
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "添加失败", null);
    }

}

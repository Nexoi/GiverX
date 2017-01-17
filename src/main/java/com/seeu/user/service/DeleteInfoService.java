package com.seeu.user.service;

import com.TP;
import com.TurnBackUtil;
import com.seeu.user.dao.UserBusinessMapper;
import com.seeu.user.dao.UserEducationMapper;
import com.seeu.user.model.UserBusiness;
import com.seeu.user.model.UserEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by neo on 18/01/2017.
 */
@Service
public class DeleteInfoService {
    @Autowired
    UserBusinessMapper userBusinessMapper;
    @Autowired
    UserEducationMapper userEducationMapper;
    @Autowired
    TurnBackUtil turnBackUtil;

    public String delBusiness(Integer recordID, Integer UID) {
        List<UserBusiness> list = userBusinessMapper.selectByUID(UID);
        for (UserBusiness business : list) {
            int rec = business.getRecordID();
            if (rec == recordID) {
                userBusinessMapper.deleteByPrimaryKey(recordID);
                return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "删除成功", null);
            }
        }
        return turnBackUtil.formIt(TP.RESCODE_FAILURE, "删除失败", null);
    }


    public String delEducation(Integer recordID, Integer UID) {
        List<UserEducation> list = userEducationMapper.selectByUID(UID);
        for (UserEducation education : list) {
            int rec = education.getRecordID();
            if (rec == recordID) {
                userEducationMapper.deleteByPrimaryKey(recordID);
                return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "删除成功", null);
            }
        }
        return turnBackUtil.formIt(TP.RESCODE_FAILURE, "删除失败", null);
    }

}

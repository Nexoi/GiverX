package com.seeu.user.service;

import com.TP;
import com.TurnBackUtil;
import com.seeu.user.dao.UserBusinessMapper;
import com.seeu.user.dao.UserEducationMapper;
import com.seeu.user.dao.UserProjectMapper;
import com.seeu.user.model.UserBusiness;
import com.seeu.user.model.UserEducation;
import com.seeu.user.model.UserProject;
import com.seeu.user.model.UserProjectWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by neo on 18/01/2017.
 *
 * 可以对SQL进行调优，优化下面的方法结构。
 */
@Service
public class DeleteInfoService {
    @Autowired
    UserBusinessMapper userBusinessMapper;
    @Autowired
    UserEducationMapper userEducationMapper;
    @Autowired
    UserProjectMapper userProjectMapper;
    @Autowired
    TurnBackUtil turnBackUtil;

    /**
     * @param recordID
     * @param UID
     * @return
     */
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
    public String delProject(Integer recordID, Integer UID) {
        List<UserProjectWithBLOBs> list = userProjectMapper.selectByUID(UID);
        for (UserProjectWithBLOBs project : list) {
            int rec = project.getRecordID();
            if (rec == recordID) {
                userProjectMapper.deleteByPrimaryKey(recordID);
                return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "删除成功", null);
            }
        }
        return turnBackUtil.formIt(TP.RESCODE_FAILURE, "删除失败", null);
    }

}

package com.seeu.user.service;

import com.TP;
import com.TurnBackUtil;
import com.alibaba.fastjson.JSONObject;
import com.seeu.filesystem.service.FileUploadService;
import com.seeu.user.dao.UserBasicMapper;
import com.seeu.user.model.UserBasic;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by neo on 14/01/2017.
 */
@Service
public class UpdateUserBasicService {
    private static final Logger logger = LogManager.getLogger(UpdateUserBasicService.class);

    @Autowired
    UserBasicMapper userBasicMapper;

    @Autowired
    FileUploadService fileUploadService;

    @Autowired
    TurnBackUtil turnBackUtil;


    public String updateMyIcon(MultipartFile icon, Integer UID) {
        String iconResult = null;
        if (icon != null) {
            // 更新头像
            String mypath = TP.PATH_USERHEAD + "/" + UID;
            String mytype = ".png";
            iconResult = fileUploadService.upload(icon, mytype, mypath);
        }
        try {
            UserBasic basic = new UserBasic();
            basic.setUID(UID);
            basic.setIcon(iconResult);
            userBasicMapper.updateByPrimaryKeySelective(basic);
            JSONObject jo = new JSONObject();
            jo.put("icon", iconResult);
            return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "更新成功", jo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "无此用户数据可更新", null);
        }
    }

    /**
     * @param basic basic info (POJO)
     * @return
     */
    public String updateMyBasic(UserBasic basic, Integer UID) {
        try {
            basic.setUID(UID);
            basic.setIcon(null);
            userBasicMapper.updateByPrimaryKeySelective(basic);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "更新失败，请勿重复更新", null);
        }
        try {
            UserBasic userBasic = userBasicMapper.selectByPrimaryKey(UID);
            if (userBasic != null) {
                Object jsonbasic = JSONObject.toJSON(userBasic);
                return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "更新成功", jsonbasic);// 返回更新后的信息
            } else
                return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "无此用户数据可更新", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "更新失败", null);
        }
    }

}

package com.seeu.user.service;

import com.TP;
import com.TurnBackUtil;
import com.alibaba.fastjson.JSONArray;
import com.seeu.filesystem.service.FileUploadService;
import com.seeu.filesystem.service.StorageProperties;
import com.seeu.user.dao.UserBusinessMapper;
import com.seeu.user.dao.UserEducationMapper;
import com.seeu.user.dao.UserProjectMapper;
import com.seeu.user.model.UserBusiness;
import com.seeu.user.model.UserEducation;
import com.seeu.user.model.UserProjectWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;


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
    UserProjectMapper userProjectMapper;
    @Autowired
    FileUploadService fileUploadService;
    @Autowired
    TurnBackUtil turnBackUtil;

    private final Path userprojectPath;

    public AddRecordInfoService(StorageProperties properties) {
        this.userprojectPath = Paths.get(properties.getUserproject());
    }

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


    public String addProject(UserProjectWithBLOBs project, Integer UID) {
        if (project != null) {
            project.setUID(UID);
            // 检验pictures是否为JSONArray格式
            String pics = project.getPictures();
            if (!isPicturesNameAvaliable(pics))
                return turnBackUtil.formIt(TP.RESCODE_FAILURE, "添加失败，图片格式不合法", null);
            userProjectMapper.insertSelective(project);
            return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "添加成功", null);
        } else
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "添加失败", null);
    }

    public String addProjectPicture(MultipartFile picture, Integer UID) {
        String pictureResult = null;
        if (picture != null) {
            // 存储图片
            Path mypath = userprojectPath.resolve(UID.toString());
            String mytype = ".png";
            pictureResult = fileUploadService.upload(picture, mytype, mypath);
        }
        if (pictureResult == null)
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "图片上传失败", null);
        else return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "图片上传成功", pictureResult);
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
}

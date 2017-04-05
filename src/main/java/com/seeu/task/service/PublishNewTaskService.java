package com.seeu.task.service;

import com.TP;
import com.TurnBackUtil;
import com.alibaba.fastjson.JSONArray;
import com.seeu.filesystem.service2.FileUploadService;
import com.seeu.filesystem.service2.StorageProperties;
import com.seeu.task.dao.TaskBasicMapper;
import com.seeu.task.dao.TaskLocationMapper;
import com.seeu.task.dao.TaskTimeMapper;
import com.seeu.task.model.TaskBasicWithBLOBs;
import com.seeu.task.model.TaskLocation;
import com.seeu.task.model.TaskTime;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by neo on 18/01/2017.
 */
@Service
public class PublishNewTaskService {
    private static final Logger logger = LogManager.getLogger(PublishNewTaskService.class);
    @Autowired
    TurnBackUtil turnBackUtil;
    @Autowired
    TaskLocationMapper taskLocationMapper;
    @Autowired
    TaskBasicMapper taskBasicMapper;
    @Autowired
    TaskTimeMapper taskTimeMapper;

    @Autowired
    FileUploadService fileUploadService;

    final Path taskpicturePath;

    public PublishNewTaskService(StorageProperties properties) {
        this.taskpicturePath = Paths.get(properties.getLocation());//原来是getTask()
    }

    public String publishNewTask(Integer UID, TaskBasicWithBLOBs basic, TaskTime time, TaskLocation location) {
        if (basic == null)
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "请填写任务信息再提交", null);
        basic.setUID(UID);
        try {
            if (!isPicturesNameAvaliable(basic.getPictures()))
                return turnBackUtil.formIt(TP.RESCODE_FAILURE, "发布失败，请检查图片格式是否正确", null);
            // basic.Time 会自动被设置为当前时间
            basic.setStatus(TP.TASK_STATUS_BIDDING);// 任务当前状态设置为竞标中
            Integer TID = taskBasicMapper.insert(basic);
            time.setTID(TID);
            location.setTID(TID);
            return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "发布成功", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "任务提交异常", null);
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


    public String uploadPicture(MultipartFile picture, Integer UID) {
        return fileUploadService.upload(picture, ".png", taskpicturePath.resolve(UID.toString()));
    }
}

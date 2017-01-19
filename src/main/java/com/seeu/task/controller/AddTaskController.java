package com.seeu.task.controller;

import com.TP;
import com.TurnBackUtil;
import com.seeu.filesystem.service.FileUploadService;
import com.seeu.task.model.TaskBasic;
import com.seeu.task.model.TaskBasicWithBLOBs;
import com.seeu.task.model.TaskLocation;
import com.seeu.task.model.TaskTime;
import com.seeu.task.service.PublishNewTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by neo on 18/01/2017.
 */
@RestController
@RequestMapping("task")
public class AddTaskController {
    @Autowired
    PublishNewTaskService publishNewTaskService;
    @Autowired
    TurnBackUtil turnBackUtil;

    @RequestMapping("add")
    public String addTaskAll(@RequestAttribute("UID") Integer UID, @ModelAttribute TaskBasicWithBLOBs basic, @ModelAttribute TaskTime time, @ModelAttribute TaskLocation location) {
        if (basic == null || (basic.getNote() == null && basic.getTitle() == null))
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "提交失败，信息不完整", null);
        basic.setUID(UID);
        return publishNewTaskService.publishNewTask(UID, basic, time, location);
    }

    @RequestMapping("addpicture")
    public String addPicture(@RequestAttribute("UID") Integer UID, @RequestParam(value = "picture", required = false) MultipartFile picture) {
        // 仅仅增加至disk，不会同步到数据库（因为数据库现在还没有这条任务被创建啊～）（这是任务创建时，用户上传图片的操作）
        return publishNewTaskService.uploadPicture(picture, UID);
    }
}

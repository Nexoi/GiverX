package com.seeu.user.controller;

import com.seeu.user.model.UserBusiness;
import com.seeu.user.model.UserEducation;
import com.seeu.user.model.UserProject;
import com.seeu.user.model.UserProjectWithBLOBs;
import com.seeu.user.service.AddRecordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by neo on 18/01/2017.
 */
@RestController
@RequestMapping("user/add")
public class UserAddInfoController {
    @Autowired
    AddRecordInfoService addRecordInfoService;

    @RequestMapping("projectpic")
    public String addPicture(@RequestParam(value = "picture", required = false) MultipartFile picture, @RequestAttribute("UID") Integer UID) {
        return addRecordInfoService.addProjectPicture(picture, UID);
    }

    @RequestMapping("project")
    public String addProject(@ModelAttribute UserProjectWithBLOBs project, @RequestAttribute("UID") Integer UID){
        return addRecordInfoService.addProject(project,UID);
    }
    @RequestMapping("education")
    public String addEducation(@ModelAttribute UserEducation education, @RequestAttribute("UID") Integer UID) {
        education.setUID(UID);
        return addRecordInfoService.addEducation(education);
    }

    @RequestMapping("business")
    public String addBusiness(@ModelAttribute UserBusiness business, @RequestAttribute("UID") Integer UID) {
        business.setUID(UID);
        return addRecordInfoService.addBusiness(business);
    }
}

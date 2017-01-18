package com.seeu.user.controller;

import com.seeu.user.model.UserBusiness;
import com.seeu.user.model.UserEducation;
import com.seeu.user.service.DeleteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by neo on 18/01/2017.
 */
@RestController
@RequestMapping("user/delete")
public class UserDeleteInfoController {

    @Autowired
    DeleteInfoService deleteInfoService;

    @RequestMapping("education")
    public String delEducation(@RequestParam("recordID") Integer recordID, @RequestAttribute("UID") Integer UID) {
        return deleteInfoService.delEducation(recordID, UID);
    }

    @RequestMapping("business")
    public String delBusiness(@RequestParam("recordID") Integer recordID, @RequestAttribute("UID") Integer UID) {
        return deleteInfoService.delBusiness(recordID, UID);
    }
    @RequestMapping("project")
    public String delProject(@RequestParam("recordID") Integer recordID, @RequestAttribute("UID") Integer UID) {
        return deleteInfoService.delBusiness(recordID, UID);
    }
}

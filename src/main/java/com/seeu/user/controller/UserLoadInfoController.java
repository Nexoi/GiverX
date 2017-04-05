package com.seeu.user.controller;

import com.TP;
import com.TurnBackUtil;
import com.seeu.userOAuth.db.model.LoginUser;
import com.seeu.userOAuth.service.UserFromToken;
import com.seeu.user.service.UserLoadInfoService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by neo on 14/01/2017.
 */
@RestController
@RequestMapping("user/load")
public class UserLoadInfoController {
    private static final Logger logger = LogManager.getLogger(UserLoadInfoController.class);
    @Autowired
    TurnBackUtil turnBackUtil;

    @Autowired
    UserLoadInfoService userInfoService;

    @Autowired
    UserFromToken userFromToken;


    @RequestMapping(value = "basicinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String loadBasicInfo(@RequestAttribute("UID") Integer UID) {
//        LoginUser user = userFromToken.parseToken(token);
//        if (user == null) {
//            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无权访问", null);
//        }
        // do next :
        return userInfoService.getmyBasic(UID);
    }

    @RequestMapping(value = "businessinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String loadBusinessInfo(@RequestAttribute("UID") Integer UID) {
//        LoginUser user = userFromToken.parseToken(token);
//        if (user == null) {
//            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无权访问", null);
//        }
        // do next :
        return userInfoService.getmyBusiness(UID);
    }

    @RequestMapping(value = "educationinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String loadEducationInfo(@RequestAttribute("UID") Integer UID) {
//        LoginUser user = userFromToken.parseToken(token);
//        if (user == null) {
//            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无权访问", null);
//        }
        // do next :
        return userInfoService.getmyEducation(UID);
    }

    @RequestMapping(value = "interestinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String loadInterestInfo(@RequestAttribute("UID") Integer UID) {
//        LoginUser user = userFromToken.parseToken(token);
//        if (user == null) {
//            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无权访问", null);
//        }
        // do next :
        return userInfoService.getmyInterest(UID);
    }

    @RequestMapping(value = "profileinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String loadRealInfo(@RequestAttribute("UID") Integer UID) {
//        LoginUser user = userFromToken.parseToken(token);
//        if (user == null) {
//            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无权访问", null);
//        }
        // do next :
        return userInfoService.getmyRealProfile(UID);
    }

    @RequestMapping(value = "socialinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String loadSocialNetInfo(@RequestAttribute("UID") Integer UID) {
//        LoginUser user = userFromToken.parseToken(token);
//        if (user == null) {
//            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无权访问", null);
//        }
        // do next :
        return userInfoService.getmySocialNet(UID);
    }

    @RequestMapping(value = "projectinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String loadProjectInfo(@RequestAttribute("UID") Integer UID) {
        return userInfoService.getMyProject(UID);
    }
}

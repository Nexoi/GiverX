package com.seeu.user.controller;

import com.TP;
import com.TurnBackUtil;
import com.seeu.userOAuth.db.model.LoginUser;
import com.seeu.userOAuth.service.UserFromToken;
import com.seeu.user.service.UserLoadInfoService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping(value = "mybasicinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String loadBasicInfo(@RequestParam("token") String token) {
        LoginUser user = userFromToken.parseToken(token);
        if (user == null) {
            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无权访问", null);
        }
        // do next :
        return userInfoService.getmyBasic(user.getUID());
    }

    @RequestMapping(value = "mybusinessinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String loadBusinessInfo(@RequestParam("token") String token) {
        LoginUser user = userFromToken.parseToken(token);
        if (user == null) {
            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无权访问", null);
        }
        // do next :
        return userInfoService.getmyBusiness(user.getUID());
    }

    @RequestMapping(value = "myeducationinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String loadEducationInfo(@RequestParam("token") String token) {
        LoginUser user = userFromToken.parseToken(token);
        if (user == null) {
            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无权访问", null);
        }
        // do next :
        return userInfoService.getmyEducation(user.getUID());
    }

    @RequestMapping(value = "myinterestinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String loadInterestInfo(@RequestParam("token") String token) {
        LoginUser user = userFromToken.parseToken(token);
        if (user == null) {
            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无权访问", null);
        }
        // do next :
        return userInfoService.getmyInterest(user.getUID());
    }

    @RequestMapping(value = "myprofileinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String loadRealInfo(@RequestParam("token") String token) {
        LoginUser user = userFromToken.parseToken(token);
        if (user == null) {
            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无权访问", null);
        }
        // do next :
        return userInfoService.getmyRealProfile(user.getUID());
    }

    @RequestMapping(value = "mysocialinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String loadSocialNetInfo(@RequestParam("token") String token) {
        LoginUser user = userFromToken.parseToken(token);
        if (user == null) {
            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无权访问", null);
        }
        // do next :
        return userInfoService.getmySocialNet(user.getUID());
    }
}

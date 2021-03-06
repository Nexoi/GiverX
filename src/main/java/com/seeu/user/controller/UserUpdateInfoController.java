package com.seeu.user.controller;

import com.TP;
import com.TurnBackUtil;
import com.seeu.userOAuth.db.model.LoginUser;
import com.seeu.userOAuth.service.UserFromToken;
import com.seeu.user.model.*;
import com.seeu.user.service.UpdateUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by neo on 17/01/2017.
 */
@RestController
@RequestMapping("user/update")
public class UserUpdateInfoController {


    @Autowired
    UserFromToken userFromToken;

    @Autowired
    TurnBackUtil turnBackUtil;

    @Autowired
    UpdateUserInfoService updateUserInfoService;


    @RequestMapping(value = "business",method = RequestMethod.POST)
    public String updateBusiness(@RequestAttribute("UID") Integer UID, @ModelAttribute UserBusiness userInfo) {
//        LoginUser louser = userFromToken.parseToken(token);
//        if (louser == null)
//            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无此权限修改个人信息", null);
//        Integer UID = louser.getUID();
        return updateUserInfoService.updateMyBusiness(userInfo, UID);
    }

    @RequestMapping(value = "education",method = RequestMethod.POST)
    public String updateEducation(@RequestAttribute("UID") Integer UID, @ModelAttribute UserEducation userInfo) {
//        LoginUser louser = userFromToken.parseToken(token);
//        if (louser == null)
//            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无此权限修改个人信息", null);
//        Integer UID = louser.getUID();
        return updateUserInfoService.updateMyEducation(userInfo, UID);
    }

    @RequestMapping(value = "project",method = RequestMethod.POST)
    public String updateEducation(@RequestAttribute("UID") Integer UID, @ModelAttribute UserProjectWithBLOBs userInfo) {
        return updateUserInfoService.updateMyProject(userInfo, UID);
    }

    @RequestMapping(value = "interest",method = RequestMethod.POST)
    public String updateBasic(@RequestAttribute("UID") Integer UID, @ModelAttribute UserInterest userInfo) {
//        LoginUser louser = userFromToken.parseToken(token);
//        if (louser == null)
//            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无此权限修改个人信息", null);
//        Integer UID = louser.getUID();
        return updateUserInfoService.updateMyInterest(userInfo, UID);
    }

    @RequestMapping(value = "profile",method = RequestMethod.POST)
    public String updateBasic(@RequestAttribute("UID") Integer UID, @ModelAttribute UserRealProfile userInfo) {
//        LoginUser louser = userFromToken.parseToken(token);
//        if (louser == null)
//            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无此权限修改个人信息", null);
//        Integer UID = louser.getUID();
        return updateUserInfoService.updateMyRealProfile(userInfo, UID);
    }

    @RequestMapping(value = "social",method = RequestMethod.POST)
    public String updateSocialNet(@RequestAttribute("UID") Integer UID, @ModelAttribute UserSocialNet userInfo) {
//        LoginUser louser = userFromToken.parseToken(token);
//        if (louser == null)
//            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无此权限修改个人信息", null);
//        Integer UID = louser.getUID();
        return updateUserInfoService.updateMySocialNet(userInfo, UID);
    }
}

package com.seeu.user.controller;

import com.TP;
import com.TurnBackUtil;
import com.seeu.userOAuth.db.model.LoginUser;
import com.seeu.userOAuth.service.UserFromToken;
import com.seeu.user.model.*;
import com.seeu.user.service.UpdateUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping("business")
    public String updateBusiness(@RequestParam("token") String token, @ModelAttribute UserBusiness userInfo) {
        LoginUser louser = userFromToken.parseToken(token);
        if (louser == null)
            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无此权限修改个人信息", null);
        Integer UID = louser.getUID();
        return updateUserInfoService.updateMyBusiness(userInfo, UID);
    }

    @RequestMapping("education")
    public String updateEducation(@RequestParam("token") String token, @ModelAttribute UserEducation userInfo) {
        LoginUser louser = userFromToken.parseToken(token);
        if (louser == null)
            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无此权限修改个人信息", null);
        Integer UID = louser.getUID();
        return updateUserInfoService.updateMyEducation(userInfo, UID);
    }

    @RequestMapping("interest")
    public String updateBasic(@RequestParam("token") String token, @ModelAttribute UserInterest userInfo) {
        LoginUser louser = userFromToken.parseToken(token);
        if (louser == null)
            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无此权限修改个人信息", null);
        Integer UID = louser.getUID();
        return updateUserInfoService.updateMyInterest(userInfo, UID);
    }

    @RequestMapping("profile")
    public String updateBasic(@RequestParam("token") String token, @ModelAttribute UserRealProfile userInfo) {
        LoginUser louser = userFromToken.parseToken(token);
        if (louser == null)
            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无此权限修改个人信息", null);
        Integer UID = louser.getUID();
        return updateUserInfoService.updateMyRealProfile(userInfo, UID);
    }

    @RequestMapping("social")
    public String updateSocialNet(@RequestParam("token") String token, @ModelAttribute UserSocialNet userInfo) {
        LoginUser louser = userFromToken.parseToken(token);
        if (louser == null)
            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无此权限修改个人信息", null);
        Integer UID = louser.getUID();
        return updateUserInfoService.updateMySocialNet(userInfo, UID);
    }
}

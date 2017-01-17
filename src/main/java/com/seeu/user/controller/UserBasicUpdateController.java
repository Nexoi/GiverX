package com.seeu.user.controller;

import com.TP;
import com.TurnBackUtil;
import com.seeu.userOAuth.db.model.LoginUser;
import com.seeu.userOAuth.service.UserFromToken;
import com.seeu.user.model.UserBasic;
import com.seeu.user.service.UpdateUserBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by neo on 17/01/2017.
 */
@RestController
@RequestMapping("user/update")
public class UserBasicUpdateController {

    @Autowired
    UpdateUserBasicService updateUserBasicService;

    @Autowired
    UserFromToken userFromToken;

    @Autowired
    TurnBackUtil turnBackUtil;

    /**
     * @param icon
     * @return turn the query result back.
     */
    @RequestMapping("myicon")
    public String update(@RequestParam(value = "icon", required = false) MultipartFile icon, @RequestParam("token") String token) {
        LoginUser user = userFromToken.parseToken(token);
        if (user == null)
            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无此权限修改头像", null);
        Integer UID = user.getUID();
        return updateUserBasicService.updateMyIcon(icon, UID);
    }

    @RequestMapping("basic")
    public String updateBasic(@RequestParam("token") String token, @ModelAttribute UserBasic basic) {
        LoginUser user = userFromToken.parseToken(token);
        if (user == null)
            return turnBackUtil.formIt(TP.RESCODE_NOAUTH, "无此权限修改个人信息", null);
        Integer UID = user.getUID();
        return updateUserBasicService.updateMyBasic(basic, UID);
    }
}

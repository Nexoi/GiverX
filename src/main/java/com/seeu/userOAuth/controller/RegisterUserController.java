package com.seeu.userOAuth.controller;

import com.TP;
import com.TurnBackUtil;
import com.seeu.userOAuth.model.RegisterUserModel;
import com.seeu.userOAuth.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by neo on 17/01/2017.
 */
@RestController
@RequestMapping("user")
public class RegisterUserController {

    @Autowired
    TurnBackUtil turnBackUtil;
    @Autowired
    RegisterUserService registerUserService;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@ModelAttribute RegisterUserModel model) {
        String nickname = model.getNickname();
        String email = model.getEmail();
        String password = model.getPassword();
        if (!registerUserService.isNameAvailable(nickname))
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "注册失败，昵称已被使用", null);
        if (!registerUserService.isEmailAvaiable(email))
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "注册失败，邮箱已被使用", null);
        if (password != null && password.length() > 6) {
            // 开始注册
            return registerUserService.register(email, nickname, password);
        } else
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "注册失败，密码长度太短", null);
    }

    @PostMapping("register/checkname")
    public String checkName(@RequestParam("name") String name) {
        // check name is available.
        if (name == null) return turnBackUtil.formIt(TP.RESCODE_FAILURE, "昵称不合法", null);
        if (registerUserService.isNameAvailable(name)) return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "该昵称可用", null);
        else return turnBackUtil.formIt(TP.RESCODE_FAILURE, "该昵称已被使用", null);
    }

    @PostMapping("register/checkemail")
    public String checkEmail(@RequestParam("email") String email) {
        // check email is available.
        if (email == null) return turnBackUtil.formIt(TP.RESCODE_FAILURE, "请输入正确的邮箱", null);
        if (!email.contains("@") || !email.contains("."))
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "请检查邮箱格式是否正确", null);
        if (registerUserService.isEmailAvaiable(email)) return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "该邮箱可用", null);
        else return turnBackUtil.formIt(TP.RESCODE_FAILURE, "该邮箱已被注册", null);
    }
}

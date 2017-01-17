package com.seeu.userOAuth.service;

import com.TP;
import com.TurnBackUtil;
import com.seeu.user.dao.*;
import com.seeu.user.model.*;
import com.seeu.userOAuth.db.dao.LoginUserMapper;
import com.seeu.userOAuth.db.model.LoginUser;
import com.seeu.userOAuth.model.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by neo on 17/01/2017.
 */
@Service
public class RegisterUserService {
    private static final Logger logger = LogManager.getLogger(RegisterUserService.class);

    @Autowired
    TurnBackUtil turnBackUtil;

    @Autowired
    LoginUserMapper loginUserMapper;

    @Autowired
    UserBasicMapper userBasicMapper;

    @Autowired
    UserBusinessMapper userBusinessMapper;

    @Autowired
    UserEducationMapper userEducationMapper;

    @Autowired
    UserInterestMapper userInterestMapper;

    @Autowired
    UserRealProfileMapper userRealProfileMapper;

    @Autowired
    UserSocialNetMapper userSocialNetMapper;


    public String register(String email, String nickname, String password) {
        // 添加登录信息
        LoginUser loginUser = new LoginUser();
        loginUser.setAccount(email);
        loginUser.setPassword(password);
        loginUserMapper.insert(loginUser);
        // 再查询出来。。。此方法需要优化
        LoginUser realuser = loginUserMapper.selectByAccount(email);
        if (realuser == null) {
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "注册失败", null);
        }
        // 增加个人信息
        Integer UID = realuser.getUID();
        try {
            // basic
            UserBasic basic = new UserBasic();
            basic.setUID(UID);
            basic.setName(nickname);
            logger.info(nickname);
            userBasicMapper.insert(basic);
            // interest
            UserInterest interest = new UserInterest();
            interest.setUID(UID);
            userInterestMapper.insert(interest);
            // profile
            UserRealProfile profile = new UserRealProfile();
            profile.setUID(UID);
            userRealProfileMapper.insert(profile);
            // socialNet
            UserSocialNet socialNet = new UserSocialNet();
            socialNet.setUID(UID);
            userSocialNetMapper.insert(socialNet);
            return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "注册成功", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "注册失败", null);
        }
    }


    public boolean isNameAvailable(String name) {
        UserBasic userBasic = userBasicMapper.selectByName(name);
        if (userBasic == null) {
            return true;
        }
        return false;
    }

    // account
    public boolean isEmailAvaiable(String email) {
        LoginUser user = loginUserMapper.selectByAccount(email);
        if (user == null) {
            return true;
        }
        return false;
    }
}

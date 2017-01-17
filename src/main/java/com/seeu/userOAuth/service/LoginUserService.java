package com.seeu.userOAuth.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seeu.userOAuth.config.Constant;
import com.seeu.userOAuth.db.dao.LoginLogMapper;
import com.seeu.userOAuth.db.dao.LoginUserMapper;
import com.seeu.userOAuth.db.model.LoginLog;
import com.seeu.userOAuth.db.model.LoginUser;
import com.seeu.userOAuth.model.User;
import com.seeu.userOAuth.util.JwtUtil;
import com.seeu.userOAuth.util.ResponseUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

@Component
public class LoginUserService {

    private static final Logger logger = LogManager.getLogger(LoginUserService.class);

    @Autowired
    private JwtUtil jwt;

    @Autowired
    private LoginUserMapper loginUserMapper;

    @Autowired
    private LoginLogMapper logMapper;

    public ResponseEntity<String> login(HttpServletRequest request, HttpServletResponse response, User user) {
        if (user.getAccount() == null || user.getAccount().trim().equals("")) {
            return ResponseUtil.exception("帐号为空");
        }
        try {
            LoginUser louser = loginUserMapper.selectByAccount(user.getAccount());
            if (louser == null) {
                louser = loginUserMapper.selectByPrimaryKey(user.getUID());
                if (louser == null)
                    return ResponseUtil.custom(Constant.RESCODE_NOUSER, "无此帐号");
            }
            if (!louser.getAccount().equals(user.getAccount()) || !louser.getPassword().equals(user.getPassword())) {
                return ResponseUtil.exception("账号或者密码错误");
            }
            // client IP info
            String ipAddress = request.getHeader("X-FORWARDED-FOR");
            if (ipAddress == null) {
                ipAddress = request.getRemoteAddr();
            }
            loginLog(louser.getUID(), ipAddress); // record it

            String subject = JwtUtil.generalSubject(louser);
            String token = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_TTL);
            String refreshToken = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_REFRESH_TTL);
            JSONObject jo = new JSONObject();
            jo.put("token", token);
            jo.put("refreshToken", refreshToken);
            return ResponseUtil.successLogin(jo);
        } catch (Exception e) {
            logger.error("Login failure. Request user info : " + user.getUID() + "\t||\t" + user.getAccount() + "\t||\t" + user.getPassword(), e);
            return ResponseUtil.unKonwException();
        }
    }

    private void loginLog(Integer UID, String ip) {
        try {
            LoginLog log = new LoginLog();
            Date date = new Date();
            log.setIp(ip);
            log.setUID(UID);
//            log.setLogindate(date.toString());
            logMapper.insert(log);
        } catch (Exception e) {
            logger.warn("LoginLog insert failure.\t" + UID + "\t" + ip);
        }
    }
}

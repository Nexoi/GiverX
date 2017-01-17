package com.seeu.userOAuth.service;

import com.alibaba.fastjson.JSONObject;
import com.seeu.userOAuth.db.model.LoginUser;
import com.seeu.userOAuth.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by neo on 14/01/2017.
 */
@Component
public class UserFromToken {
    private Logger logger = LogManager.getLogger(UserFromToken.class);

    @Autowired
    private JwtUtil jwt;

    public LoginUser parseToken(String token) {
        if (token == null || token.length() < 10) {
            return null;
        }
        try {
            Claims claims = jwt.parseJWT(token);
            String json = claims.getSubject();
            return JSONObject.parseObject(json, LoginUser.class);
        } catch (Exception e) {
            logger.warn("Illegal Token : " + token);
            return null;
        }
    }
}

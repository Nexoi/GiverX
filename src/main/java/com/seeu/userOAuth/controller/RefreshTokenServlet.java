package com.seeu.userOAuth.controller;

import com.seeu.userOAuth.config.Constant;
import com.seeu.userOAuth.db.model.LoginUser;
import com.seeu.userOAuth.model.User;
import com.seeu.userOAuth.util.JwtUtil;
import io.jsonwebtoken.Claims;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;

@WebServlet("/refreshToken")
//@RestController
//@RequestMapping("token")
public class RefreshTokenServlet extends HttpServlet {

    private Logger logger = LogManager.getLogger(RefreshTokenServlet.class);

    private static final long serialVersionUID = 2573245614706073195L;

    @Autowired
    private JwtUtil jwt;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    //    @RequestMapping("refreshToken")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/event-stream;charset=UTF-8");
//            response.setHeader("Cache-Control", "no-cache");
//            response.setHeader("Connection", "keep-alive");
            PrintWriter out = response.getWriter();
            response.setContentType("text/json");
            String token = request.getParameter("token");

            Claims claims = jwt.parseJWT(token);
//            logger.info(">>>>>>Decode" + claims.getSubject());
            String json = claims.getSubject();
            User user = JSONObject.parseObject(json, User.class);

            // trans to loginuser.class ( for Serializable )
            LoginUser louser = new LoginUser();
            louser.setUID(user.getUID());
            louser.setAccount(user.getAccount());

            String subject = JwtUtil.generalSubject(louser);
            String refreshToken = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_TTL);
//            out.print("{\"retry\": " + Constant.JWT_REFRESH_INTERVAL + ",");
//            out.print("\"data\":\"" + refreshToken + "\"}");
//            out.flush();
            JSONObject jo = new JSONObject();
            jo.put("status", Constant.RESCODE_SUCCESS_MSG);
            jo.put("retry", Constant.JWT_REFRESH_INTERVAL);
            jo.put("data", refreshToken);
            out.print(jo.toJSONString());
            out.flush();
            logger.info("Token Refreshed. " + user.getUID() + "\t\t" + refreshToken);
        } catch (Exception e) {
            try {
                PrintWriter out = response.getWriter();
                JSONObject jo = new JSONObject();
                jo.put("status", Constant.RESCODE_EXCEPTION);
                jo.put("msg", "TOKEN过期, 请重新登录");
                out.print(jo.toJSONString());
                out.flush();
                logger.info("TOKEN 过期，请重新登录" + e);
            } catch (Exception ee) {
                logger.error(ee);
            }

        }
    }

}

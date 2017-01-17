//package com.seeu.filesystem.controller;
//
//import com.TP;
//import com.TurnBackUtil;
//import com.seeu.filesystem.service.StorageProperties;
//import com.seeu.userOAuth.db.model.LoginUser;
//import com.seeu.userOAuth.service.UserFromToken;
//import org.apache.commons.io.FileUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.UUID;
//
///**
// * Created by neo on 14/01/2017.
// */
//@Controller
//@RequestMapping("file")
//public class HeadIconUploadController {
//
//    private final Path rootLocation;
//
//    @Autowired
//    UserFromToken userFromToken;
//
//    @Autowired
//    TurnBackUtil turnBackUtil;
//
//    @Autowired
//    public HeadIconUploadController(StorageProperties properties) {
//        this.rootLocation = Paths.get(properties.getLocation());
//    }
//
//    @RequestMapping(value = "upload", method = RequestMethod.POST)
//    public String upload(@RequestParam("file") MultipartFile file, @RequestParam("token") String token) {
//        LoginUser user = userFromToken.parseToken(token);
//        if (user == null) {
//            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "上传失败，无操作权限", null);
//        }
//        String pathname = rootLocation + "/ffff"
//                + "/";
//        File f = new File(pathname);
//        if (!f.exists()) {
//            f.mkdirs();
//        }
//
//        try {
//            String name = file.getOriginalFilename();
//            String uuid = UUID.randomUUID().toString();
//            File n = new File(pathname + uuid + ".jpg");
//            FileUtils.writeByteArrayToFile(n, file.getBytes());
//        } catch (IOException exception) {
//
//        }
//        return null;
//    }
//
//}

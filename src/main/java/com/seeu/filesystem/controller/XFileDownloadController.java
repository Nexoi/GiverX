//package com.seeu.filesystem.controller;
//
//import com.seeu.filesystem.service.FileDownloadService;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
///**
// * Created by neo on 14/01/2017.
// */
//@RestController
//@RequestMapping("fsysdn")
//public class XFileDownloadController {
//    private Logger LOGGER = Logger.getLogger(XFileDownloadController.class);
//    @Autowired
//    FileDownloadService fileDownloadService;
//
//
//    //Get可以直接下载，Post为什么客户端不能打开下载对话框？(GET会有文件泄露风险，直接传入一级文件夹名就能访问文件夹内容)(已解决文件夹问题)
////    @GetMapping(value = "{filename:.+}")
////    public Object serveFile(@PathVariable("filename") String filename) {
////        return loadFile(filename);
////    }
//
//    @GetMapping("user/head/{filename:.+}")
//    public Object serveFile2(@PathVariable("filename") String filename, @RequestAttribute("UID") Integer UID) {
//        return fileDownloadService.loadHeadIcon(UID, filename);//  hints: 利用混淆路径增强安全
//    }
//
//    @GetMapping("user/projectpic/{filename:.+}")
//    public Object serveFile3(@PathVariable("filename") String filename, @RequestAttribute("UID") Integer UID) {
//        return fileDownloadService.loadProjectPic(UID, filename);
//    }
//
//
//}

package com.seeu.filesystem.controller;

import com.TP;
import com.TurnBackUtil;
import com.seeu.filesystem.service.FileDownloadService;
import com.seeu.filesystem.service.FileDownloadServiceHelper;
import com.seeu.filesystem.service.storage.StorageFileNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by neo on 14/01/2017.
 */
@RestController
@RequestMapping("fsysdn")
public class FileDownloadController {
    private Logger LOGGER = Logger.getLogger(FileDownloadController.class);

    @Autowired
    TurnBackUtil turnBackUtil;
    @Autowired
    FileDownloadService fileDownloadService;


    //Get可以直接下载，Post为什么客户端不能打开下载对话框？(GET会有文件泄露风险，直接传入一级文件夹名就能访问文件夹内容)(已解决文件夹问题)
//    @GetMapping(value = "{filename:.+}")
//    public Object serveFile(@PathVariable("filename") String filename) {
//        return loadFile(filename);
//    }

    @GetMapping("user/head/{filename:.+}")
    public Object serveFile2(@PathVariable("filename") String filename, @RequestAttribute("UID") Integer UID) {
        return fileDownloadService.loadMyHeadIcon(UID, filename);//  hints: 利用混淆路径增强安全
    }

    @GetMapping("user/projectpic/{filename:.+}")
    public Object serveFile3(@PathVariable("filename") String filename, @RequestAttribute("UID") Integer UID) {
        return fileDownloadService.loadMyProjectPic(UID, filename);
    }


}

package com.seeu.filesystem.controller;

import com.TP;
import com.TurnBackUtil;
import com.seeu.filesystem.service.FileDownloadService;
import com.seeu.filesystem.service.storage.StorageFileNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //Get可以直接下载，Post为什么客户端不能打开下载对话框？(GET会有文件泄露风险，直接传入一级文件夹名就能访问文件夹内容)
    @GetMapping(value = "{filename:.+}")
    public Object serveFile(@PathVariable("filename") String filename) {
        return loadFile(filename);
    }

    @PostMapping("user/head")
    public Object serveFile2(@RequestParam("filename") String filename) {
        return loadFile("jkw23/wwk/" + filename);//  利用混淆路径增强安全
    }

    @PostMapping("user/photo")
    public Object serveFile3(@RequestParam("filename") String filename) {
        return loadFile("jkw23/pph/" + filename);
    }


    private Object loadFile(String filename) {
        if (checkName(filename)) {
            try {
                return fileDownloadService.loadAsResource(filename);
            } catch (StorageFileNotFoundException e) {
//                LOGGER.warn("FileDn System Exception ::\t" + e.getMessage());
                return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "找不到文件", null);
            }
        } else {
            return turnBackUtil.formIt(TP.RESCODE_EXCEPTION, "文件名不合法", null);
        }
    }

    @RequestMapping(value = "check")
    private boolean checkName(@RequestParam("filename") String filename) {
//        LOGGER.warn(filename);
        if (filename == null || filename.trim().equals("")) {
            return false;
        }
        String pattern = "^(?!_)(?!.*?_$)[a-zA-Z0-9-._\u4e00-\u9fa5]+$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(filename);
        return m.matches();
    }
}

package com.seeu.filesystem.controller2;

import com.alibaba.fastjson.JSONObject;
import com.TP;
import com.TurnBackUtil;
import com.seeu.filesystem.service2.FileUploadService;
import com.seeu.userOAuth.service.UserFromToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by neo on 16/01/2017.
 */
@RestController
@RequestMapping("file")
public class FileUploadController {

    @Autowired
    TurnBackUtil turnBackUtil;

    @Autowired
    UserFromToken userFromToken;

    @Autowired
    FileUploadService fileUploadService;

    @PostMapping("upload")
//    public String upload(@ModelAttribute("model") UploadFile model) {
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, @RequestParam("type") String type, @RequestAttribute("UID") Integer UID) {
        if (file == null) {
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "上传失败，文件为空", null);
        }
        // handle path
        Path path = Paths.get(UID + "".toString());// this path is illegal.

        // handle type (.png)
        if (type == null)
            type = "";
        if (!type.contains(".")) {
            type = '.' + type;
        }

        String filename = fileUploadService.upload(file, type, path);
        if (filename == null) {
            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "上传失败", null);
        } else {
            JSONObject jo = new JSONObject();
            jo.put("filename", filename);
//            jo.put("filepath", path);
            return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "上传成功", jo);
        }
    }

}

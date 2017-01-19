package com.seeu.filesystem.controller;


import com.seeu.filesystem.service.FileDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by neo on 19/01/2017.
 */
@RestController
@RequestMapping("file")
public class PopularFileDownloadController {
    @Autowired
    FileDownloadService fileDownloadService;

    @RequestMapping("icon/{UID}/{filename:.+}")
    public Object loadFile(@PathVariable(value = "UID", required = false) Integer UID, @PathVariable(value = "filename", required = false) String filename) {
        return fileDownloadService.loadHeadIcon(UID, filename);
    }

    @RequestMapping("project/{UID}/{filename:.+}")
    public Object loadFile2(@PathVariable(value = "UID", required = false) Integer UID, @PathVariable(value = "filename", required = false) String filename) {
        return fileDownloadService.loadProjectPic(UID, filename);
    }

    @RequestMapping("task/{UID}/{filename:.+}")
    public Object loadFile3(@PathVariable(value = "UID", required = false) Integer UID, @PathVariable(value = "filename", required = false) String filename) {
        return fileDownloadService.loadTaskPic(UID, filename);
    }
}

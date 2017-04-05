package com.seeu.filesystem.controller2;


import com.seeu.filesystem.service2.FileDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by neo on 19/01/2017.
 */
@RestController
@RequestMapping("file")
public class FileDownloadController {
    @Autowired
    FileDownloadService fileDownloadService;

    @RequestMapping("download/{UID}/{filename:.+}")
    public Object loadFile(@PathVariable(value = "filename", required = false) String filename, @PathVariable(value = "UID") String UID) {
        return fileDownloadService.loadFile(UID, filename);
    }
}

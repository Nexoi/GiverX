package com.seeu.filesystem.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by neo on 16/01/2017.
 */
public class UploadFile {
    private String type;

    private MultipartFile file;

    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }
}

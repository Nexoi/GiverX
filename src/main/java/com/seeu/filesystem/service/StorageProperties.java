package com.seeu.filesystem.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(locations="classpath:application.properties",prefix="seeu.storage")
//@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
//    private String location = "templates/upload-dir";

    private String location;

    public String getUserhead() {
        return userhead;
    }

    public void setUserhead(String userhead) {
        this.userhead = userhead;
    }

    public String getUserproject() {
        return userproject;
    }

    public void setUserproject(String userproject) {
        this.userproject = userproject;
    }

    private String userhead;

    private String userproject;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}

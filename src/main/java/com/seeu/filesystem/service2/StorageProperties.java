package com.seeu.filesystem.service2;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@Component
@ConfigurationProperties(locations = "classpath:application.properties", prefix = "seeu.storage")
//@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
//    private String location = "templates/upload-dir";

    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}

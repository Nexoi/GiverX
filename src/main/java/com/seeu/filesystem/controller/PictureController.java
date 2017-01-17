//package com.seeu.filesystem.controller;
//
//import com.TP;
//import com.TurnBackUtil;
//import org.apache.commons.fileupload.FileUploadBase;
//import org.apache.commons.io.FilenameUtils;
//import org.apache.log4j.Logger;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.multipart.MaxUploadSizeExceededException;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//
//import javax.servlet.ServletContext;
//import java.io.File;
//import java.io.IOException;
//import java.util.*;
//
///**
// * Created by neo on 13/01/2017.
// */
//@Controller
//public class PictureController {
//    private Logger LOGGER = Logger.getLogger(PictureController.class);
//
//    @Autowired
//    TurnBackUtil turnBackUtil;
//
//    @RequestMapping("/file/uploadpicture")
//    public String addPictures(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
//        try {
//            //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
//            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
//                    request.getSession().getServletContext());
//            //检查form中是否有enctype="multipart/form-data"
//            if (multipartResolver.isMultipart(request)) {
//                //将request变成多部分request
//                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//                //获取multiRequest 中所有的文件名
//                Iterator iter = multiRequest.getFileNames();
//                List<String> pictures = new ArrayList<String>();
//                boolean hasPicture = false;
//                while (iter.hasNext()) {
//                    hasPicture = true;
//                    //一次遍历所有文件
//                    MultipartFile file = multiRequest.getFile(iter.next().toString());
//                    if (file != null) {
//                        // 获得项目的路径
//                        ServletContext sc = request.getSession().getServletContext();
////                    // 上传位置
////                    String path = sc.getRealPath("/img") + "/"; // 设定文件保存的目录
//                        //Users/neo/IdeaProjects/seeuGiver/src/main/resources/static/
//                        String path = "/";
//                        String fname = file.getOriginalFilename();
//                        //去掉文件名,保留尾缀
////                        if (fname.contains(".")) {
////                            String suffix = fname.substring(fname.lastIndexOf(".") + 1);
////                            fname = new String(suffix);
////                        }
////                        String filename = ("" + new Date() + (int) (Math.random() * 10000) + "." + fname).trim();
//                        String uuid = UUID.randomUUID().toString();
//                        String filename = uuid + "." + FilenameUtils.getExtension(fname);
////                        String filename = "222.jpg";
//                        String fP = path + filename;
//                        //上传
//                        file.transferTo(new File(fP));
//                        pictures.add(filename);
//                    }
//                }
//                if (hasPicture) {
//                    JSONObject map = new JSONObject();
////                    map.put("status", "SUCCESS");
//                    map.put("filenames", pictures);
//                    return turnBackUtil.formIt(TP.RESCODE_SUCCESS, "上传成功", map);
////                    String result = newsAddSession.addPictures(pictures);
////                    if (result.equals("SUCCESS")) {
////                        //把图片src传回给浏览器即可
////                        JSONArray arr = new JSONArray(pictures);
////                        JSONObject obj = new JSONObject();
////                        obj.put("status", "200");
////                        obj.put("data", arr);
////                        LOGGER.info("PicturesAdded.");
////                        return obj.toString();
////                    } else {
////                        JSONObject obj = new JSONObject();
////                        obj.put("status", "201");
////                        obj.put("data", result);
////                        return obj.toString();
////                    }
//                }
//            }
//        } catch (MaxUploadSizeExceededException ee) {
//            LOGGER.info("文件过大");
////            JSONObject obj = new JSONObject();
////            obj.put("status", "201");
////            obj.put("msg", "File size exceeded");
//            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "上传失败，文件过大", null);
//        } catch (FileUploadBase.FileUploadIOException eee) {
//            LOGGER.info("文件异常");
////            JSONObject obj = new JSONObject();
////            obj.put("status", "201");
////            obj.put("msg", "File upload exception");
//            return turnBackUtil.formIt(TP.RESCODE_FAILURE, "上传失败，文件异常", null);
//        }
////        JSONObject obj = new JSONObject();
////        obj.put("status", "201");
////        obj.put("msg", "no picture uploaded");
//        return turnBackUtil.formIt(TP.RESCODE_FAILURE, "No picture uploaded", null);
//    }
//}

//package com.cp.oss.controller;
//
//import com.cp.oss.service.FileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/videos")
//public class VideosController {
//
//    @Autowired
//    private FileService fileService;
//
//    @GetMapping("/{bucketName}")
//    public List<String> listVideos(@PathVariable String bucketName) {
//        return fileService.listVideos(bucketName);
//    }
//}
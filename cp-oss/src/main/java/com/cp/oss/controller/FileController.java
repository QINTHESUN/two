package com.cp.oss.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.cp.oss.entity.FileInfo;
import com.cp.oss.entity.Result;
import com.cp.oss.service.FileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件操作controller
 *
 * @author: ChickenWing
 * @date: 2023/10/14
 */
@RestController
public class FileController {

    @Resource
    private FileService fileService;

    @NacosValue(value = "${storage.service.type}",autoRefreshed = true)
    private String storageType;

    @RequestMapping("/testGetAllBuckets")
    public String testGetAllBuckets() throws Exception {
        List<String> allBucket = fileService.getAllBucket();
        return allBucket.get(0);
    }

    @RequestMapping("/getUrl")
    public String getUrl(String bucketName, String objectName) throws Exception {
        return fileService.getUrl(bucketName, objectName);
    }

    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    public Result upload(MultipartFile uploadFile, String bucket, String objectName) throws Exception {
        String url = fileService.uploadFile(uploadFile, bucket, objectName);
        return Result.ok(url);
    }

    /**
     * 列出指定桶中video文件夹下的所有视频文件
     */
    @RequestMapping("/listVideosInFolder")
    public Result<List<String>> listVideosInFolder(@RequestParam String bucket) {
        try {
            String folder = "video";
            List<FileInfo> fileInfoList = fileService.getAllFileInFolder(bucket, folder);
            List<String> videoUrls = new ArrayList<>();
            for (FileInfo fileInfo : fileInfoList) {
                String fileName = fileInfo.getFileName();
                if (fileName.endsWith(".mp4") || fileName.endsWith(".avi") || fileName.endsWith(".mov")) {
                    String url = fileService.getUrl(bucket, fileName);
                    videoUrls.add(url);
                }
            }
            return Result.ok(videoUrls);
        } catch (Exception e) {
            return Result.fail("获取视频列表失败");
        }
    }

    @RequestMapping("/testNacos")
    public String testNacos(){
        return storageType;
    }

}

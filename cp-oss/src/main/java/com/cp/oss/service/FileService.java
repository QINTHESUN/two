package com.cp.oss.service;

import com.cp.oss.adapter.StorageAdapter;
import com.cp.oss.entity.FileInfo;
import io.minio.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    private final StorageAdapter storageAdapter;
    private final MinioClient minioClient;

    public FileService(StorageAdapter storageAdapter, MinioClient minioClient) {
        this.storageAdapter = storageAdapter;
        this.minioClient = minioClient;
    }

    /**
     * 列出所有桶
     */
    public List<String> getAllBucket() {
        try {
            return storageAdapter.getAllBucket();
        } catch (Exception e) {
            // 这里可以根据需求进行异常处理，比如记录日志
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * 获取文件路径
     */
    public String getUrl(String bucketName, String objectName) {
        return storageAdapter.getUrl(bucketName, objectName);
    }

    /**
     * 上传文件
     */
    public String uploadFile(MultipartFile uploadFile, String bucket, String objectName) {
        try {
            storageAdapter.uploadFile(uploadFile, bucket, objectName);
            objectName = objectName + "/" + uploadFile.getOriginalFilename();
            return storageAdapter.getUrl(bucket, objectName);
        } catch (Exception e) {
            // 这里可以根据需求进行异常处理，比如记录日志
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 列出指定桶中的所有文件
     */
    public List<FileInfo> getAllFilesInBucket(String bucket) {
        return storageAdapter.getAllFile(bucket);
    }

    /**
     * 列出指定文件夹下的所有文件
     */
    public List<FileInfo> getAllFileInFolder(String bucket, String folder) {
        return storageAdapter.getAllFileInFolder(bucket, folder);
    }
}


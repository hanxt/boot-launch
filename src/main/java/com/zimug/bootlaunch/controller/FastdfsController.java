package com.zimug.bootlaunch.controller;

import com.zimug.bootlaunch.config.exception.AjaxResponse;
import com.zimug.bootlaunch.config.exception.CustomException;
import com.zimug.bootlaunch.config.exception.CustomExceptionType;
import com.zimug.spring.fastdfs.FastDFSClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Controller
@RequestMapping("fastdfs")
public class FastdfsController {

    @Resource
    private FastDFSClientUtil fastDFSClientUtil;

    @PostMapping("/upload")
    @ResponseBody
    public AjaxResponse upload(@RequestParam("file") MultipartFile file) {

        String fileId;
        try {
            String originalfileName = file.getOriginalFilename();
            fileId = fastDFSClientUtil.uploadFile(file.getBytes(),originalfileName.substring(originalfileName.lastIndexOf(".")));
            return AjaxResponse.success(fastDFSClientUtil.getSourceUrl(fileId));
        } catch (Exception e) {
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR,"文件上传图片服务器失败");
        }
    }


    @DeleteMapping("/delete")
    @ResponseBody
    public AjaxResponse upload(@RequestParam String fileid) {
        try {
            fastDFSClientUtil.delete(fileid);
            byte[] imgfile = fastDFSClientUtil.downloadFile(fileid);
        } catch (Exception e) {
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR,"文件删除失败");
        }
       return  AjaxResponse.success();
    }


}

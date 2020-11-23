package com.zy.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by 54110 on 2020/11/19.
 */
public class UploadUtils {


    public String upload(MultipartFile multipartFile) throws IOException {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region0());
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = "Lry8tSWholb6wnbm910xgAO1DwLMJZEKDOLVQvfQ";
        String secretKey = "PddJ9EgM-lrPsEEJ-W-lYNjeKAIGWzBayD7oinFK";
        String bucket = "ssm-zy";
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        try {
            ByteArrayInputStream byteInputStream=new ByteArrayInputStream(multipartFile.getBytes());
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(byteInputStream,key,upToken,null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                return "http://qk1l09fw8.hd-bkt.clouddn.com/"+putRet.hash;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (UnsupportedEncodingException ex) {
            //ignore
        }
        return null;
    }
}

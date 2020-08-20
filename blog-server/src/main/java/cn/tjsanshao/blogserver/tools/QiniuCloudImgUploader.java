package cn.tjsanshao.blogserver.tools;

import com.alibaba.fastjson.JSON;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * images upload
 *
 * @author TjSanshao
 * @date 2020-08-20 15:46
 */
@Slf4j
@Component
public class QiniuCloudImgUploader {
    public final static String FILE_KEY = "fileKey";
    public final static String FILE_HASH = "fileHash";

    @Value("${qiniu.cloud.accessKey:4ud26IewNcOnjtAGtuA4f3TiZszzwYYv3xchqw3a}")
    private String accessKey;

    @Value("${qiniu.cloud.secretKey:AlKS4gXg9P5iBhKF2pHl2zAMtikIXL8uhhcu28_r}")
    private String secretKey;

    @Value("${qiniu.cloud.bucket:tjsanshao-blog}")
    private String bucket;

    @Resource
    private UploadManager uploadManager;

    public Map<String, String> upload(String fileKey, String filePath) {
        final Auth auth = Auth.create(accessKey, secretKey);
        final String upToken = auth.uploadToken(bucket);
        final HashMap<String, String> uploadResult = new HashMap<>();
        try {
            final Response response = uploadManager.put(filePath, fileKey, upToken);
            final DefaultPutRet defaultPutRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
            log.info("uploaded file key:{}", defaultPutRet.key);
            log.info("uploaded file hash:{}", defaultPutRet.hash);
            uploadResult.put(QiniuCloudImgUploader.FILE_KEY, defaultPutRet.key);
            uploadResult.put(QiniuCloudImgUploader.FILE_HASH, defaultPutRet.hash);
        } catch (Exception e) {
            log.error("upload image to cloud error:{}", e.toString());
        }
        return uploadResult;
    }
}

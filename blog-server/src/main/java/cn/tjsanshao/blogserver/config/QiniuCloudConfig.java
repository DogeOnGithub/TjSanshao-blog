package cn.tjsanshao.blogserver.config;

import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * qiniu cloud config
 *
 * @author TjSanshao
 * @date 2020-08-20 15:50
 */
@Configuration
public class QiniuCloudConfig {
    @Bean
    com.qiniu.storage.Configuration qiniuConfig() {
        return new com.qiniu.storage.Configuration(Region.huanan());
    }

    @Bean
    UploadManager uploadManager() {
        return new UploadManager(qiniuConfig());
    }
}

package cn.tjsanshao.blogserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author TjSanshao
 */
@SpringBootApplication
@MapperScan(basePackages = {"cn.tjsanshao.blogserver.repository"})
public class BlogServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogServerApplication.class, args);
    }

}

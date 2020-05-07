package cn.tjsanshao.blogserver.controller;

import cn.tjsanshao.blogserver.service.BlogService;
import cn.tjsanshao.blogserver.service.WorksService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * private, manager controller
 *
 * @author TjSanshao
 * @date 2020-05-07 11:50
 */
@CrossOrigin
@RestController
public class PrivateController {
    @Resource
    private BlogService blogService;
    @Resource
    private WorksService worksService;

    @RequestMapping("/private/hello")
    public String hello() {
        return "Welcome to Console!";
    }
}

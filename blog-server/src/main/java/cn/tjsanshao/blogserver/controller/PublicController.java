package cn.tjsanshao.blogserver.controller;

import cn.tjsanshao.blogserver.model.Banner;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * public
 *
 * @author TjSanshao
 * @date 2020-04-07 14:43
 */
@CrossOrigin
@RestController
public class PublicController {
    @RequestMapping("/public/hello")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/public/home")
    public String bannerList() {
        ArrayList<Banner> bannerList = new ArrayList<>();
        bannerList.add(new Banner().setImageSrc("http://q80ates4m.bkt.clouddn.com/image/banner1.jpg"));
        bannerList.add(new Banner().setImageSrc("http://q80ates4m.bkt.clouddn.com/image/banner1.jpg"));
        bannerList.add(new Banner().setImageSrc("http://q80ates4m.bkt.clouddn.com/image/banner1.jpg"));

        HashMap<String, Object> res = new HashMap<>();
        res.put("bannerList", bannerList);
        return JSON.toJSONString(res);
    }
}

package cn.tjsanshao.blogserver.controller;

import cn.tjsanshao.blogserver.model.Banner;
import cn.tjsanshao.blogserver.model.MainCard;
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
    public String home() {
        ArrayList<Banner> bannerList = new ArrayList<>();
        bannerList.add(new Banner().setImageSrc("http://q80ates4m.bkt.clouddn.com/image/banner1.jpg"));
        bannerList.add(new Banner().setImageSrc("http://q80ates4m.bkt.clouddn.com/image/banner2.jpg"));
        bannerList.add(new Banner().setImageSrc("http://q80ates4m.bkt.clouddn.com/image/banner3.jpg"));

        ArrayList<MainCard> mainCardList = new ArrayList<>();
        mainCardList.add(new MainCard().setTitle("My Blog").setDescribe("Desc").setImage("http://q80ates4m.bkt.clouddn.com/image/blog-img.jpg").setButton("Click to scan my blog").setItemKey("Blog"));

        HashMap<String, Object> res = new HashMap<>();
        res.put("bannerList", bannerList);
        res.put("mainCardList", mainCardList);
        return JSON.toJSONString(res);
    }

    @RequestMapping("/public/about")
    public String about() {
        return "http://q80ates4m.bkt.clouddn.com/image/blog-img.jpg";
    }
}

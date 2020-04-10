package cn.tjsanshao.blogserver.controller;

import cn.hutool.core.date.DateUtil;
import cn.tjsanshao.blogserver.model.Article;
import cn.tjsanshao.blogserver.model.Banner;
import cn.tjsanshao.blogserver.model.Comment;
import cn.tjsanshao.blogserver.model.MainCard;
import cn.tjsanshao.blogserver.model.SortCard;
import cn.tjsanshao.blogserver.model.Works;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    @RequestMapping("/public/other")
    public String other() {
        String[] tags = {"Java", "javascript", "Vue"};

        ArrayList<SortCard> sortCardList = new ArrayList<>();
        sortCardList.add(new SortCard().setImageSrc("http://q80ates4m.bkt.clouddn.com/image/github.jpg").setSrc("https://github.com/TjSanshao"));

        HashMap<String, Object> res = new HashMap<>();
        res.put("tagsList", tags);
        res.put("sortCardList", sortCardList);
        return JSON.toJSONString(res);
    }

    @RequestMapping("/public/blog")
    public String blog() {
        ArrayList<Article> articles = new ArrayList<>();
        ArrayList<String> tags = new ArrayList<>();
        tags.add("html");
        tags.add("javascript");
        tags.add("electron");
        Article article = new Article();
        article.setTitle("基于electron的音视频播放器");
        article.setContent("基于electron的音视频播放器前言选择做一个音视频播放器桌面应用程序原因技术的选型已经实现了的功能音视频播放实现右键菜单实现");
        article.setTime(DateUtil.date());
        article.setImageSrc("http://q80ates4m.bkt.clouddn.com/image/blog-electron.jpg");
        article.setBlogSrc("https://blog.csdn.net/vgub158/article/details/91490185");
        article.setTags(tags);
        articles.add(article);

        return JSON.toJSONString(articles);
    }

    @RequestMapping("/public/works")
    public String works() {
        ArrayList<Works> worksList = new ArrayList<>();
        Works works = new Works();
        works.setTitle("player");
        works.setSummary("electron-vue音视频播放器");
        List<String> tags = new ArrayList<>();
        tags.add("electron");
        works.setTags(tags);
        ArrayList<String> functions = new ArrayList<>();
        functions.add("视频播放：目前已经支持大多数视频格式，比如 MP4、WebM、mkv、avi、WMV、FLV、rmvb 等，后续会添加更多的视频格式");
        works.setFunctions(functions);
        works.setImageSrc("http://q80ates4m.bkt.clouddn.com/image/player.png");
        works.setWorksSrc("https://github.com/c10342/player");
        worksList.add(works);
        return JSON.toJSONString(worksList);
    }

    @RequestMapping("/public/comment/publish")
    public String publishComment(Comment comment) {
        return "success";
    }

    @RequestMapping("/public/comment/list")
    public String comment() {
        ArrayList<Comment> commentList = new ArrayList<>();
        commentList.add(new Comment().setNickName("TjSanshao").setContent("comment").setCreateAt(DateUtil.date()).setUpdateAt(DateUtil.date()));
        return JSON.toJSONString(commentList);
    }
}

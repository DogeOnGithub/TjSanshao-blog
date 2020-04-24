package cn.tjsanshao.blogserver.controller;

import cn.hutool.core.date.DateUtil;
import cn.tjsanshao.blogserver.service.BlogService;
import cn.tjsanshao.blogserver.service.MainService;
import cn.tjsanshao.blogserver.service.OtherService;
import cn.tjsanshao.blogserver.view.Article;
import cn.tjsanshao.blogserver.view.Comment;
import cn.tjsanshao.blogserver.view.SortCard;
import cn.tjsanshao.blogserver.view.Works;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    @Resource
    private MainService mainService;
    @Resource
    private OtherService otherService;
    @Resource
    private BlogService blogService;

    @RequestMapping("/public/hello")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/public/home")
    public String home() {
        HashMap<String, Object> res = new HashMap<>();
        res.put("bannerList", mainService.banner());
        res.put("mainCardList", mainService.mainCard());
        return JSON.toJSONString(res);
    }

    @RequestMapping("/public/about")
    public String about() {
        return "http://q80ates4m.bkt.clouddn.com/image/blog-img.jpg";
    }

    @RequestMapping("/public/other")
    public String other() {
        List<SortCard> sortCards = otherService.sortCards();
        sortCards.add(new SortCard().setImageSrc("http://q80ates4m.bkt.clouddn.com/image/github.jpg").setSrc("https://github.com/TjSanshao"));

        HashMap<String, Object> res = new HashMap<>();
        res.put("tagsList", otherService.tags);
        res.put("sortCardList", sortCards);
        return JSON.toJSONString(res);
    }

    @RequestMapping("/public/blog")
    public String blog() {
        List<Article> articles = blogService.articles();
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

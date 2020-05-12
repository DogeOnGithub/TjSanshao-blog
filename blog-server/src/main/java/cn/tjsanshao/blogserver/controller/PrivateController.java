package cn.tjsanshao.blogserver.controller;

import cn.tjsanshao.blogserver.service.BlogService;
import cn.tjsanshao.blogserver.service.WorksService;
import cn.tjsanshao.blogserver.transfer.ArticleTransfer;
import cn.tjsanshao.blogserver.transfer.WorksTransfer;
import cn.tjsanshao.blogserver.utils.ExUtils;
import cn.tjsanshao.blogserver.view.Article;
import cn.tjsanshao.blogserver.view.Works;
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

    @Resource
    private ArticleTransfer articleTransfer;
    @Resource
    private WorksTransfer worksTransfer;

    @RequestMapping("/private/hello")
    public String hello() {
        return "Welcome to Console!";
    }

    @RequestMapping("/private/article/upload")
    public String uploadBlog(Article view) {
        cn.tjsanshao.blogserver.model.Article article = articleTransfer.fromView2Model(view);
        article.setTags(ExUtils.analyseListToString(view.getTags()));
        blogService.save(article);
        return "success";
    }

    @RequestMapping("/private/works/upload")
    public String uploadWorks(Works view) {
        cn.tjsanshao.blogserver.model.Works works = worksTransfer.fromView2Model(view);
        works.setFunctions(ExUtils.analyseListToString(view.getFunctions()));
        works.setTags(ExUtils.analyseListToString(view.getTags()));
        worksService.save(works);
        return "success";
    }
}

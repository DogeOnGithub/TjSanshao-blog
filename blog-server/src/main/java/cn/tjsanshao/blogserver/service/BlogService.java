package cn.tjsanshao.blogserver.service;

import cn.tjsanshao.blogserver.repository.ArticleRepository;
import cn.tjsanshao.blogserver.transfer.ArticleTransfer;
import cn.tjsanshao.blogserver.view.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * blog service
 *
 * @author TjSanshao
 * @date 2020-04-24 10:24
 */
@Service
public class BlogService {
    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private ArticleTransfer articleTransfer;

    public List<Article> articles() {
        List<cn.tjsanshao.blogserver.model.Article> articles = articleRepository.selectList(null);
        ArrayList<Article> viewArticles = new ArrayList<>();
        articles.forEach(a -> {
            Article article = articleTransfer.fromModel2View(a);
            List<String> tags = Arrays.asList(a.getTags().split(";"));
            article.setTags(tags);
            viewArticles.add(article);
        });
        return viewArticles;
    }
}

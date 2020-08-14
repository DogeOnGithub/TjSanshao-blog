package cn.tjsanshao.blogserver.service;

import cn.tjsanshao.blogserver.repository.ArticleRepository;
import cn.tjsanshao.blogserver.transfer.ArticleTransfer;
import cn.tjsanshao.blogserver.view.Article;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        List<cn.tjsanshao.blogserver.model.Article> articles = articleRepository.selectList(new LambdaQueryWrapper<cn.tjsanshao.blogserver.model.Article>().eq(true, cn.tjsanshao.blogserver.model.Article::getDeleteFlag, 0));
        ArrayList<Article> viewArticles = new ArrayList<>();
        articles.forEach(a -> {
            Article article = articleTransfer.fromModel2View(a);
            List<String> tags = Arrays.asList(a.getTags().split(";"));
            article.setTags(tags);
            viewArticles.add(article);
        });
        return viewArticles;
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(cn.tjsanshao.blogserver.model.Article article) {
        articleRepository.insert(article);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean hide(long id) {
        cn.tjsanshao.blogserver.model.Article article = new cn.tjsanshao.blogserver.model.Article().setId(id).setDeleteFlag(new Short("1"));
        int row = articleRepository.updateById(article);
        return row > 0;
    }
}

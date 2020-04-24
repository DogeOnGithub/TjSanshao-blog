package cn.tjsanshao.blogserver.repository;

import cn.tjsanshao.blogserver.model.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author TjSanshao
 * @date 2020-04-24 10:24
 */
@Repository
public interface ArticleRepository extends BaseMapper<Article> {
}

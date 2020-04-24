package cn.tjsanshao.blogserver.transfer;

import cn.tjsanshao.blogserver.view.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author TjSanshao
 * @date 2020-04-24 10:26
 */
@Mapper(componentModel = "spring")
public interface ArticleTransfer {
    @Mappings({
            @Mapping(source = "tags", target = "tags", ignore = true)
    })
    Article fromModel2View(cn.tjsanshao.blogserver.model.Article article);

    List<Article> fromModel2View(List<cn.tjsanshao.blogserver.model.Article> articles);
}

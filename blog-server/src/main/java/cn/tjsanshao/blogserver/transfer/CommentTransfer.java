package cn.tjsanshao.blogserver.transfer;

import cn.tjsanshao.blogserver.model.Comment;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author TjSanshao
 * @date 2020-04-27 09:55
 */
@Mapper(componentModel = "spring")
public interface CommentTransfer {
    Comment fromView2Model(cn.tjsanshao.blogserver.view.Comment comment);

    List<cn.tjsanshao.blogserver.view.Comment> fromModel2View(List<Comment> list);
}

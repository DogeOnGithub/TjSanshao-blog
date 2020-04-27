package cn.tjsanshao.blogserver.repository;

import cn.tjsanshao.blogserver.model.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author TjSanshao
 * @date 2020-04-24 17:15
 */
@Repository
public interface CommentRepository extends BaseMapper<Comment> {
}

package cn.tjsanshao.blogserver.service;

import cn.tjsanshao.blogserver.repository.CommentRepository;
import cn.tjsanshao.blogserver.transfer.CommentTransfer;
import cn.tjsanshao.blogserver.view.Comment;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * comment service
 *
 * @author TjSanshao
 * @date 2020-04-24 17:16
 */
@Service
public class CommentService {
    @Resource
    private CommentRepository commentRepository;

    @Resource
    private CommentTransfer commentTransfer;

    @Transactional(rollbackFor = Exception.class)
    public boolean publishComment(Comment c) {
        cn.tjsanshao.blogserver.model.Comment comment = commentTransfer.fromView2Model(c);
        commentRepository.insert(comment);
        return true;
    }

    public List<Comment> comments(long current, long pageSize) {
        Page<cn.tjsanshao.blogserver.model.Comment> commentPage = commentRepository.selectPage(new Page<>(current, pageSize), new LambdaQueryWrapper<cn.tjsanshao.blogserver.model.Comment>().orderByDesc(cn.tjsanshao.blogserver.model.Comment::getCreateAt));
        return commentTransfer.fromModel2View(commentPage.getRecords());
    }
}

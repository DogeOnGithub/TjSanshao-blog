package cn.tjsanshao.blogserver.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * article
 *
 * @author TjSanshao
 * @date 2020-04-24 10:21
 */
@Data
@Accessors(chain = true)
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;

    private String content;

    private Date time;

    private String tags;

    private String imageSrc;

    private String blogSrc;

    private String blogContent;
}

package cn.tjsanshao.blogserver.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * works
 *
 * @author TjSanshao
 * @date 2020-04-24 10:47
 */
@Data
@Accessors(chain = true)
public class Works implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;

    private String summary;

    private String tags;

    private String functions;

    private String imageSrc;

    private String worksSrc;
}

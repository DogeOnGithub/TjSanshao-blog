package cn.tjsanshao.blogserver.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * comment
 *
 * @author TjSanshao
 * @date 2020-04-24 17:07
 */
@Data
@Accessors(chain = true)
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private String nickName;

    private String content;

    private Date createAt;

    private Date updateAt;

    private Short deleteFlag;
}

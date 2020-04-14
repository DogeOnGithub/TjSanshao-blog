package cn.tjsanshao.blogserver.view;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * comment
 *
 * @author TjSanshao
 * @date 2020-04-10 14:32
 */
@Data
@Accessors(chain = true)
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nickName;

    private String content;

    private Date createAt;

    private Date updateAt;
}

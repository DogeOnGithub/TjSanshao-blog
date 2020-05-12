package cn.tjsanshao.blogserver.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * model banner
 *
 * @author TjSanshao
 * @date 2020-04-14 15:51
 */
@Data
@Accessors(chain = true)
public class Banner implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private String imageSrc;

    private Short deleteFlag;
}

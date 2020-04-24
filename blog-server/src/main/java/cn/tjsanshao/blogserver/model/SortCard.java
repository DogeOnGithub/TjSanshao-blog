package cn.tjsanshao.blogserver.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * sort card
 *
 * @author TjSanshao
 * @date 2020-04-23 10:05
 */
@Data
@Accessors(chain = true)
public class SortCard implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private String imageSrc;

    private String src;
}

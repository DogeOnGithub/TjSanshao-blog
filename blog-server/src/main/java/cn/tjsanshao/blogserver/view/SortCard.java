package cn.tjsanshao.blogserver.view;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * other page
 *
 * @author TjSanshao
 * @date 2020-04-09 16:30
 */
@Data
@Accessors(chain = true)
public class SortCard implements Serializable {
    private static final long serialVersionUID = 1L;

    private String imageSrc;

    private String src;
}

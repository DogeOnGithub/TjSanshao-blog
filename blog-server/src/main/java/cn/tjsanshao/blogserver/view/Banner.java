package cn.tjsanshao.blogserver.view;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * home page banner
 *
 * @author TjSanshao
 * @date 2020-04-08 15:18
 */
@Data
@Accessors(chain = true)
public class Banner implements Serializable {
    private static final long serialVersionUID = 1L;

    private String imageSrc;
}

package cn.tjsanshao.blogserver.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * home page main card
 *
 * @author TjSanshao
 * @date 2020-04-09 14:53
 */
@Data
@Accessors(chain = true)
public class MainCard implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;

    private String describe;

    private String button;

    private String image;

    private String itemKey;
}

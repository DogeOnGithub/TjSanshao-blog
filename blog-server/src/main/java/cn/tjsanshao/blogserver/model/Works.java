package cn.tjsanshao.blogserver.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * works
 *
 * @author TjSanshao
 * @date 2020-04-10 09:20
 */
@Data
@Accessors(chain = true)
public class Works implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;

    private String summary;

    private List<String> tags;

    private List<String> functions;

    private String imageSrc;

    private String worksSrc;
}

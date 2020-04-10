package cn.tjsanshao.blogserver.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * article
 *
 * @author TjSanshao
 * @date 2020-04-09 16:42
 */
@Data
@Accessors(chain = true)
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    private List<String> tags;

    private String imageSrc;

    private String blogSrc;
}

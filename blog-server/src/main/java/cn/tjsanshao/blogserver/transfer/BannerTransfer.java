package cn.tjsanshao.blogserver.transfer;

import cn.tjsanshao.blogserver.view.Banner;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author TjSanshao
 * @date 2020-04-14 16:00
 */
@Mapper(componentModel = "spring")
public interface BannerTransfer {
    Banner fromModel2View(cn.tjsanshao.blogserver.model.Banner banner);

    List<Banner> fromModel2View(List<cn.tjsanshao.blogserver.model.Banner> list);
}

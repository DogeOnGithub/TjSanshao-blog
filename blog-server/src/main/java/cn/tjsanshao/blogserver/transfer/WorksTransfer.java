package cn.tjsanshao.blogserver.transfer;

import cn.tjsanshao.blogserver.view.Works;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author TjSanshao
 * @date 2020-04-24 14:19
 */
@Mapper(componentModel = "spring")
public interface WorksTransfer {
    @Mappings({
            @Mapping(source = "tags", target = "tags", ignore = true),
            @Mapping(source = "functions", target = "functions", ignore = true)
    })
    Works fromModel2View(cn.tjsanshao.blogserver.model.Works works);
}

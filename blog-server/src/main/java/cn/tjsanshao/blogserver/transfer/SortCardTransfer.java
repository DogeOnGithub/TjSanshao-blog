package cn.tjsanshao.blogserver.transfer;

import cn.tjsanshao.blogserver.view.SortCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author TjSanshao
 * @date 2020-04-23 10:24
 */
@Mapper(componentModel = "spring")
public interface SortCardTransfer {
    SortCard fromModel2View(cn.tjsanshao.blogserver.model.SortCard sortCard);

    List<SortCard> fromModel2View(List<cn.tjsanshao.blogserver.model.SortCard> sortCards);
}

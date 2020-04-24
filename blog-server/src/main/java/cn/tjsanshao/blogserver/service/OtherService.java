package cn.tjsanshao.blogserver.service;

import cn.tjsanshao.blogserver.model.SortCard;
import cn.tjsanshao.blogserver.repository.SortCardRepository;
import cn.tjsanshao.blogserver.transfer.SortCardTransfer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * other page service
 *
 * @author TjSanshao
 * @date 2020-04-23 10:09
 */
@Service
public class OtherService {
    @Resource
    private SortCardRepository sortCardRepository;

    @Resource
    private SortCardTransfer sortCardTransfer;

    public List<String> tags;

    @PostConstruct
    public void initTags() {
        tags = new ArrayList<>();
        tags.add("JavaScript");
        tags.add("Java");
        tags.add("Vue");
        tags.add("Spring");
        tags.add("SpringBoot");
        tags.add("SpringCloud");
        tags.add("Dubbo");
    }

    public List<cn.tjsanshao.blogserver.view.SortCard> sortCards() {
        List<SortCard> sortCards = sortCardRepository.selectList(null);
        return sortCardTransfer.fromModel2View(sortCards);
    }
}

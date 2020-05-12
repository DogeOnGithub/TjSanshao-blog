package cn.tjsanshao.blogserver.service;

import cn.tjsanshao.blogserver.model.SortCard;
import cn.tjsanshao.blogserver.repository.SortCardRepository;
import cn.tjsanshao.blogserver.transfer.SortCardTransfer;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
        List<SortCard> sortCards = sortCardRepository.selectList(new LambdaQueryWrapper<SortCard>().eq(true, SortCard::getDeleteFlag, 0));
        return sortCardTransfer.fromModel2View(sortCards);
    }
}

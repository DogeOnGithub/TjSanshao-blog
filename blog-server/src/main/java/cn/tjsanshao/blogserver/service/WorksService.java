package cn.tjsanshao.blogserver.service;

import cn.tjsanshao.blogserver.repository.WorksRepository;
import cn.tjsanshao.blogserver.transfer.WorksTransfer;
import cn.tjsanshao.blogserver.view.Works;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * works service
 *
 * @author TjSanshao
 * @date 2020-04-24 10:56
 */
@Service
public class WorksService {
    @Resource
    private WorksRepository worksRepository;

    @Resource
    private WorksTransfer worksTransfer;

    public List<Works> works() {
        List<cn.tjsanshao.blogserver.model.Works> works = worksRepository.selectList(null);
        ArrayList<Works> viewWorks = new ArrayList<>();
        works.forEach(w -> {
            Works vw = worksTransfer.fromModel2View(w);
            vw.setTags(Arrays.asList(w.getTags().split(";")));
            vw.setFunctions(Arrays.asList(w.getFunctions().split(";")));
            viewWorks.add(vw);
        });
        return viewWorks;
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(cn.tjsanshao.blogserver.model.Works works) {
        worksRepository.insert(works);
    }
}

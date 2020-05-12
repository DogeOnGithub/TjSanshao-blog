package cn.tjsanshao.blogserver.service;

import cn.tjsanshao.blogserver.repository.BannerRepository;
import cn.tjsanshao.blogserver.transfer.BannerTransfer;
import cn.tjsanshao.blogserver.view.Banner;
import cn.tjsanshao.blogserver.view.MainCard;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * main page service
 *
 * @author TjSanshao
 * @date 2020-04-14 15:11
 */
@Service
public class MainService {
    @Resource
    private BannerRepository bannerRepository;

    @Resource
    private BannerTransfer bannerTransfer;

    public List<Banner> banner() {
        ArrayList<Banner> bannerList = new ArrayList<>();
        bannerList.add(new Banner().setImageSrc("http://q80ates4m.bkt.clouddn.com/image/banner1.jpg"));
        bannerList.add(new Banner().setImageSrc("http://q80ates4m.bkt.clouddn.com/image/banner2.jpg"));
        bannerList.add(new Banner().setImageSrc("http://q80ates4m.bkt.clouddn.com/image/banner3.jpg"));
        bannerList.addAll(bannerTransfer.fromModel2View(bannerRepository.selectList(new LambdaQueryWrapper<cn.tjsanshao.blogserver.model.Banner>().eq(true, cn.tjsanshao.blogserver.model.Banner::getDeleteFlag, 0))));
        return bannerList;
    }

    public List<MainCard> mainCard() {
        ArrayList<MainCard> mainCardList = new ArrayList<>();
        mainCardList.add(new MainCard().setTitle("My Blog").setDescribe("Desc").setImage("http://q80ates4m.bkt.clouddn.com/image/blog-img.jpg").setButton("Click to scan my blog").setItemKey("Blog"));
        return mainCardList;
    }
}

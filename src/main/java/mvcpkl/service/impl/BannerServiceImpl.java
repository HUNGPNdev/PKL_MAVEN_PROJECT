package mvcpkl.service.impl;

import mvcpkl.dao.BannerDAO;
import mvcpkl.entities.BannerEntity;
import mvcpkl.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service("bannerService")
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerDAO bannerDAO;

    @Override
    @Transactional
    public String addBanner(MultipartFile img, boolean stt) {
        return bannerDAO.addBanner(img, stt);
    }

    @Override
    @Transactional
    public List<BannerEntity> getAllBanner() {
        return bannerDAO.getAllBanner();
    }

    @Override
    @Transactional
    public String editBanner(int id, MultipartFile img, boolean stt) {
        return bannerDAO.editBanner(id, img, stt);
    }

    @Override
    @Transactional
    public BannerEntity getBannerById(int id) {
        return bannerDAO.getBannerById(id);
    }

    @Override
    @Transactional
    public void deleteBanner(int id) {
        bannerDAO.deleteBanner(id);
    }


}

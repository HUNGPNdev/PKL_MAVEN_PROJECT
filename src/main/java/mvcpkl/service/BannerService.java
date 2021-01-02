package mvcpkl.service;

import mvcpkl.entities.BannerEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BannerService {
    String addBanner(MultipartFile img, boolean stt);
    List<BannerEntity> getAllBanner();
    String editBanner(int id, MultipartFile img, boolean stt);
    BannerEntity getBannerById(int id);
    void deleteBanner(int id);
}

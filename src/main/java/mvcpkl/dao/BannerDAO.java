package mvcpkl.dao;

import mvcpkl.entities.BannerEntity;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface BannerDAO {
    String addBanner(MultipartFile img, boolean stt);
    List<BannerEntity> getAllBanner();
    String editBanner(int id, MultipartFile img, boolean stt);
    BannerEntity getBannerById(int id);
    void deleteBanner(int id);
}

package mvcpkl.dao.impl;

import mvcpkl.dao.BannerDAO;
import mvcpkl.entities.BannerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.TypedQuery;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Repository
public class BannerDaoImpl implements BannerDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String addBanner(MultipartFile img, boolean stt) {
        Path location = Paths.get("D:/JAVAWEB/MvcPkl/src/main/webapp/resources/images/banner/" + img.getOriginalFilename());
        try {
            Files.copy(img.getInputStream(),
                    location,
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            return "Lỗi lưu ảnh!";
        }
        sessionFactory.getCurrentSession().saveOrUpdate(new BannerEntity(img.getOriginalFilename(), stt));
        return "Đã Thêm";
    }

    @Override
    public List<BannerEntity> getAllBanner() {
        TypedQuery<BannerEntity> list =sessionFactory.getCurrentSession().createQuery("FROM BannerEntity", BannerEntity.class);
        return list.getResultList();
    }

    @Override
    public String editBanner(int id, MultipartFile img, boolean stt) {

        BannerEntity ban = sessionFactory.getCurrentSession().get(BannerEntity.class, id);
        ban.setStatus(stt);
        if (!img.isEmpty()) {
            ban.setName(img.getOriginalFilename());
            Path location = Paths.get("D:/JAVAWEB/MvcPkl/src/main/webapp/resources/images/banner/" + img.getOriginalFilename());
            try {
                Files.copy(img.getInputStream(),
                        location,
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                return "Lỗi lưu ảnh!";
            }
        }
        return "Đã Sửa";
    }

    @Override
    public BannerEntity getBannerById(int id) {
        return sessionFactory.getCurrentSession().get(BannerEntity.class, id);
    }

    @Override
    public void deleteBanner(int id) {
        Session seesion = sessionFactory.getCurrentSession();
        BannerEntity b = seesion.byId(BannerEntity.class).load(id);
        seesion.delete(b);
    }
}

package mvcpkl.dao.impl;

import mvcpkl.dao.ProductDAO;
import mvcpkl.dto.ProductDTO;
import mvcpkl.entities.ProductEntity;
import mvcpkl.service.CategoryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    CategoryService categoryService;

    @Override
    public void addProduct(ProductDTO p) {
        ProductEntity product;
        if (p.getId() == 0) {
            product = new ProductEntity(p.getId(), p.getName(), p.getPrice(), p.getDetails(), p.getGuarantee(),
                    p.getPart(), p.getSupport(), p.isStatus(), categoryService.getCataById(p.getCate_id()));
        } else {
            product = sessionFactory.getCurrentSession().get(ProductEntity.class, p.getId());
            product.setName(p.getName());
            product.setPrice(p.getPrice());
            product.setDetails(p.getDetails());
            product.setGuarantee(p.getGuarantee());
            product.setPart(p.getPart());
            product.setSupport(p.getSupport());
            product.setStatus(p.isStatus());
            product.setCategory(categoryService.getCataById(p.getCate_id()));
        }
        if (!p.getImage().isEmpty()) {
            product.setImage(p.getImage().getOriginalFilename());
            Path location = Paths.get("D:/JAVAWEB/MvcPkl/src/main/webapp/resources/images/product/" +
                    p.getImage().getOriginalFilename());
            try {
                Files.copy(p.getImage().getInputStream(),
                        location,
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.err.println("Lỗi Lưu Ảnh");
            }
        } else {
            product.setImage(p.getImg());
        }
        if (p.getId() == 0) {
            sessionFactory.getCurrentSession().saveOrUpdate(product);
        }
//            A different object with the same identifier value was already associated with the session
    }

    @Override
    public List<ProductEntity> getAllProduct() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<ProductEntity> typedQuery = session.createQuery("FROM ProductEntity", ProductEntity.class);
        List<ProductEntity> list = typedQuery.getResultList();
        return list;
    }

    @Override
    public ProductDTO getProById(int id) {
        ProductEntity p = sessionFactory.getCurrentSession().get(ProductEntity.class, id);
        ProductDTO pro = new ProductDTO(p.getId(),p.getName(),p.getPrice(),p.getDetails(),p.getGuarantee(),p.getPart(),p.getSupport(),
                p.getImage(),p.isStatus(),p.getCategory().getId());
        return pro;
    }

    @Override
    public void deletePro(int id) {
        ProductEntity p = sessionFactory.getCurrentSession().get(ProductEntity.class, id);
        sessionFactory.getCurrentSession().delete(p);
    }

    @Override
    public List<ProductEntity> getProByCate_id(int id) {
        List<ProductEntity> list = sessionFactory.getCurrentSession()
                .createQuery("select u From ProductEntity u where u.category.id = :id")
                .setParameter("id", id).getResultList();
        return list;
    }
}

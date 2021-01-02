package mvcpkl.dao.impl;

import mvcpkl.dao.CategoryDAO;
import mvcpkl.entities.CategoryEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDAO {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void addCate(CategoryEntity categoryEntity) {
        sessionFactory.getCurrentSession().saveOrUpdate(categoryEntity);
    }

    @Override
    public List<CategoryEntity> getAllCate() {
        List<CategoryEntity> list = sessionFactory.getCurrentSession()
                .createQuery("FROM CategoryEntity", CategoryEntity.class).getResultList();
        return list;
    }

    @Override
    public CategoryEntity getCataById(int id) {
        return sessionFactory.getCurrentSession().get(CategoryEntity.class, id);
    }

    @Override
    public void deleteCata(int id) {
        sessionFactory.getCurrentSession().delete(this.getCataById(id));
    }
}

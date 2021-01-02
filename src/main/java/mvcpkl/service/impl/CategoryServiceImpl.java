package mvcpkl.service.impl;

import mvcpkl.dao.CategoryDAO;
import mvcpkl.entities.CategoryEntity;
import mvcpkl.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    @Override
    public void addCate(CategoryEntity categoryEntity) {
        categoryDAO.addCate(categoryEntity);
    }

    @Override
    public List<CategoryEntity> getAllCate() {
        return categoryDAO.getAllCate();
    }

    @Override
    public CategoryEntity getCataById(int id) {
        return categoryDAO.getCataById(id);
    }

    @Override
    public void deleteCata(int id) {
        categoryDAO.deleteCata(id);
    }
}

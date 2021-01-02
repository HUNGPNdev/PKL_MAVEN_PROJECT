package mvcpkl.dao;

import mvcpkl.entities.CategoryEntity;

import java.util.List;

public interface CategoryDAO {
    void addCate(CategoryEntity categoryEntity);
    List<CategoryEntity> getAllCate();
    CategoryEntity getCataById(int id);
    void deleteCata(int id);
}

package mvcpkl.dao;


import mvcpkl.dto.ProductDTO;
import mvcpkl.entities.ProductEntity;

import java.util.List;

public interface ProductDAO {
    void addProduct(ProductDTO productDTO);
    List<ProductEntity> getAllProduct();
    ProductDTO getProById(int id);
    void deletePro(int id);
    List<ProductEntity> getProByCate_id(int id);
}

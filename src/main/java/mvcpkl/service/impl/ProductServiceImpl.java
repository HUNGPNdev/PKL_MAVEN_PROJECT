package mvcpkl.service.impl;

import mvcpkl.dao.ProductDAO;
import mvcpkl.dto.ProductDTO;
import mvcpkl.entities.ProductEntity;
import mvcpkl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Override
    public void addProduct(ProductDTO productDTO) {
        productDAO.addProduct(productDTO);
    }

    @Override
    public List<ProductEntity> getAllProduct() {
        return productDAO.getAllProduct();
    }

    @Override
    public ProductDTO getProById(int id) {
        return productDAO.getProById(id);
    }

    @Override
    public void deletePro(int id) {
        productDAO.deletePro(id);
    }

    @Override
    public List<ProductEntity> getProByCate_id(int id) {
        return productDAO.getProByCate_id(id);
    }
}

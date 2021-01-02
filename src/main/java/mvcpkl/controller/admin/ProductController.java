package mvcpkl.controller.admin;

import mvcpkl.dto.ProductDTO;
import mvcpkl.service.CategoryService;
import mvcpkl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("adProductController")
@RequestMapping("/admin/")
public class ProductController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping("product")
    public String addProduct(Model model) {
        model.addAttribute("title", "Product | Add");
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("cate", categoryService.getAllCate());
        return "backend/addProduct";
    }

    @PostMapping(value = "product", produces = "application/json; charset=UTF-8")
    public String postProduct(@ModelAttribute("product") ProductDTO pro) {
        productService.addProduct(pro);
        return "redirect:/admin/product";
    }

    @GetMapping(value = "product-list")
    public String getListProduct(Model model) {
        model.addAttribute("title", "Product | List");
        model.addAttribute("products", productService.getAllProduct());
        return "backend/list-pro";
    }

    @GetMapping(value = "product-update")
    public String proUpdate(Model model, @RequestParam("id") int id) {
        model.addAttribute("title", "Product | Update");
        model.addAttribute("product", productService.getProById(id));
        model.addAttribute("cate", categoryService.getAllCate());
//        System.out.println(productService.getProById(id));
        return "backend/addProduct";
    }

    @GetMapping(value = "product-delete")
    public String deleteProduct(@RequestParam("id") int id) {
        productService.deletePro(id);
        return "redirect:/admin/product-list";
    }


}

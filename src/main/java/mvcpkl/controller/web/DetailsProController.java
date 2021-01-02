package mvcpkl.controller.web;

import mvcpkl.entities.CartEntity;
import mvcpkl.service.BannerService;
import mvcpkl.service.CategoryService;
import mvcpkl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("pkl/")
public class DetailsProController {

    @Autowired
    ProductService productService;

    @Autowired
    BannerService bannerService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("details/{id}")
    public String getDetails(Model model, @PathVariable("id") int id, HttpSession session) {
        model.addAttribute("title", "Product - Details");
        model.addAttribute("categories", categoryService.getAllCate());
        model.addAttribute("banners", bannerService.getAllBanner());
        model.addAttribute("p", productService.getProById(id));
        model.addAttribute("count", ""+CountCart.getCountCart(session));
        return "web/proDetails";
    }
}

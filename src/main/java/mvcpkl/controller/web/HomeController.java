package mvcpkl.controller.web;

import mvcpkl.entities.CartEntity;
import mvcpkl.service.BannerService;
import mvcpkl.service.CategoryService;
import mvcpkl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("webHome")
@RequestMapping("pkl/")
public class HomeController {

    @Autowired
    BannerService bannerService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping(value = {"home", ""})
    public String getHome(Model model, HttpSession session) {
        model.addAttribute("banners", bannerService.getAllBanner());
        model.addAttribute("categories", categoryService.getAllCate());
        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("title", "Home");
        model.addAttribute("count", ""+CountCart.getCountCart(session));
        return "web/home";
    }

    @GetMapping("getProByCate_id")
    public String getProByCate(Model model, HttpSession session, @RequestParam("id") int id) {
        model.addAttribute("banners", bannerService.getAllBanner());
        model.addAttribute("categories", categoryService.getAllCate());
        model.addAttribute("products", productService.getProByCate_id(id));
        model.addAttribute("title", "Product");
        model.addAttribute("count", ""+CountCart.getCountCart(session));
        return "web/probycate";
    }




}

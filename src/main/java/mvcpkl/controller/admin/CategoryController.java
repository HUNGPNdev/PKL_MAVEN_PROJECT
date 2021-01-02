package mvcpkl.controller.admin;

import mvcpkl.entities.CategoryEntity;
import mvcpkl.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("adminCateController")
@RequestMapping("admin/")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("category")
    public String getCate(Model model) {
        model.addAttribute("title", "ADMIN | Category");
        model.addAttribute("cate" , new CategoryEntity());
        model.addAttribute("categories" , categoryService.getAllCate());
        return "backend/category";
    }

    @PostMapping("category")
    public String addCate(@ModelAttribute("cate") CategoryEntity cate) {
        categoryService.addCate(cate);
        return "redirect:/admin/category";
    }

    @GetMapping("category/update")
    public String updateCate(Model model, @RequestParam("id") int id) {
        model.addAttribute("title", "ADMIN | Category");
        model.addAttribute("cate" , categoryService.getCataById(id));
        model.addAttribute("categories" , categoryService.getAllCate());
        return "backend/category";
    }

    @GetMapping("category/delete")
    public String deleteCate(@RequestParam("id") int id) {
        categoryService.deleteCata(id);
        return "redirect:/admin/category";
    }
}

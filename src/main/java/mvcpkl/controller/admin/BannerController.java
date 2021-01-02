package mvcpkl.controller.admin;

import mvcpkl.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin/")
public class BannerController {

    @Autowired
    BannerService bannerService;

    @GetMapping("banner")
    public String getBanner(Model model) {
        model.addAttribute("title", "Banner");
        model.addAttribute("banners", bannerService.getAllBanner());
        return "backend/banner";
    }

    @PostMapping("banner")
    public String postBanner(Model model, @RequestParam("img") MultipartFile img, @RequestParam("status") boolean stt)
    {
        model.addAttribute("msg", bannerService.addBanner(img, stt));
        model.addAttribute("banners", bannerService.getAllBanner());
        return "backend/banner";
    }

    @GetMapping("banner/{id}")
    public String editBanner(@PathVariable("id") int id, Model model) {
        model.addAttribute("title", "Banner - Edit");
        model.addAttribute("banners", bannerService.getAllBanner());
        model.addAttribute("banner", bannerService.getBannerById(id));
        return "backend/banner";
    }

    @PostMapping("banner/{id}")
    public String editBanner(Model model, @PathVariable("id") int id, @RequestParam(value = "img", required = false) MultipartFile img,
                             @RequestParam("status") boolean stt)
    {
        model.addAttribute("msg", bannerService.editBanner(id, img, stt));
        model.addAttribute("title", "Banner");
        model.addAttribute("banners", bannerService.getAllBanner());
        return "backend/banner";
    }

    @GetMapping("banner/delete")
    public String deleteBanner(@RequestParam("id") int id) {
        bannerService.deleteBanner(id);
        return "redirect:/admin/banner";
    }
}

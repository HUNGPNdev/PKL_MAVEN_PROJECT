package mvcpkl.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminHome")
@RequestMapping("admin/")
public class HomeController {

    @GetMapping(value = {"home", ""} )
    public String getHome(Model model) {
        model.addAttribute("title", "Admin | Home");
        return "backend/home";
    }

}

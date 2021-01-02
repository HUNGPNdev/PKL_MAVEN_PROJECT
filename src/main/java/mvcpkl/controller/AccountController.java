package mvcpkl.controller;

import mvcpkl.dto.UserDTO;
import mvcpkl.entities.UserEntity;
import mvcpkl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/login")
    public String getLogin() {
        return "account/login";
    }

    @GetMapping("/account/edit")
    public String editAccount(Model model, Principal principal) {
        model.addAttribute("user", accountService.getUserByUsername(principal.getName()));
        return "account/addAcount";
    }

    @GetMapping("/account/regis")
    public String regisAccount(Model model) {
        model.addAttribute("user", new UserEntity());
        return "account/regisAcount";
    }

    @PostMapping("/account/regis")
    public String regisAccount(@ModelAttribute("user") UserEntity userEntity, Model model) {
        if (accountService.regisAccount(userEntity).equals("ok")) {
            model.addAttribute("msg", "Đăng ký thành công vui lòng đăng nhập!");
            return "account/login";
        }
        model.addAttribute("msg", "Username Đã tồn tại!");
        return "account/regisAcount";
    }

    @PostMapping("/account")
    public String postAccount(@ModelAttribute("user") UserDTO userDTO) {
        accountService.addUser(userDTO);
        return "redirect:/pkl/home";
    }


}

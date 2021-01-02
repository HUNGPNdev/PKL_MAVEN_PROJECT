package mvcpkl.controller.admin;

import mvcpkl.dao.impl.RoleDaoImpl;
import mvcpkl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller(value = "adminListUser")
@RequestMapping("/admin/")
public class ListUserController {

    @Autowired
    AccountService accountService;

    @Autowired
    RoleDaoImpl roleDao;

    @GetMapping("user-list")
    public String getListUser(Model model) {
        model.addAttribute("title", "User - List");
        model.addAttribute("users", accountService.getAllUser());
        model.addAttribute("roles", roleDao.getListRole());
        return "backend/userList";
    }

    @GetMapping("deleteUser")
    public String deleteUser(@RequestParam("user_id") int user_id) {
        accountService.deleteUser(user_id);
        return "redirect:/admin/user-list";
    }

    @PostMapping("user-edit-role/{id}")
    public String editUser(@RequestParam("role_id") int[] role_id, @PathVariable("id") int id) {
        accountService.editRole(id, role_id);
        return "redirect:/admin/user-list";
    }
}

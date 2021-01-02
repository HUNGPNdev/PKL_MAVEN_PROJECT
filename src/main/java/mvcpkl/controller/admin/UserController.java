package mvcpkl.controller.admin;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("test")
public class UserController {

   @GetMapping("/home")
   public String index() {
      return "index";
   }

   @GetMapping("/user")
   public String user(Principal principal) {
      return "user";
   }

   @GetMapping("/admin")
   public String admin() {
      // Get authenticated user name from SecurityContext
//      SecurityContext context = SecurityContextHolder.getContext();
//      System.out.println(context.getAuthentication().getName());
      return "admin";
   }

}

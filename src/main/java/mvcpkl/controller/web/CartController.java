package mvcpkl.controller.web;

import mvcpkl.entities.CartEntity;
import mvcpkl.service.BannerService;
import mvcpkl.service.CategoryService;
import mvcpkl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("pkl/")
public class CartController {

    @Autowired
    BannerService bannerService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    OrderService orderService;

    @GetMapping("shopping")
    public String getShoppingCart(Model model, HttpSession session, Principal principal) {
        model.addAttribute("title", "Shopping - Cart");
        model.addAttribute("categories", categoryService.getAllCate());
        model.addAttribute("banners", bannerService.getAllBanner());
        model.addAttribute("cartList", (List<CartEntity>) session.getAttribute("cart"));
        model.addAttribute("count", ""+CountCart.getCountCart(session));
        if (principal != null) {
            model.addAttribute("orderList", orderService.listOrder(principal.getName()));
        }
        return "web/cart";
    }

    @GetMapping("cart")
    public String addCart(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("price") double price,
                          @RequestParam("img") String img, HttpSession session) {
        this.setCart(id, name, price, img, session);
        return "redirect:/pkl/shopping";
    }

    @GetMapping("cartDelete/{id}")
    public String deleteCart(@PathVariable("id") int id, HttpSession session) {
        this.delCart(id, session);
        return "redirect:/pkl/shopping";
    }

    @GetMapping("cartDeleteAll")
    public String deleteAllCart(HttpSession session) {
        session.setAttribute("cart", new ArrayList<>());
        return "redirect:/pkl/shopping";
    }

    @GetMapping("order")
    public String orderProduct(HttpSession session, Principal principal) {
        orderService.orderProduct(session, principal);
        return "redirect:/pkl/shopping";
    }










    private void delCart(int id, HttpSession session) {
        if (session.getAttribute("cart") != null) {
            List<CartEntity> cart = (List<CartEntity>) session.getAttribute("cart");
            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).getPro_id() == id) {
                    cart.remove(i);
                    break;
                }
            }
            session.setAttribute("cart", cart);
        }
    }

    private void setCart(int id, String name, double price, String img, HttpSession session) {
        List<CartEntity> cart = new ArrayList<>();
        if (session.getAttribute("cart") == null) {
            cart.add(new CartEntity(id, 1, name, price, img));
            session.setAttribute("cart", cart);
        } else {
            cart = (List<CartEntity>) session.getAttribute("cart");
            int index = this.exists(id, cart);
            if (index == -1) {
                cart.add(new CartEntity(id, 1, name, price, img));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
        }
        session.setAttribute("cart", cart);
    }

    private int exists(int id, List<CartEntity> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getPro_id() == id) {
                return i;
            }
        }
        return -1;
    }

}

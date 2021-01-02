package mvcpkl.controller.admin;

import mvcpkl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("adminOrderCOntroller")
@RequestMapping("admin/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("order-list")
    public String getListOrder(Model model) {
        model.addAttribute("title", "Order - List");
        model.addAttribute("orderList", orderService.adminGetListOrder());
        return "backend/orderList";
    }

    @GetMapping("order-delete")
    public String deleteOrder(Model model, @RequestParam("id") int id) {
        orderService.deleteOrder(id);
        return "redirect:/admin/order-list";
    }

}

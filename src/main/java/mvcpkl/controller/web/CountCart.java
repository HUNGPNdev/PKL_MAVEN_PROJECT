package mvcpkl.controller.web;

import mvcpkl.entities.CartEntity;

import javax.servlet.http.HttpSession;
import java.util.List;

public class CountCart {

    public static int getCountCart(HttpSession session) {
        List<CartEntity> cart = (List<CartEntity>) session.getAttribute("cart");
        if (session.getAttribute("cart") == null) {
            return 0;
        } else {
            return cart.size();
        }
    }


}

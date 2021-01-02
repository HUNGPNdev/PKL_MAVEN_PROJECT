package mvcpkl.service.impl;

import mvcpkl.dao.OrderDAO;
import mvcpkl.entities.OrderEntity;
import mvcpkl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Override
    public void orderProduct(HttpSession session, Principal principal) {
        orderDAO.orderProduct(session, principal);
    }

    @Override
    public List<OrderEntity> listOrder(String username) {
        return orderDAO.listOrder(username);
    }

    @Override
    public List<OrderEntity> adminGetListOrder() {
        return orderDAO.adminGetListOrder();
    }

    @Override
    public void deleteOrder(int id) {
        orderDAO.deleteOrder(id);
    }
}

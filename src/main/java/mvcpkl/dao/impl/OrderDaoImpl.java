package mvcpkl.dao.impl;

import mvcpkl.dao.OrderDAO;
import mvcpkl.entities.CartEntity;
import mvcpkl.entities.OrderEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void orderProduct(HttpSession session, Principal principal) {
        List<CartEntity> cart = (List<CartEntity>) session.getAttribute("cart");
        for (CartEntity c: cart) {
            OrderEntity o = new OrderEntity(c.getPro_id(), c.getQuantity(), c.getName(), c.getPrice(), principal.getName(), c.getImg());
            sessionFactory.getCurrentSession().save(o);
        }
        session.setAttribute("cart", new ArrayList<>());
    }

    @Override
    public List<OrderEntity> listOrder(String username) {
        List<OrderEntity> list = sessionFactory.getCurrentSession()
                .createQuery("select u from OrderEntity u where u.username = :username")
                .setParameter("username", username).getResultList();
        return list;
    }

    @Override
    public List<OrderEntity> adminGetListOrder() {
        TypedQuery<OrderEntity> list = sessionFactory.getCurrentSession().createQuery("From OrderEntity", OrderEntity.class);
        return list.getResultList();
    }

    @Override
    public void deleteOrder(int id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(OrderEntity.class, id));
    }


}

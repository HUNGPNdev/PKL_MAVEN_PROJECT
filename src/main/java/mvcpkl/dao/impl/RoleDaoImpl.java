package mvcpkl.dao.impl;

import mvcpkl.entities.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleDaoImpl {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Role> getListRole() {
        TypedQuery<Role> list = sessionFactory.getCurrentSession().createQuery("From Role", Role.class);
        return list.getResultList();
    }

    @Transactional
    public List<Role> getRoleById(int[] role_id) {
        List<Role> roles = new ArrayList<>();
        for(int i: role_id) {
            roles.add(sessionFactory.getCurrentSession().get(Role.class, i));
        }
        return roles;
    }
}

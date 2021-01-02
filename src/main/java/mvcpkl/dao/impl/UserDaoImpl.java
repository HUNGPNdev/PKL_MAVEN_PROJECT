package mvcpkl.dao.impl;

import mvcpkl.dao.UserDAO;
import mvcpkl.entities.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public UserEntity findUserByUsername(String username) {
        return (UserEntity) sessionFactory.getCurrentSession()
                .createQuery("select u from UserEntity u where u.username = :username")
                .setParameter("username", username)
                .uniqueResult();
    }
}

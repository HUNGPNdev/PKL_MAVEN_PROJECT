package mvcpkl.dao.impl;

import mvcpkl.dao.AccountDAO;
import mvcpkl.dto.UserDTO;
import mvcpkl.entities.Role;
import mvcpkl.entities.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    RoleDaoImpl roleDao;

    @Override
    public void addUser(UserDTO u) {
        System.out.println(u);
        UserEntity user = sessionFactory.getCurrentSession().get(UserEntity.class, u.getUser_id());
        user.setUsername(u.getUsername());
        user.setEmail(u.getEmail());
        user.setFullname(u.getFullname());
        user.setAddress(u.getAddress());
        if(u.getPassword() != "") {
            user.setPassword(passwordEncoder.encode(u.getPassword()));
        }
        user.setGender(u.isGender());
    }

    @Override
    public List<UserEntity> getAllUser() {
        List<UserEntity> list = sessionFactory.getCurrentSession().createQuery("From UserEntity", UserEntity.class).getResultList();
        return list;
    }

    @Override
    public UserDTO getUserByUserName(String username) {
        UserEntity u = (UserEntity) sessionFactory.getCurrentSession()
                .createQuery("select u from UserEntity u where u.username = :username")
                .setParameter("username", username)
                .uniqueResult();
        return new UserDTO(u.getUser_id(), u.getUsername(),u.getEmail(),u.getFullname(), u.getAddress(), u.isGender());
    }

    @Override
    public void deleteUser(int id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(UserEntity.class, id));
    }

    @Override
    public String regisAccount(UserEntity userEntity) {
        UserEntity u = (UserEntity) sessionFactory.getCurrentSession()
                .createQuery("select u from UserEntity u where u.username = :username")
                .setParameter("username", userEntity.getUsername())
                .uniqueResult();
        System.out.println(u);
        if (u!=null) {
            return "exist";
        } else {
            List<Role> roles = new ArrayList<>();
            roles.add(sessionFactory.getCurrentSession().get(Role.class, 1));
            userEntity.setRoles(roles);
            sessionFactory.getCurrentSession().saveOrUpdate(userEntity);
        }
        return "ok";
    }

    @Override
    public void editRole(int user_id, int[] role_id) {
        UserEntity user = sessionFactory.getCurrentSession().get(UserEntity.class, user_id);
        List<Role> roles = roleDao.getRoleById(role_id);
        user.setRoles(roles);
    }
}

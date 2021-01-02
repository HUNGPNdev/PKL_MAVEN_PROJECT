package mvcpkl.service.impl;

import mvcpkl.dao.AccountDAO;
import mvcpkl.dto.UserDTO;
import mvcpkl.entities.UserEntity;
import mvcpkl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AcountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDAO accountDAO;

    @Override
    public void addUser(UserDTO userDTO) {
        accountDAO.addUser(userDTO);
    }

    @Override
    public List<UserEntity> getAllUser() {
        return accountDAO.getAllUser();
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return accountDAO.getUserByUserName(username);
    }

    @Override
    public void deleteUser(int id) {
        accountDAO.deleteUser(id);
    }

    @Override
    public String regisAccount(UserEntity userEntity) {
        return accountDAO.regisAccount(userEntity);
    }

    @Override
    public void editRole(int user_id, int[] role_id) {
        accountDAO.editRole(user_id, role_id);
    }
}

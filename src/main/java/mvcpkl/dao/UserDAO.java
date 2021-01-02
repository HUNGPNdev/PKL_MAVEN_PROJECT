package mvcpkl.dao;

import mvcpkl.entities.UserEntity;

public interface UserDAO {
    UserEntity findUserByUsername(String username);
}

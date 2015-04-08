package iva.cruddwebapp.service;

import iva.cruddwebapp.dao.UserDao;
import iva.cruddwebapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 01.04.15.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<User> getUsers(int page) {
        return userDao.getUsers(page);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public List<User> searchByName(String pattern, int page) {
        return userDao.searchByName(pattern, page);
    }

    @Override
    public List<User> getAllUsersAfterSearch(String pattern) {
        return userDao.getAllUsersAfterSearch(pattern);
    }


}

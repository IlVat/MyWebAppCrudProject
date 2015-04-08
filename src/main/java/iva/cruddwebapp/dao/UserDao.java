package iva.cruddwebapp.dao;

import iva.cruddwebapp.model.User;

import java.util.List;

/**
 * Created by Admin on 01.04.15.
 */
public interface UserDao {
    public void addUser(User user);

    public void updateUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);

    public List<User> getUsers(int page);

    public List<User> getAllUsers();

    public List<User> searchByName(String pattern, int page);

    public List<User> getAllUsersAfterSearch(String pattern);
}

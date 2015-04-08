package iva.cruddwebapp.dao;

import iva.cruddwebapp.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 01.04.15.
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addUser(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
  /*      User userToUpdate = getUser(user.getId());
        userToUpdate.setName(user.getName());
        userToUpdate.setAge(user.getAge());*/
        getCurrentSession().update(user);
    }

    @Override
    public User getUser(int id) {

        return (User) getCurrentSession().get(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        User user = getUser(id);
        if (user != null) {
            getCurrentSession().delete(user);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUsers(int page) {
        int limitEntryOnPage = 10;
        Query query = getCurrentSession().createQuery("from User");
        query.setFirstResult(limitEntryOnPage * page);
        query.setMaxResults(limitEntryOnPage);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {
        return getCurrentSession().createQuery("from User").list();
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<User> searchByName(String pattern, int page) {

        Query query = getCurrentSession().createQuery("from User as user where user.name like :code ");
        query.setParameter("code", pattern);
        int limitEntryOnPage = 10;
        query.setFirstResult(limitEntryOnPage * page);
        query.setMaxResults(limitEntryOnPage);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsersAfterSearch(String pattern) {
        Query query = getCurrentSession().createQuery("from User as user where user.name like :code");
        query.setParameter("code", pattern);
        return query.list();
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}

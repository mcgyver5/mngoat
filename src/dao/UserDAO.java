package dao;

import java.util.List;

import beans.User;

public interface UserDAO {

    List<User> findAll();
    List<User> findById();
    List<User> findByName(String name);
    boolean deleteById(int Id);
    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
}

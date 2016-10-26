package ua.golovchenko.artem.strategy.DAO;

import ua.golovchenko.artem.strategy.model.User;

import java.sql.SQLException;

/**
 * Created by art on 14.10.2016.
 */
public interface UserDAO {


    User get(Long id);
    User get(String login);
    User get(String login, String password);
    User create(User user) throws SQLException;
    void update(User user);
    void delete(User user);
    void deleteByLogin (String login);
    void deleteById(Long id);

}

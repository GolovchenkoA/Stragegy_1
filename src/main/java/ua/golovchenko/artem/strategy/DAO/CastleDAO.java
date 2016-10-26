package ua.golovchenko.artem.strategy.DAO;

import ua.golovchenko.artem.strategy.model.Castle;
import ua.golovchenko.artem.strategy.model.User;

import java.sql.SQLException;

/**
 * Created by art on 15.10.2016.
 */
public interface CastleDAO {

    Castle get (Long id);
    Castle get (User user);
    Castle create(Long userId, String castleName) throws SQLException; // Возвращает ID замка
}

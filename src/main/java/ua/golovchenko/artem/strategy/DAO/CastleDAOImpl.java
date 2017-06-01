package ua.golovchenko.artem.strategy.DAO;

import ua.golovchenko.artem.UtilityConnection;
import ua.golovchenko.artem.strategy.model.Castle;
import ua.golovchenko.artem.strategy.model.User;

import java.io.Serializable;
import java.sql.*;

/**
 * Created by art on 15.10.2016.
 */
public class CastleDAOImpl implements CastleDAO {

    Castle current_castle = Castle.getInstance();

    @Override
    public Castle get(Long id) {

        //Castle current_castle = new Castle();


        try(Connection con = UtilityConnection.createConnection()){
            if(con != null){
                PreparedStatement statement = con.prepareStatement("SELECT ID,NAME,UserID FROM CASTLES WHERE id = ?");
                statement.setLong(1,id);

                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()){
                    current_castle = getCastle(resultSet);
                }
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return current_castle;
    }

    @Override
    public Castle get(User user) {
        //System.out.println("Debug: Castle.get(User). UserId:" + user.getId()); //debug
        //Castle current_castle = new Castle();

        try(Connection con = UtilityConnection.createConnection()){
            if(con != null){
                PreparedStatement statement = con.prepareStatement("SELECT ID,NAME,UserID FROM CASTLES WHERE UserId = ?");
                statement.setLong(1,user.getId());

                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()){
                    current_castle = getCastle(resultSet);
                }
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return current_castle;
    }

    @Override
    public Castle create(Long userId, String castleName) throws SQLException {

        Castle new_castle = null;
        Long castleID = null;
        try(Connection connection = UtilityConnection.createConnection()){

            String query = "INSERT INTO CASTLES (NAME,USERID) VALUES(?,?)";
            PreparedStatement statement= connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, castleName);
            statement.setLong(2,userId);

            //for debug
            System.out.println("Отладка. User.DAOImpl.create Query : " + statement.toString());
            // Созраняем учетную запись замка в БД
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) {
                castleID = resultSet.getLong(1);
            }


            CastleDAO castleDAO = new CastleDAOImpl();
            new_castle = castleDAO.get(castleID);
            Long castle_id = new_castle.getId();

        }catch (SQLException e){
            System.out.println("Ошибка создания замка");
            e.printStackTrace();
        }

        System.out.println("Замок успешно создан");
        return new_castle;
    }


    private Castle getCastle(ResultSet resultSet) throws SQLException {
        //Castle castle = new Castle();
        Castle castle = Castle.getInstance();

        castle.setId(resultSet.getLong("id"));
        castle.setName(resultSet.getString("name"));
        castle.setUserId(resultSet.getLong("userID"));

        return castle;
    }

}

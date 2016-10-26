package ua.golovchenko.artem.strategy.DAO;

import ua.golovchenko.artem.UtilityConnection;
import ua.golovchenko.artem.strategy.model.User;

import java.sql.*;

/**
 * Created by art on 14.10.2016.
 */
public class UserDAOImpl implements UserDAO {



    public User get(Long id) {
        User local_user = new User();

        try(Connection connection = UtilityConnection.createConnection()){
            String query = "SELECT ID,NAME,LOGIN,PASSWORD FROM USERS WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                local_user = getUser(resultSet);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

        /*System.out.println("UserDAOImpl получен пользователь из БД: " + local_user.toString());*/
        return local_user;
    }

    public User get(String login) {
        User local_user = new User();

        try(Connection connection = UtilityConnection.createConnection()){

            PreparedStatement statement = connection.prepareStatement("SELECT ID,Login,NAME FROM USERS WHERE login = ?");
            statement.setString(1,login);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                local_user = getUser(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return local_user;
    }

    public User get(String login, String password) {

        User local_user = new User();
        try(Connection connection = UtilityConnection.createConnection()){
            if(connection != null){
                PreparedStatement statement = connection.prepareStatement("SELECT ID,Login,NAME FROM USERS WHERE login = ? and password = ?");
                statement.setString(1,login);
                statement.setString(2,password);

                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()){
                    local_user = getUser(resultSet);
                }
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return local_user;
    }

    public User create(User user) throws SQLException {

        User new_user = null;
        Long new_user_id = -1L;
        try(Connection connection = UtilityConnection.createConnection()){


            // Инициализация запроса для создания учетной записи пользователя
            String query = "INSERT INTO USERS (NAME,LOGIN,PASSWORD) VALUES(?,?,?)";
            PreparedStatement statement = statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,user.getName());
            statement.setString(2,user.getLogin());
            statement.setString(3,user.getPassword());

            //for debug
            System.out.println("User.DAOImpl.create Query : " + statement.toString());
            // Созраняем учетную запись пользователя в БД
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                new_user_id = resultSet.getLong(1);
                System.out.println("New_user_id = " + new_user_id);
            }


            // Получаем нового пользователя из БД (вместе с ID)
            UserDAO userDAO = new UserDAOImpl();
            new_user = userDAO.get(new_user_id);

/*            if(new_user != null){
                System.out.println(new_user.toString());
            }else {
                System.out.println("Пользователь не получен из БД (но он там может быть)");
            }*/



        } catch (SQLException e) {
            System.out.println("Ошибка создания учетной записи пользователя");
            e.printStackTrace();
        }

        System.out.println("Учетная запись пользователя создана");
        return new_user;
    }

    public void update(User user) {

    }

    public void delete(User user) {

    }

    public void deleteByLogin(String login) {

    }

    public void deleteById(Long id) {

    }

    private User getUser(ResultSet resultSet) throws SQLException{
        User user = new User();

        /*if (resultSet.next()) {*/
            user.setId(resultSet.getLong("ID"));
            user.setLogin(resultSet.getString("Login"));
            user.setName(resultSet.getString("name"));
        /*}*/

        return user;
    }
}

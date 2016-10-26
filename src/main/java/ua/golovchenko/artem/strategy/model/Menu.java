package ua.golovchenko.artem.strategy.model;

import ua.golovchenko.artem.strategy.DAO.CastleDAO;
import ua.golovchenko.artem.strategy.DAO.CastleDAOImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by art on 16.10.2016.
 */
public class Menu{

    private User user;
    private CastleDAO castleDAO = new CastleDAOImpl();;
    private Castle castle;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;


    public Menu(User user) {
        this.user = user;
        castle = castleDAO.get(this.user.getId());
    }

    public void getCastleBuildings(){
        System.out.format("Свободных клеток в замке: %d \n \n",castle.getGameField().getFreeCellsCount());
    }

    public void getCastleCell(int i){

        CastleCell cell = new CastleCell();
        cell = Castle.getCell(i);



        System.out.println("Информация о клетке " + cell);

        // Варианты действий с клеткой поля
        if(cell.isFree() == true){ // если клетка свободна
            System.out.println("Желаете построить здание? (y/n)");

            // Получение ответа от пользователя
            try {
                input = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }


            // Результат выбора пользователя
            switch (input) {
                case "y":
                    //!!!!!!!!!!!!!!!!! дописать просмотр инфы о клетке
                    System.out.println("Доступные здания: ");

                    Castle.getAllBuildingsName();

                    break;
                case "n": break;
                    default: System.out.println("Введен неправильный параметр (по умолчанию n(нет)" ); break;
            }

        }else { // если клетка  занята
            // Просмотр информации о доступных зданиях
            System.out.format("Информация о здании в этой клетке: %s", cell.getBuildingOnCell().toString());

            // ДОПИСАТЬ КОД по доступным вариантам действий со зданием
            System.out.println("!!!! КОД НЕ ДОПИСАН.");

 /*            System.out.println("Войти что необходимо выполнить ");
            // Получение ответа от пользователя
            try {
                input = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("!!!! КОД НЕ ДОПИСАН.");
           // Результат выбора пользователя
            switch (input) {
                case "y":
                    break;
                case "n": break;
                default: System.out.println("Введен неправильный параметр (по умолчанию n(нет)" ); break;
            }*/
        }


    }


}

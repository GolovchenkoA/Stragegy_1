package ua.golovchenko.artem.strategy;

import org.fusesource.jansi.Ansi;
import ua.golovchenko.artem.strategy.DAO.CastleDAO;
import ua.golovchenko.artem.strategy.DAO.CastleDAOImpl;
import ua.golovchenko.artem.strategy.DAO.UserDAO;
import ua.golovchenko.artem.strategy.DAO.UserDAOImpl;
import ua.golovchenko.artem.strategy.model.Castle;
import ua.golovchenko.artem.strategy.model.GameDisplay;
import ua.golovchenko.artem.strategy.model.GameDisplayMain;
import ua.golovchenko.artem.strategy.model.User;
import ua.golovchenko.artem.strategy.model.menu.*;
import ua.golovchenko.artem.strategy.model.resources.ResourceManager;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.Color.*;

public class Main {

    public static boolean theGameContinues = true;

    public static void main(String[] args) {


        Console console = null;
        User user = null;
        UserDAO userDAO = new UserDAOImpl();
        CastleDAO castleDAO = new CastleDAOImpl();;
        Castle castle = Castle.getInstance();

        // Значения введенные пользователем при создании пользователя и замка
        String name;
        String login;
        String password;
        String castle_name;

        AnsiConsole.systemInstall();
        System.out.println("\033[32m Game: Strategy");
        AnsiConsole.out().print(Ansi.ansi().reset().fg(Ansi.Color.WHITE));


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        try { // Вход и регистрация игрока
                System.out.println("Пожалуйста введите ваш логин и пароль");


                login = br.readLine();
                password = br.readLine();
/*                System.out.println("Сейчас пароль вводится автоматически (user\\user) \n");
                login = "user";
                password = "user";
                System.out.println("------------------------");*/
                //System.out.format("Login : %s , Password : %s" ,login, password);

                //Поиск пользователя в БД
                user = userDAO.get(login,password);


            String login_in_db;
            try {
                // if user doesn't exist in db - throw java.lang.NullPointerException
                login_in_db = user.getLogin().toString();
            } catch (java.lang.NullPointerException e){
                login_in_db = null;
            }

            //Информация о пользователе
                if (login_in_db != null && login_in_db.equals(login)){

                    castle = castleDAO.get(user);

                    System.out.format("Ваши данные пользователя с ID: %d  , Login: %s , Name: %s . Имя замка: %s ",
                            user.getId(), user.getLogin(), user.getName(), castle.getName());

                    // Регистрация нового пользователя
                }else {
                    System.out.println("Пользователь не найден. Предлагаем Вам зарегистрироваться");
                    System.out.println("Пожалуйста введите ваше Имя, Логин и Пароль");

                    name = br.readLine();
                    login = br.readLine();
                    password = br.readLine();

                    user.setName(name);
                    user.setLogin(login);
                    user.setPassword(password);



                    // Создаем учетную запись пользователя
                    try{

                        user = userDAO.create(user); ///  !!!!!!!!!!!!!!!!!!!ПРОБЛЕМА. Здесь при возврате объекта пользователя (если использовать обещго user) нет ИД пользователя
                        System.out.println("Отладка. UserDAOImpl получен пользователь из БД: " + user.toString());
                    }
                    catch (SQLException e){
                        e.printStackTrace();
                    }

                    // Создаем замок пользователя
                    System.out.println("Пожалуйста введите имя вашего замка");
                    castle_name = br.readLine();


                        castle = castleDAO.create(user.getId(), castle_name);

                    //Выводим на консоль сообщение с информацией о созданном пользователе и замке
                        System.out.format("Ваши данные пользователя с ID: %d  , Login: %s , Name: %s . Имя замка: %s \n",
                                user.getId(), user.getLogin(), user.getName(), castle.getName());


                }



            //Консоль игры

                    // Удаляем предыдущую информацию с консоли
            {
                try {
                    final String os = System.getProperty("os.name");
                    if (os.contains("Windows"))

                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                    else {
                        Runtime.getRuntime().exec("clear");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }




                    // Меню игрока

            //переменная в которой будет храниться результат выбора пункта меню игроком
            String selection;
            Scanner console_input = new Scanner(System.in);

            // Составляем меню
            MenuComponent mainMenu = new Menu("Main menu", "");
            MenuComponent cellMenu = new Menu("Cell Menu", "Action with cells");

            cellMenu.add(new CellInfo());
            cellMenu.add(new CellInfoAll());
            cellMenu.add(new CreateBuildingOnCell("Create Building","Create building on current cell"));

            mainMenu.add(cellMenu);
            mainMenu.add(new ExitMenuItem("Exit","Exit from game"));


            GameMenu gameMenu = new GameMenuImpl(mainMenu);

            // Ресурсы игрока
            //Gold gold = new Gold();
            //castle.addGold(gold.getAmount());

            CastleInfo castleInfoPanel = new CastleInfoMain(); //Панель с информацией
            GameDisplay gameDisplayWindows = new GameDisplayMain(castleInfoPanel,gameMenu);





             // -----------------Запуск процессов по управлению ресурсами замка
                  Thread resource_manager_thread = new ResourceManager(castle);
                   //resource_manager_thread.start();
                //-----------------------------------------------------------




            // Необходимо для проверки значений, которые ввел игрок
            Pattern p = Pattern.compile("^\\d+$"); // Только целые числа
            Matcher numberMatcher;


            do{ // Отображение главного окна игры


                gameDisplayWindows.display();

                    //Считывание значений пользователя
                     selection = console_input.next();

                     numberMatcher = p.matcher(selection);
                     try {
                         //если ввели число целое положительно и не больше чем количество команд в меню
                         if (numberMatcher.matches() && gameMenu.getCurrentMenuItemsCount() >= Integer.parseInt(selection) - 1) {

                             gameMenu.setCurrentMenuItem(Integer.parseInt(selection) - 1);
                             //gameMenu.executeCurrentMenuItem();
                         } else {
                             System.out.println("Введите правильный номер команды");
                         }
                     } catch (Exception e) {

                         System.out.println("Ошибка при получении значения, который ввел игрок");
                         System.out.println("Введите значение еще раз");
                         e.printStackTrace();
                     }

            }while (!(gameMenu.getLast_command() instanceof ExitMenuItem));

            // Завершение работы фоновых потоков
            //resource_manager_thread.interrupt();
            Main.theGameContinues = false; // Все фоновые потоки завершаются


        }catch (SQLException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}

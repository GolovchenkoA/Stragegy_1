package ua.golovchenko.artem.strategy.model;

import ua.golovchenko.artem.strategy.model.buildings.Building;
import ua.golovchenko.artem.strategy.model.buildings.House;
import ua.golovchenko.artem.strategy.model.buildings.RealBuilding;
import ua.golovchenko.artem.util.ClassFinder;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by art on 14.10.2016.
 */
public class Castle {

    private static GameField gameField = new GameFieldReal();
    private static final int DEFAULT_GOLD_PER_MINUTE = 10;
    private static Map<String,Building> allBuildings = new TreeMap<>(); // Небезопасно ставить ? но с ограничением по extend Building не получилось

   static {

        // ИНИЦИАЛИЗАЦИЯ МАССИВА ДОСТУПНЫХ ЗДАНИЙ
        // получение списка всех классов зданий
        List<Class<?>> buildings_classes = ClassFinder.find("ua.golovchenko.artem.strategy.model.buildings");

        for(Class building : buildings_classes) {

            //if (!Modifier.isAbstract(building.getModifiers()) && !building.getSimpleName().equals("BuildingsType")) { // если класс не абстрактный
            if (building.isAnnotationPresent(RealBuilding.class)){
                Building b = null;
                try {
                    //System.out.println(building.getSimpleName());
                    b = (Building) building.newInstance(); // создаем объект класса
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                allBuildings.put(building.getSimpleName(), b); // добавляем объект класса в массив
            }
        }
    }


    private Long id;
    private String name;
    private Long userId;
    private int totalGoldPerMinute; // показатель будет повышать постройка дополнительных зданий
    private int totalGold; // Всего золота у пользователя, которое можно использовать
    private int Humans; //количество людей


    public Castle(){};

    public Castle(String name, Long userId) {
        this.name = name;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getTotalGoldPerMinute() {
        return totalGoldPerMinute;
    }

    public void setTotalGoldPerMinute(int totalGoldPerMinute) {
        this.totalGoldPerMinute = DEFAULT_GOLD_PER_MINUTE;
    }

    public int getTotalGold() {
        return totalGold;
    }

    public void setTotalGold(int totalGold) {
        this.totalGold = totalGold;
    }

    public void addGold(int gold){
        this.totalGold +=gold;
    }

    public void reduceGold(int gold){
        this.totalGold -= gold;
    }

    public GameField getGameField(){
        return gameField;
    }

    public void setGameField(GameField gameField){
        this.gameField = gameField;
    }

    public void getBuildings(){

    }

    /**
     *
     * @return - возвращает общее количество людей в замке.
     *          Данный параметр генерируется перебором всех клеток. и если в клетке есть постройка "House"
     *          берется значение параметра
     */
    public int getHumans() {

        int totalHumansOnCastle = 0;

        for(CastleCell castleCell : gameField.getCells()){
            if(castleCell.getBuildingOnCell().getClass().equals(House.class)){
                totalHumansOnCastle += ((House) castleCell.getBuildingOnCell()).getLivesPeople();
            }
        }
        return totalHumansOnCastle;
    }

    public void setHumans(int humans) {
        Humans = humans;
    }

    public static Map<String, Building> getAllBuildings() {
        return allBuildings;
    }

    public static void getAllBuildingsName(){

        // Получаем список имен (имен классов) всех зданий
        for(Map.Entry<String, Building> build : allBuildings.entrySet()){
            System.out.println(build.getValue().getName());

        }
    }

    public static CastleCell getCell(int i){
        return gameField.getCell(i);
    }

}

package ua.golovchenko.artem.strategy.model;

import ua.golovchenko.artem.strategy.model.buildings.Building;
import ua.golovchenko.artem.strategy.model.buildings.House;
import ua.golovchenko.artem.util.ClassFinder;

import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Created by art on 14.10.2016.
 */
public class Castle {

    private static final int TOTAL_CASTLE_CELLS = 25-1;
    private static final int DEFAULT_GOLD_PER_MINUTE = 10;
    public static final List<CastleCell> cells = new ArrayList<CastleCell>(TOTAL_CASTLE_CELLS);
    private static Map<String,Building> allBuildings = new TreeMap<>(); // Небезопасно ставить ? но с ограничением по extend Building не получилось

    static {
        // Инициализация клеток поля
        for(int i = 0; i <= TOTAL_CASTLE_CELLS; i++){
            cells.add(new CastleCell(i)) ;
        }

        // ИНИЦИАЛИЗАЦИЯ МАССИВА ДОСТУПНЫХ ЗДАНИЙ
        // получение списка всех классов зданий
        List<Class<?>> buildings_classes = ClassFinder.find("ua.golovchenko.artem.strategy.model.buildings");

        for(Class building : buildings_classes) {
            if (!Modifier.isAbstract(building.getModifiers()) && !building.getSimpleName().equals("BuildingsType")) { // если класс не абстрактный
                Building b = null;
                try {
                    System.out.println(building.getSimpleName());
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
    private int freeCellsCount = 0;
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

    public int getFreeCellsCount() {

        updateFreeCellsCount();
        return freeCellsCount;
    }

    public void updateFreeCellsCount() {

        int freeCells = 0;

        for(CastleCell cell : cells) {
            if (cell.isFree()) {
                freeCells++;
            }
        }
        this.freeCellsCount = freeCells;
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

        for(CastleCell castleCell : cells){
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
}

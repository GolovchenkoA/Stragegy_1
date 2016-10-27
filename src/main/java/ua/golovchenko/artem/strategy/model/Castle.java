package ua.golovchenko.artem.strategy.model;

import ua.golovchenko.artem.strategy.model.buildings.Building;
import ua.golovchenko.artem.strategy.model.buildings.GoldMine;
import ua.golovchenko.artem.strategy.model.buildings.House;
import ua.golovchenko.artem.strategy.model.buildings.RealBuilding;
import ua.golovchenko.artem.strategy.model.resources.Gold;
import ua.golovchenko.artem.strategy.model.resources.ResourceAbstract;
import ua.golovchenko.artem.strategy.model.resources.ResourceObserver;
import ua.golovchenko.artem.strategy.model.resources.ResourcesObservable;
import ua.golovchenko.artem.util.ClassFinder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by art on 14.10.2016.
 */
public class Castle implements ResourceObserver {

    private static Castle instance;
    private static GameField gameField = new GameFieldReal();
    private static final Long DEFAULT_GOLD_PER_MINUTE = 10L;
    private Long goldPerMinute = DEFAULT_GOLD_PER_MINUTE; // по умолчанию. далее значение будет изменяться(например постройка зданий)

    // Список задний доступных для постройки
    private static Set<Building> availableBuildings = new HashSet<>(); // Небезопасно ставить ? но с ограничением по extend Building не получилось


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
                availableBuildings.add(b); // добавляем объект класса в массив
            }
        }
    }


    public static void getAvailableBuildingsName(){
            int i = 0;
        // Получаем список имен (имен классов) всех зданий
        for(Building build : availableBuildings){
            System.out.println(++i +". " + build.getName());

        }
    }

    public static Set<Building> getAvailableBuildings(){
        return availableBuildings;
    }

    public static CastleCell getCell(int i){
        return gameField.getCell(i);
    }
    public static List<CastleCell> getCells(){
        return gameField.getCells();
    }




    private Long id;
    private String name;
    private Long userId;
    private Gold goldInCastle  = new Gold();// Всего золота у пользователя, которое можно использовать
    private int humans; //количество людей



    private Castle(){

        goldInCastle.setAmount(10L);
    };

/*    public Castle(String name, Long userId) {
        this.name = name;
        this.userId = userId;
    }*/

    public static Castle getInstance(){
        if(instance == null)
            instance = new Castle();

        return instance;
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

    public Long getTotalGoldPerMinute() {
        return goldPerMinute;
    }

    private void addTotalGoldPerMinute(Long amount){goldPerMinute += amount;}

    public Long getTotalGold() {
        return goldInCastle.getAmount();
    }

    public void setTotalGold(Long totalGold) {
        goldInCastle.setAmount(totalGold);
    }

    public void  addGold(Long gold){
        goldInCastle.increace(gold);
    }

    public void reduceGold(Long gold){
        goldInCastle.decreace(gold);
    }

    public Gold getGold(){
        return goldInCastle;
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
    public int getFreeHumans() {

        int totalHumansOnCastle = 0;

        for(CastleCell castleCell : gameField.getCells()){
            if(castleCell.getBuildingOnCell().getClass().equals(House.class)){
                totalHumansOnCastle += ((House) castleCell.getBuildingOnCell()).getLivesPeople();
            }
        }
        return totalHumansOnCastle;
    }

    public void setHumans(int humans) {
        humans = humans;
    }


    public int getFreeCellsCount(){
        int i = 0;
        for(CastleCell castleCell : gameField.getCells()){
            if(castleCell.isFree()){
                i++;
            }
        }
        return  i;
    }


    @Override
    public void update(ResourcesObservable o, ResourceAbstract.ResourcesType type) {
        if(o instanceof GoldMine){
            long i = ((GoldMine) o).getResourceGrowth();
            addTotalGoldPerMinute(i);
        }
    }
}

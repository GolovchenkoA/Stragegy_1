package ua.golovchenko.artem.strategy.model.buildings;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import ua.golovchenko.artem.strategy.model.Castle;
import ua.golovchenko.artem.strategy.model.CastleCell;
import ua.golovchenko.artem.strategy.model.resources.ResourcesObservable;

/**
 * Created by art on 26.10.2016.
 *
 * Pattern: Singlton
 */
public class BuildingConstructorReal extends BuildingConstructorAbstract implements BuildingConstructor {

    private static BuildingConstructorReal instance;
    private boolean allowConstruction = false;
    private Castle castle = Castle.getInstance();


    public static BuildingConstructorReal getInstance(){
        if(instance == null){
            instance = new BuildingConstructorReal();
        }
        return instance;
    }


    public boolean beginConstruction(Building building, CastleCell castleCell){
        boolean constructionBegan = false;

        if(castle.getTotalGold() < building.getCost()){
            System.out.println("Недостаточно суммы для постройки");
        }else if(!castleCell.isFree()){
            System.out.println("На этой клетке уже есть здание");
        }else {
            // Если не возникло проблем строим здание
            constructionBegan = true;
            synchronized (this){
                castle.reduceGold(building.getCost());
                castleCell.setFree(false);
                castleCell.setBuildingUnderConstruction(true);


                // / Запускаем строительство в отдельном потоке
                Runnable task = () -> {

                    // Действия перед постройкой
                    if(building instanceof GoldMine){
                        ((ResourcesObservable)building).registerObserver(castle);
                    }


                    // Постройка здания
                    castleCell.setBuildingOnCell(building);

                    /**
                     * building.getSpeedOfConstruction_minutes() return number of minutes
                     * to build a building. This value is multiplied by 60000
                     *
                     */
                    Long constructionTime = (long) building.getSpeedOfConstruction_minutes() * 60000;


                    try {

                        Thread.sleep(constructionTime);

                        // set up after construction complete
                        building.setBuildingConstructed(true);
                        castleCell.setBuildingUnderConstruction(false);

                        // display informatoin to console
                        //System.out.println("\n Отладка. Постройка здания " + building.getName() + "на клетке № (id) " + castleCell.getId() + "Закончено");
                        System.out.println("\033[33m \n  Постройка здания " + building.getName() + "на клетке № " + (castleCell.getId() + 1) +" завершено");
                        AnsiConsole.out().print(Ansi.ansi().reset().fg(Ansi.Color.WHITE));



                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        castleCell.setBuildingUnderConstruction(false);
                    }

                    // notify observers after construction complete
                    try{
                        ((ResourcesObservable)building).notifyObservers();
                    }catch (Exception e){


                        //System.out.format("Здание %s не реализует интерфейс ResourcesObservable ",building.getName());
                        System.out.println("\033[32m Здание " + building.getName() + " не реализует интерфейс ResourcesObservable");
                         AnsiConsole.out().print(Ansi.ansi().reset().fg(Ansi.Color.WHITE));
                    }


                };

                Thread t = new Thread(task);
                t.start();

            }
        }

        return constructionBegan;
    }






    public synchronized boolean isAllowConstruction() {
        return allowConstruction;
    }

    public synchronized void setAllowConstruction(boolean allowConstruction) {
        this.allowConstruction = allowConstruction;
    }
}

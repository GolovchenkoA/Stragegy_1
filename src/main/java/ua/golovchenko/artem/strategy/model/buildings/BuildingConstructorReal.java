package ua.golovchenko.artem.strategy.model.buildings;

import ua.golovchenko.artem.strategy.model.Castle;
import ua.golovchenko.artem.strategy.model.CastleCell;

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
                    castleCell.setBuildingOnCell(building);

                    Long constructionTime = (long) building.getSpeedOfConstruction_minutes() * 60000;
                    try {
                        Thread.sleep(constructionTime);
                        castleCell.setBuildingUnderConstruction(false);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        castleCell.setBuildingUnderConstruction(false);
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

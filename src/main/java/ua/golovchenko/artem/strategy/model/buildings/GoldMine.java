package ua.golovchenko.artem.strategy.model.buildings;

import ua.golovchenko.artem.strategy.model.resources.ResourceAbstract;
import ua.golovchenko.artem.strategy.model.resources.ResourceObserver;
import ua.golovchenko.artem.strategy.model.resources.ResourcesObservable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by art on 15.10.2016.
 */

@RealBuilding
public class GoldMine extends Industrial implements ResourcesObservable {

    List<ResourceObserver> observers = new LinkedList<>();

    private int resourceGrowth = 10; // добавляет прирост золота в минуту

    public GoldMine(){
        super.setType(BuildingsType.INDUSTRIAL);
        super.setCost(10L);
        super.setName("Gold Mine");
        super.setMaxUnitsInBuilding(0);
        super.setSpeedOfConstruction_minutes(0);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setType(BuildingsType type) {
        super.setType(type);
    }

    @Override
    public void setCost(Long cost) {
        super.setCost(cost);
    }

    @Override
    public void setSpeedOfConstruction_minutes(int speedOfConstruction_minutes) {
        super.setSpeedOfConstruction_minutes(speedOfConstruction_minutes);
    }

    @Override
    public boolean isBuildingConstructed() {
        return super.isBuildingConstructed();
    }


    @Override
    public void registerObserver(ResourceObserver o) {
        observers.add(o);

    }

    @Override
    public void removeObserver(ResourceObserver o) {
        observers.remove(o);

    }

    @Override
    public void notifyObservers() {
        for(ResourceObserver observer: observers){
            observer.update(this, ResourceAbstract.ResourcesType.GOLD);
        }

    }

    public int getResourceGrowth() {
        return resourceGrowth;
    }
}

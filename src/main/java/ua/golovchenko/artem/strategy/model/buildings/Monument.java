package ua.golovchenko.artem.strategy.model.buildings;

import ua.golovchenko.artem.strategy.model.resources.ResourceAbstract;
import ua.golovchenko.artem.strategy.model.resources.ResourceObserver;
import ua.golovchenko.artem.strategy.model.resources.ResourcesObservable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by art on 17.10.2016.
 */
@RealBuilding
public class Monument extends Decoration implements ResourcesObservable {

    List<ResourceObserver> observers = new LinkedList<>();

    public Monument(){
        super.setType(BuildingsType.DECORATION);
        super.setCost(5L);
        super.setName("Castle Monument");
        super.setMaxUnitsInBuilding(0);
        super.setSpeedOfConstruction_minutes(1);
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
            observer.update(this, ResourceAbstract.ResourcesType.NOTHING);
        }

    }

}

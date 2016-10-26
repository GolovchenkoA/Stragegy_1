package ua.golovchenko.artem.strategy.model.buildings;

import ua.golovchenko.artem.strategy.model.Castle;

/**
 * Created by art on 26.10.2016.
 */
public abstract class BuildingConstructorAbstract {

    private Castle castle;
    private Building building;


    public void setCastle(Castle castle) {
        this.castle = castle;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}

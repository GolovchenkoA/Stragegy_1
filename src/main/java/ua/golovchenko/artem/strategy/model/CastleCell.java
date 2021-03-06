package ua.golovchenko.artem.strategy.model;

import ua.golovchenko.artem.strategy.model.buildings.Building;

/**
 * Created by art on 14.10.2016.
 */
public class CastleCell {

    private int id;
    private boolean isFree = true;
    private Building buildingOnCell;
    private boolean isBuildingUnderConstruction = false;

    //private Map<Integer,Building> buildingOnCell; //Integer - Cell id, Building - Building
    //private List<Building> allAvailableBuildings = new

    public CastleCell(){}

    public CastleCell(int id) {
        this.setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean i) {
        isFree = i;
    }

    public Building getBuildingOnCell() {
        return buildingOnCell;
    }

    public boolean isBuildingUnderConstruction() {
        return isBuildingUnderConstruction;
    }

    public void setBuildingUnderConstruction(boolean buildingUnderConstruction) {
        isBuildingUnderConstruction = buildingUnderConstruction;
    }

    public void setBuildingOnCell(Building buildingOnCell) {
        this.buildingOnCell = buildingOnCell;
    }

    @Override
    public String toString() {
        String cell= "ID: " + (getId() + 1) + // display cell number instead cell id (for humans)
                " Поле свободное:" + isFree() +
                " Здание строится: " + isBuildingUnderConstruction +
                " Здание на этом поле: " + getBuildingOnCell();
        return cell;
    }
}

package ua.golovchenko.artem.strategy.model;

import ua.golovchenko.artem.strategy.model.buildings.BuildingAbstract;

/**
 * Created by art on 14.10.2016.
 */
public class CastleCell {

    private int id;
    private boolean isFree = true;
    private BuildingAbstract buildingOnCell;
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

    public BuildingAbstract getBuildingOnCell() {
        return buildingOnCell;
    }

    public void getAvailableBuildings(){

    }

    public void setBuildingOnCell(BuildingAbstract buildingOnCell) {
        this.buildingOnCell = buildingOnCell;
    }

    @Override
    public String toString() {
        String cell= "ID: " + getId() + "; Поле свободное: " + isFree() + "; Здание на этом поле: " + getBuildingOnCell();


        return cell;
    }
}

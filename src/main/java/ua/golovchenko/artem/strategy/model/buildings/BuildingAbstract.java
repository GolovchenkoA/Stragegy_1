package ua.golovchenko.artem.strategy.model.buildings;

import ua.golovchenko.artem.strategy.model.Units.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by art on 14.10.2016.
 * Класс здания. с минимальнымы требованиями
 *
 */



public abstract class BuildingAbstract implements Building{

    public enum BuildingsType {

        MILITARY,DECORATION,CIVIL,INDUSTRIAL;
    }


    private Long id;
    private String name;
    private BuildingsType type; // тип здания
    private Long cost; // цена постройки
    private int speedOfConstruction_minutes; // время постройки в минутах
    private boolean  buildingConstructed = false;
    private int maxUnitsInBuilding;
    private int totalUnitsinBuilding = 0;
    private List<Unit> units = new ArrayList<>(); // пользователи в замке


    public BuildingAbstract() {};


    public BuildingAbstract(String name, BuildingsType type, Long cost, int speedOfConstruction_minutes, boolean buildingConstructed, int maxUnitsInBuilding, int totalUnitsinBuilding, List<Unit> units) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.speedOfConstruction_minutes = speedOfConstruction_minutes;
        this.buildingConstructed = buildingConstructed;
        this.maxUnitsInBuilding = maxUnitsInBuilding;
        this.totalUnitsinBuilding = totalUnitsinBuilding;
        this.units = units;
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

    public void setName(String name) {
        this.name = name;
    }

    public BuildingsType getType() {
        return type;
    }

    public void setType(BuildingsType type) {
        this.type = type;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public int getSpeedOfConstruction_minutes() {
        return speedOfConstruction_minutes;
    }

    public void setSpeedOfConstruction_minutes(int speedOfConstruction_minutes) {
        this.speedOfConstruction_minutes = speedOfConstruction_minutes;
    }

    public boolean isBuildingConstructed() {
        return buildingConstructed;
    }

    public void setBuildingConstructed(boolean buildingConstructed) {
        this.buildingConstructed = buildingConstructed;
    }


    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", cost=" + cost +
                ", speedOfConstruction_minutes=" + speedOfConstruction_minutes +
                ", buildingConstructed=" + buildingConstructed +
                '}';
    }

    public int getMaxUnitsInBuilding() {
        return maxUnitsInBuilding;
    }

    public void setMaxUnitsInBuilding(int maxUnitsInBuilding) {
        this.maxUnitsInBuilding = maxUnitsInBuilding;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public void createUnit(Unit unit){
        if((maxUnitsInBuilding - totalUnitsinBuilding) > 0){
            units.add(unit);
            totalUnitsinBuilding++;
        }else {
            System.out.format("Достигнуто максимальное количество юнитов в здании: Total Units in Building: %d",totalUnitsinBuilding);
        }


    }
}

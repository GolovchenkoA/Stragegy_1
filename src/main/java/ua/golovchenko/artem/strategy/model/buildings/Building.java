package ua.golovchenko.artem.strategy.model.buildings;

/**
 * Created by art on 14.10.2016.
 * Класс здания. с минимальнымы требованиями
 */
public abstract class Building {

    public enum BuildingsType {

        MILITARY,DECORATION,CIVIL,INDUSTRIAL;
    }

    private Long id;
    private String name;
    private BuildingsType type; // тип здания
    private int cost; // цена постройки
    private int speedOfConstruction_minutes; // время постройки в минутах
    private boolean  buildingConstructed = false;



    public Building() {};

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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
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
}

package ua.golovchenko.artem.strategy.model.buildings;

/**
 * Created by art on 26.10.2016.
 */
public interface Building {

    public Long getId();

    public void setId(Long id);

    public String getName();

    public void setName(String name);
    public BuildingAbstract.BuildingsType getType();

    public void setType(BuildingAbstract.BuildingsType type);

    public Long getCost();

    public void setCost(Long cost);

    public int getSpeedOfConstruction_minutes();

    public void setSpeedOfConstruction_minutes(int speedOfConstruction_minutes) ;

    public boolean isBuildingConstructed();

    public void setBuildingConstructed(boolean buildingConstructed);

}

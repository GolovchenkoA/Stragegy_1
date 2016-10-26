package ua.golovchenko.artem.strategy.model.buildings;

/**
 * Created by art on 15.10.2016.
 */

@RealBuilding
public class GoldMine extends Industrial {

    public GoldMine() {
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
    public void setCost(int cost) {
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

}

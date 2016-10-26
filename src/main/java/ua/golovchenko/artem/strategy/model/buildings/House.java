package ua.golovchenko.artem.strategy.model.buildings;

/**
 * Created by art on 17.10.2016.
 */

@RealBuilding
public class House extends Civil {

    private final int LIVES_PEOPLE = 10;

    public House(){
        super.setType(BuildingsType.CIVIL);
        super.setCost(5);
        super.setName("House");
        super.setMaxUnitsInBuilding(5);
        super.setSpeedOfConstruction_minutes(1);
    }


    public int getLivesPeople() {
        return LIVES_PEOPLE;
    }
}

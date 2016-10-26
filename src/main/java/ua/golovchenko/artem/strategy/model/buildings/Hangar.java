package ua.golovchenko.artem.strategy.model.buildings;

/**
 * Created by art on 17.10.2016.
 */

@RealBuilding
public class Hangar extends Military {

    public Hangar() {
        super.setType(BuildingsType.MILITARY);
        super.setCost(20);
        super.setName("Hangar");
        super.setMaxTraningUnits(1);
        super.setSpeedOfConstruction_minutes(3);
    }
}

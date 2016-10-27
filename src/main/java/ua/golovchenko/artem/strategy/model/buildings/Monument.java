package ua.golovchenko.artem.strategy.model.buildings;

/**
 * Created by art on 17.10.2016.
 */
@RealBuilding
public class Monument extends Decoration {

    public Monument(){
        super.setType(BuildingsType.DECORATION);
        super.setCost(5L);
        super.setName("Castle Monument");
        super.setMaxUnitsInBuilding(0);
        super.setSpeedOfConstruction_minutes(1);
    }
}

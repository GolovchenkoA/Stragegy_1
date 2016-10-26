package ua.golovchenko.artem.strategy.model.buildings;

import ua.golovchenko.artem.strategy.model.Castle;
import ua.golovchenko.artem.strategy.model.CastleCell;

/**
 * Created by art on 26.10.2016.
 */
public interface BuildingConstructor {

    public void setCastle(Castle castle);
    public void setBuilding(Building building);
    public boolean beginConstruction(Building building, CastleCell castleCell);

}

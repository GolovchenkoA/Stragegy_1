package ua.golovchenko.artem.strategy.model;

import ua.golovchenko.artem.strategy.model.menu.CastleInfo;
import ua.golovchenko.artem.strategy.model.menu.GameMenu;

/**
 * Created by art on 24.10.2016.
 */
public abstract class GamePanelAbstract {
    CastleInfo castleInfoPanel;
    GameMenu gameMenu;


    public GamePanelAbstract(CastleInfo castleInfoPanel, GameMenu gameMenu) {
        this.castleInfoPanel = castleInfoPanel;
        this.gameMenu = gameMenu;
    }

}

package ua.golovchenko.artem.strategy.model;

import ua.golovchenko.artem.strategy.model.menu.CastleInfo;
import ua.golovchenko.artem.strategy.model.menu.GameMenu;

/**
 * Created by art on 24.10.2016.
 */
public class GameDisplayMain extends GamePanelAbstract implements GameDisplay {

    public GameDisplayMain(CastleInfo castleInfopanel, GameMenu gameMenu) {
        super(castleInfopanel, gameMenu);
    }

    @Override
    public void display() {

        // Отображаем верхнюю панель с ресурсами
        System.out.println("**********************");
        castleInfoPanel.viewInfo();

        // Отображаем меню
        System.out.println("");
        System.out.println("Текущее меню: " + gameMenu.getCurrentMenuName());
        gameMenu.showCurrentMenuItems(); //выводим список всех команд
        System.out.println("**********************");

    }
}

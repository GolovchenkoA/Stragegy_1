package ua.golovchenko.artem.strategy.model.menu;

/**
 * Created by art on 24.10.2016.
 */
public class GoToMainMenu extends MenuItem implements Command{

    private GameMenu gameMenu;

    public GoToMainMenu(GameMenu gameMenu) {
        super("GoToMainMenu", "Exit from any menu and go to MainMenu");
        this.gameMenu = gameMenu;
    }

    @Override
    public void execute() {
        gameMenu.goToMainMenu();
        }

}

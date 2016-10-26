package ua.golovchenko.artem.strategy.model.menu;

/**
 * Created by art on 24.10.2016.
 */
public abstract class GameMenuAbstract {
    protected final MenuComponent mainMenuItems;
    protected MenuComponent currentMenuComponent;

    public GameMenuAbstract(MenuComponent mainMenuItems) {
        this.mainMenuItems = mainMenuItems;
        this.currentMenuComponent =  mainMenuItems;
    }

    public void goToMainMenu(){
        this.currentMenuComponent = this.mainMenuItems;
    };
}

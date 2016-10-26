package ua.golovchenko.artem.strategy.model.menu;

/**
 * Created by art on 24.10.2016.
 */
public interface GameMenu {

    public void setCurrentMenuItem(Integer i);
    public void showCurrentMenuItems();
    public MenuComponent getCurentMenuItem();
    public int getCurrentMenuItemsCount();
    public void executeCurrentMenuItem();
    public String getCurrentMenuName();
    public void goToMainMenu();
    public Object getLast_command();
}

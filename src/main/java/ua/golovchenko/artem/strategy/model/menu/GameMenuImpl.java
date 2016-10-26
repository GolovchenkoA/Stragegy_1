package ua.golovchenko.artem.strategy.model.menu;

import java.util.Collection;

/**
 * Created by art on 22.10.2016.
 */
public class GameMenuImpl extends GameMenuAbstract implements GameMenu{

    Object last_command;

    public GameMenuImpl(MenuComponent allGameMenuItems) {
        super(allGameMenuItems);

        // Добавляем к каждому меню дополнительную кнопку выхода в основное меню
        Collection<MenuComponent> mm = ((Menu) mainMenuItems).getChild();
        for(MenuComponent submenu : mm){
            if(submenu.isMenu()){
                MenuItem exitToMainMenu = new GoToMainMenu(this);
                submenu.add(exitToMainMenu);
            }

        }
    }

    public void setCurrentMenuItem(Integer i) {
           MenuComponent mc =  currentMenuComponent.getChild(i);
        if(mc instanceof Menu){
            currentMenuComponent = mc;
            //currentMenuComponent.execute();
        }if(mc instanceof MenuItem){
             mc.execute();
            last_command = mc;
        }
    }

    public void showCurrentMenuItems(){
            currentMenuComponent.showMenuItems();
        }

    public MenuComponent getCurentMenuItem(){
        return currentMenuComponent;
    }

    public void goToMainMenu(){
        currentMenuComponent = mainMenuItems;
    }

    public int getCurrentMenuItemsCount(){
        int i = 0;
            if(currentMenuComponent instanceof MenuItem){
                i = 1;
            }
            if(currentMenuComponent instanceof Menu){
                i = ((Menu) currentMenuComponent).getChild().size();
            }
        return i;
    }

    public void executeCurrentMenuItem(){
        currentMenuComponent.execute();
    }

    public String getCurrentMenuName(){
        return currentMenuComponent.getName();
    }
    public Object getLast_command(){
        return last_command;
    }

}

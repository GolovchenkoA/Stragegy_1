package ua.golovchenko.artem.strategy.model.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by art on 24.10.2016.
 *
 * Паттерн проектирования "Компоновщик"
 */
public class Menu extends MenuComponent implements Command {
    private List<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    private String name;
    private String description;


    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
        super.isMenu = true;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    public Collection<MenuComponent> getChild(){return  menuComponents;}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void showMenuItems(){
        execute();
    }
    @Override
    public void execute() {
        int i = 0;
        for(MenuComponent menuItem : menuComponents){
            ++i;
            System.out.println(i +". " + menuItem.getName());
        }
    }
}

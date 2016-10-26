package ua.golovchenko.artem.strategy.model.menu;

/**
 * Created by art on 24.10.2016.
 * Паттерн проектирования "Компоновщик"
 */
public abstract class MenuComponent {

    protected boolean isMenu = false;
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public void remove (MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild (int i){
        throw new UnsupportedOperationException();
    }

    public String getName(){
        throw new UnsupportedOperationException();
    }

    public String getDescription(){
        throw new UnsupportedOperationException();
    }

    public boolean isMenu(){
        return isMenu;
    }

    public void showMenuItems(){
        System.out.println(getName());
    };

    public void execute(){
        throw new UnsupportedOperationException();
    }

}

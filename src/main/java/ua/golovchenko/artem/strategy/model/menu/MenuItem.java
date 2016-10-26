package ua.golovchenko.artem.strategy.model.menu;

/**
 * Created by art on 22.10.2016.
 *
 * Паттерн проектирования "Компоновщик"
 */
public abstract class MenuItem extends MenuComponent {
    private String name;
    private String description;

    public MenuItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

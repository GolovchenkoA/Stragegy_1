package ua.golovchenko.artem.strategy.model.menu;

/**
 * Created by art on 24.10.2016.
 */
public class CreateBuildingOnCell extends MenuItem implements Command{

    public CreateBuildingOnCell(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute() {
        System.out.println("Построить здание в клетке");
    }
}

package ua.golovchenko.artem.strategy.model.menu;

import ua.golovchenko.artem.strategy.model.Castle;
import ua.golovchenko.artem.strategy.model.buildings.Building;

import java.util.Set;

/**
 * Created by art on 26.10.2016.
 */
public class ViewBuildingOnCells extends MenuItem implements Command {

    public ViewBuildingOnCells(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute() {
        int i = 0;
        Set<Building> availableBuildings;
        availableBuildings = Castle.getAvailableBuildings();

        System.out.println("Доступные задния: ");
        for(Building build : availableBuildings){
            System.out.println(++i +". " + build.getName());
        }
    }
}

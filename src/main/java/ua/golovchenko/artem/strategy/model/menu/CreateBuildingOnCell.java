package ua.golovchenko.artem.strategy.model.menu;

import ua.golovchenko.artem.strategy.model.Castle;
import ua.golovchenko.artem.strategy.model.CastleCell;
import ua.golovchenko.artem.strategy.model.buildings.Building;
import ua.golovchenko.artem.strategy.model.buildings.BuildingConstructor;
import ua.golovchenko.artem.strategy.model.buildings.BuildingConstructorReal;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by art on 24.10.2016.
 */
public class CreateBuildingOnCell extends MenuItem implements Command{

    Scanner console_input = new Scanner(System.in);
    String input_cell_number;
    String input_building_number;
    Pattern p = Pattern.compile("^\\d+$"); // Только целые числа
    Matcher numberMatcher;
    Matcher numberMatcher2;
    private List<CastleCell> castleCells = Castle.getCells();
    private CastleCell castleCell;
    private List<Building> buildings = new ArrayList<Building>(Castle.getAvailableBuildings());
    private Building building;
    BuildingConstructor buildingConstructor = BuildingConstructorReal.getInstance();


    public CreateBuildingOnCell(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute() {
        int i = 0;


          System.out.println("Доступные задния: ");
            for(Building build : buildings){
            System.out.println(++i +". " + build.getName());
        }

        System.out.println("ПОСТРОЙКА ЗДАНИЯ. \n Введите номер клетки, а потом номер здания: ");

        input_cell_number = console_input.next();
        input_building_number = console_input.next();
        numberMatcher = p.matcher(input_cell_number);
        numberMatcher2 = p.matcher(input_building_number);

        boolean input_digitals = numberMatcher.matches() && numberMatcher2.matches();
        boolean input_digitals_in_rage = (buildings.size() >= Integer.parseInt(input_cell_number) - 1 ) && (castleCells.size() >= Integer.parseInt(input_building_number) - 1 );
        String message;

        // Сообщение о том что неправильно ввели данные
        if (!input_digitals) {
            message = "Введенное значение не правильно (не числа). ";
            if (!input_digitals_in_rage){
                message.concat("Введен недопустимый диапозон значений (ячейка и здание)");
            }
            System.out.println(message);

        }else if (input_digitals && input_digitals_in_rage){ // Если введены правильные значения

            castleCell = castleCells.get(Integer.parseInt(input_cell_number));
            building = buildings.get(Integer.parseInt(input_building_number));
            boolean result = buildingConstructor.beginConstruction(building,castleCell);

            System.out.format("Начато строительство здания: %s на клетке: %d . Подтверждение %b \n", building.getName(),castleCell.getId(), result);

        }


    }
}

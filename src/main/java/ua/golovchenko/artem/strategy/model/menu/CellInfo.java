package ua.golovchenko.artem.strategy.model.menu;

import ua.golovchenko.artem.strategy.model.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by art on 22.10.2016.
 */
public class CellInfo extends MenuItem implements Command {
    private CastleCell castleCell;
    //private Scanner sc = new Scanner(System.in);
    //private Command menuItemCommand;

    // Необходимо для проверки значений, которые ввел игрок
    Scanner console_input = new Scanner(System.in);
    String selection;
    Pattern p = Pattern.compile("^\\d+$"); // Только целые числа
    Matcher numberMatcher;



    public CellInfo(String name, String description) {
        super(name, description);
    }

/*    public CastleCell getCastleCell() {
        return castleCell;
    }

    public void setCastleCell(CastleCell castleCell) {
        this.castleCell = castleCell;
    }

*/

    @Override
    public void execute() {

        System.out.println("Введите номер ячейки: ");

/*        // Вывести информацию о всех ячейках
        for (CastleCell cell : Castle.getCells()){
            System.out.println(cell.toString());
        }*/

        selection = console_input.next();
        numberMatcher = p.matcher(selection);

        // Обработка информации которую ввел игрок. Информация о якейке
        if (numberMatcher.matches() && GameFieldReal.TOTAL_CASTLE_CELLS >= Integer.parseInt(selection) - 1){
            castleCell = Castle.getCell(Integer.parseInt(selection)-1);
            System.out.println(castleCell.toString());
        } else {
            int total_cells = GameFieldReal.TOTAL_CASTLE_CELLS + 1;
            System.out.println("Введите номер ячейки с 1 по " + total_cells);
        }

    }
}

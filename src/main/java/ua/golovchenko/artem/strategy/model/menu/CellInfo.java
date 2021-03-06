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



    public CellInfo() {
        super("Cell info","get info about cell");
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
        boolean input_matcher;
        System.out.println("Введите номер ячейки: ");

/*        // Вывести информацию о всех ячейках
        for (CastleCell cell : Castle.getCells()){
            System.out.println(cell.toString());
        }*/

        do{
            selection = console_input.next();
            numberMatcher = p.matcher(selection);


            // Обработка информации которую ввел игрок. Информация о якейке
            input_matcher = numberMatcher.matches() && GameFieldReal.TOTAL_CASTLE_CELLS >= Integer.parseInt(selection) - 1;
            if (input_matcher){
                castleCell = Castle.getCell(Integer.parseInt(selection));
                System.out.println(castleCell.toString());
            } else {
                int total_cells = GameFieldReal.TOTAL_CASTLE_CELLS + 1;
                System.out.println("Введите номер ячейки с 1 по " + total_cells);
            }
        }while (!input_matcher);

    }
}

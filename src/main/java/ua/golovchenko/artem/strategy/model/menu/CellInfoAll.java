package ua.golovchenko.artem.strategy.model.menu;

import ua.golovchenko.artem.strategy.model.Castle;
import ua.golovchenko.artem.strategy.model.CastleCell;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by art on 27.10.2016.
 */
public class CellInfoAll extends MenuItem implements Command {
    private CastleCell castleCell;
    //private Scanner sc = new Scanner(System.in);
    //private Command menuItemCommand;

    // Необходимо для проверки значений, которые ввел игрок
    Scanner console_input = new Scanner(System.in);
    String selection;
    Pattern p = Pattern.compile("^\\d+$"); // Только целые числа
    Matcher numberMatcher;



    public CellInfoAll() {
       super("All Cell info","get info about all cells");
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

        // Вывести информацию о всех ячейках
        for (CastleCell cell : Castle.getCells()){
            System.out.println(cell.toString());
        }
    }
}
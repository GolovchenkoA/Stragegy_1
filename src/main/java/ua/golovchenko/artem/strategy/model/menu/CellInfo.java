package ua.golovchenko.artem.strategy.model.menu;

import ua.golovchenko.artem.strategy.model.Castle;
import ua.golovchenko.artem.strategy.model.CastleCell;

import java.util.Scanner;

/**
 * Created by art on 22.10.2016.
 */
public class CellInfo extends MenuItem implements Command {
    private CastleCell castleCell;
    private Scanner sc = new Scanner(System.in);
    //private Command menuItemCommand;

    public CellInfo(String name, String description) {
        super(name, description);
    }

    public CastleCell getCastleCell() {
        return castleCell;
    }

    public void setCastleCell(CastleCell castleCell) {
        this.castleCell = castleCell;
    }


    private void setCurrentCastleCell(int i){

    }

    @Override
    public void execute() {
        System.out.println("Введите номер ячейки: ");
        int i = Integer.parseInt(sc.next());
        castleCell = Castle.cells.get(i-1);
        System.out.println(castleCell.toString());
    }
}

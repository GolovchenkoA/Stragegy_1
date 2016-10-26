package ua.golovchenko.artem.strategy.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by art on 26.10.2016.
 */
public class GameFieldAbstract implements GameField{
    public static final int TOTAL_CASTLE_CELLS = 24; //По факту нам требуется 25 яцеек. Нумерация с нуля
    public static final List<CastleCell> cells = new ArrayList<CastleCell>(TOTAL_CASTLE_CELLS);

    static {
        // Инициализация клеток поля
        for (int i = 0; i <= TOTAL_CASTLE_CELLS; i++) {
            cells.add(new CastleCell(i));
        }
    }


    private int freeCellsCount = TOTAL_CASTLE_CELLS;


    public int getFreeCellsCount() {

        updateFreeCellsCount();
        return freeCellsCount;
    }

    public void updateFreeCellsCount() {

        int freeCells = 0;

        for(CastleCell cell : cells) {
            if (cell.isFree()) {
                freeCells++;
            }
        }
        this.freeCellsCount = freeCells;
    }

    public List<CastleCell> getCells(){
        return cells;
    }

    public CastleCell getCell(int i){
        return cells.get(i -1);
    }
}

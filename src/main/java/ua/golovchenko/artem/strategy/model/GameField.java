package ua.golovchenko.artem.strategy.model;

import java.util.List;

/**
 * Created by art on 26.10.2016.
 */
public interface GameField {
    public int getFreeCellsCount();
    public void updateFreeCellsCount();
    public List<CastleCell> getCells();
    public CastleCell getCell(int i);
}

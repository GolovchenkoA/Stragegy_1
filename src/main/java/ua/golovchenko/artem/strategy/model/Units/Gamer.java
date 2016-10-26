package ua.golovchenko.artem.strategy.model.Units;

import ua.golovchenko.artem.strategy.model.Castle;

/**
 * Created by art on 26.10.2016.
 */
public interface Gamer {
    String getName();
    String setName();
    void setCastle();
    Castle getCastle();
}

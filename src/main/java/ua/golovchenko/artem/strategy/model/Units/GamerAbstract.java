package ua.golovchenko.artem.strategy.model.Units;

import ua.golovchenko.artem.strategy.model.Castle;

/**
 * Created by art on 26.10.2016.
 */
public class GamerAbstract {
    String name;
    Castle castle;

    public GamerAbstract(){}

    public GamerAbstract(String name, Castle castle) {
        this.name = name;
        this.castle = castle;
    }
}

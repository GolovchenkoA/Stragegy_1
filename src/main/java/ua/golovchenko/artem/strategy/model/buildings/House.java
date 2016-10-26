package ua.golovchenko.artem.strategy.model.buildings;

/**
 * Created by art on 17.10.2016.
 */
public class House extends Civil {

    private final int LIVES_PEOPLE = 10;

    public int getLivesPeople() {
        return LIVES_PEOPLE;
    }
}

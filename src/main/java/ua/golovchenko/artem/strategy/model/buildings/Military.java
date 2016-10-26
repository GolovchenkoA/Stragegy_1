package ua.golovchenko.artem.strategy.model.buildings;

/**
 * Created by art on 17.10.2016.
 */
public abstract class Military extends Building {

    private int maxTraningUnits; // Максимальное число юнитов, которые могут тренироваться (превращаться в солдат) одновременно
    private int currentNumberOfTrainees; // текущее количество тренирующихся

    public int getMaxTraningUnits() {
        return maxTraningUnits;
    }

    public void setMaxTraningUnits(int maxTraningUnits) {
        this.maxTraningUnits = maxTraningUnits;
    }

    public int getCurrentNumberOfTrainees() {
        return currentNumberOfTrainees;
    }

    public void setCurrentNumberOfTrainees(int currentNumberOfTrainees) {
        this.currentNumberOfTrainees = currentNumberOfTrainees;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", maxTraningUnits :" + getMaxTraningUnits() +
                ", currentNumberOfTrainees :" + getCurrentNumberOfTrainees();
    }
}

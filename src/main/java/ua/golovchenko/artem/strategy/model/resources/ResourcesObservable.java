package ua.golovchenko.artem.strategy.model.resources;


/**
 * Created by art on 24.10.2016.
 *
 * Интерфейс используется для абстракции
 * Так же к нему добавлены методы и паттерна   Наблюдатель.
 * Классы реализующие этот интерфейс являются наблюдаемыми
 *
 */
public interface ResourcesObservable {

    public void registerObserver(ResourceObserver o);
    public void removeObserver(ResourceObserver o);
    public void notifyObservers();

}

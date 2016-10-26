package ua.golovchenko.artem.strategy.model.resources;

/**
 * Created by art on 25.10.2016.
 */
public interface ResourceObserver {

    public void update(ResourcesObservable o, ResourceAbstract.ResourcesType type);
}

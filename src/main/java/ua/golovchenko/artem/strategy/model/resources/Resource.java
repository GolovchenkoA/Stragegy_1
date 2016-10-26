package ua.golovchenko.artem.strategy.model.resources;

/**
 * Created by art on 24.10.2016.
 */
public interface Resource {
    public String getName();
    public Long getAmount();
    public void increace();
    public void increace(Long amount);
    public void decreace();
    public void decreace(Long amount);
    public void setResource_growth_per_hour(Long amount);
    public Long getResource_growth_per_hour();
    public ResourceAbstract.ResourcesType getResourceType();
}

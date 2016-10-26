package ua.golovchenko.artem.strategy.model.resources;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by art on 14.10.2016.
 */
public abstract class ResourceAbstract implements Resource,ResourcesObservable {

    public String name;
    public Long amount = 0L;
    Long resource_growth_per_hour;
    protected ResourcesType resourceType;
    List<ResourceObserver> resourceObservers = new LinkedList<>();

    public enum ResourcesType{
        GOLD,MONEY;
    }

/*    java.util.Date utilDate = new java.util.Date();
java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());*/
    //private Date last_resource_growth;

    public void setAmount(Long amount){
        this.amount = amount;
    }
}

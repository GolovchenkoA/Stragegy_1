package ua.golovchenko.artem.strategy.model.resources;


/**
 * Created by art on 24.10.2016.
 */
public class Gold extends ResourceAbstract implements Resource {

    private String name =  "Gold";

    public Gold(){
        resourceType = ResourcesType.GOLD;
    }

    public Gold(Long gold_amount){
        resourceType = ResourcesType.GOLD;
        amount = gold_amount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Long getAmount() {
        return amount;
    }

    @Override
    public void increace() {
        amount++;
    }

    @Override
    public void increace(Long amount) {
        super.amount += amount;
    }

    @Override
    public void decreace() {
        amount--;
    }

    @Override
    public void decreace(Long amount) {
        super.amount -= amount;
    }

    @Override
    public void setResource_growth_per_hour(Long amount) {
        resource_growth_per_hour = amount;
    }

    @Override
    public Long getResource_growth_per_hour() {
        return resource_growth_per_hour;
    }

    @Override
    public ResourcesType getResourceType() {
        return resourceType;
    }

    @Override
    public void registerObserver(ResourceObserver o) {
        resourceObservers.add(o);
    }

    @Override
    public void removeObserver(ResourceObserver o) {
        resourceObservers.remove(o);
    }

    @Override
    public void notifyObservers() {

        for(ResourceObserver o : resourceObservers){
            o.update(this,this.getResourceType());
        }
    }

    @Override
    public void setAmount(Long amount) {
        super.setAmount(amount);
    }
}

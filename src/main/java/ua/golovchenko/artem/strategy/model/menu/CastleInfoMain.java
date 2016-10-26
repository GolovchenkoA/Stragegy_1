package ua.golovchenko.artem.strategy.model.menu;

import ua.golovchenko.artem.strategy.model.resources.Gold;

/**
 * Created by art on 25.10.2016.
 */
public class CastleInfoMain implements CastleInfo {

    //private ResourcesObservable resourcesObservable;
    private Gold gold;

    public CastleInfoMain(Gold gold) {
        this.gold = gold;
    }

    public void viewInfo(){
        System.out.format("Доступные ресурсы: Gold: %d", gold.getAmount() );
    }
}

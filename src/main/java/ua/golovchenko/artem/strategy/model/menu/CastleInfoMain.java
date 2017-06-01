package ua.golovchenko.artem.strategy.model.menu;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import ua.golovchenko.artem.strategy.model.Castle;

/**
 * Created by art on 25.10.2016.
 */
public class CastleInfoMain implements CastleInfo {

    //private ResourcesObservable resourcesObservable;
    Castle castle = Castle.getInstance();

/*    private Gold gold;

    public CastleInfoMain(Gold gold) {
        this.gold = gold;
    }*/


    public void viewInfo(){

/*        System.out.format("Доступные ресурсы: Gold: %d Прирост золота (мин.): %d Свободно клеток: %d",
                castle.getTotalGold(), castle.getTotalGoldPerMinute(), castle.getFreeCellsCount());*/

        System.out.println("\033[32m Доступные ресурсы: Gold: " + castle.getTotalGold()
                + " Прирост золота (мин.): " + castle.getTotalGoldPerMinute()
                + " Свободно клеток: " + castle.getFreeCellsCount());
        AnsiConsole.out().print(Ansi.ansi().reset().fg(Ansi.Color.WHITE));
    }

}

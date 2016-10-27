package ua.golovchenko.artem.strategy.model.resources;

import ua.golovchenko.artem.strategy.Main;
import ua.golovchenko.artem.strategy.model.Castle;

/**
 * Created by art on 26.10.2016.
 */
public class ResourceManager extends Thread {

    private Castle castle;

    public ResourceManager(Castle castle){
        this.castle = castle;
        this.setName("Resource Manager");
        System.out.println("Resource Manager Thread Start");
        start();
    }

    public  void run(){

        do{
            try {
                this.sleep(60000); // 1 минута
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Ошибка в потоке Resource Manager");
            }
            castle.addGold(castle.getTotalGoldPerMinute());
        }while (Main.theGameContinues);

        System.out.println("Остановился поток: " + this.getName());

    }
}

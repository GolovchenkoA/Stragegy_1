package ua.golovchenko.artem.strategy.model.menu;

/**
 * Created by art on 22.10.2016.
 */
public class ExitMenuItem extends MenuItem implements Command {

    public ExitMenuItem(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute() {
        System.out.println("Выход из меню");

    }
}

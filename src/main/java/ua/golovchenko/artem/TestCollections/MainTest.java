package ua.golovchenko.artem.TestCollections;

/**
 * Created by art on 17.10.2016.
 */
public class MainTest {



    //private static Map<String,Building> allBuildings = new TreeMap<>(); // Небезопасно ставить ? но с ограничением по extend Building не получилось

    public static void main(String[] args) {

        ClassA classA = new ClassA();
        ClassB classB = new ClassB();


        classA.increase(5);
        int result = classA.getA();


        System.out.println("Result: " + result);


  /*    List<Class<?>> buildings_classes = ClassFinder.find("ua.golovchenko.artem.strategy.model.buildings");

        for(Class building : buildings_classes) {
            if (!Modifier.isAbstract(building.getModifiers()) && !building.getSimpleName().equals("BuildingsType")) { // если класс не абстрактный
                Building b = null;
                try {
                    System.out.println(building.getSimpleName());
                    b = (Building) building.newInstance(); // создаем объект класса
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                allBuildings.put(building.getSimpleName(), b); // добавляем объект класса в массив
            }
        }*/

/*        Building hangar = new Hangar();
        System.out.println(hangar.toString());*/
/*
        List<CastleCell> castleCells = new ArrayList<>(24); // 25 elements

        for (int i = 0 ; i <=24; i++){
            castleCells.add(new CastleCell(i));
        }

        for (CastleCell cell : castleCells){
            System.out.println(cell.toString());
        }


        // Удаляем из середины
        System.out.println("Удаляем из середины");
        castleCells.remove(6);


        for (CastleCell cell : castleCells){
            System.out.println(cell.toString());
        }

        // Добавляем 26 элемент
        System.out.println("Добавляем 26 элемент");
        castleCells.add(6,new CastleCell(26));
        for (CastleCell cell : castleCells){
            System.out.println(cell.toString());
        }
*/

/*        // Удаляем в конце
        System.out.println("Удаляем в конце");
        castleCells.remove(24);

        for (CastleCell cell : castleCells){
            System.out.println(cell.toString());
        }

*/

    }
}
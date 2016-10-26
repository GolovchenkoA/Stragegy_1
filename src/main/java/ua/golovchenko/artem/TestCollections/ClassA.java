package ua.golovchenko.artem.TestCollections;

/**
 * Created by art on 26.10.2016.
 */
public class ClassA {

    Integer a;

    public ClassA(){
        a = 1;
    }

    public void increase(){
        a++;
    }

    public void increase(int i){
        a += i;

        System.out.println("first increase");
        System.out.println("second increase");
    }

    public Integer getA(){
        return a;
    }
}

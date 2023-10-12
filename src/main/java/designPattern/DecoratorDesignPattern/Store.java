package designPattern.DecoratorDesignPattern;

import designPattern.DecoratorDesignPattern.decorator.ExtraCheese;
import designPattern.DecoratorDesignPattern.decorator.Mushroom;

public class Store {
    public static void main(String[] args) {

        BasePizza basePizza0 = (new Margherita());
        System.out.println(basePizza0.cost());

        // now i want Margherita with extra cheese
        BasePizza basePizza = new ExtraCheese(new Margherita());
        System.out.println(basePizza.cost());


        // now i need mushroom in Base pizza as well
        BasePizza basePizza2 = new Mushroom(new ExtraCheese(new Margherita()));
        System.out.println(basePizza2.cost());
    }
}

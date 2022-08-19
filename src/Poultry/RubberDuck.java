package Poultry;

import Poultry.Decorators.Quackable;

public class RubberDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}

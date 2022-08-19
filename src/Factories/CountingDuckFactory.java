package Factories;

import Poultry.Decorators.QuackCounter;
import Poultry.Decorators.Quackable;
import Poultry.DuckCall;
import Poultry.MallardDuck;
import Poultry.RedheadDuck;
import Poultry.RubberDuck;

public class CountingDuckFactory extends AbstractDuckFactory{
    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackCounter(new RedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }

}

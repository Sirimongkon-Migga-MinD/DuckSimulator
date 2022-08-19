package Factories;

import Poultry.Decorators.QuackCounter;
import Poultry.Decorators.QuackEcho;
import Poultry.Decorators.Quackable;
import Poultry.DuckCall;
import Poultry.MallardDuck;
import Poultry.RedheadDuck;
import Poultry.RubberDuck;

public class CountAndEchoDuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new QuackEcho(new MallardDuck()));
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackCounter(new QuackEcho(new RedheadDuck()));
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new QuackEcho(new DuckCall()));
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new QuackEcho(new RubberDuck()));
    }
}

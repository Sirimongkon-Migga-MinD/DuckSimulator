import Adapter.GooseAdapter;
import Adapter.PigeonAdapter;
import Factories.DuckFactory;
import Poultry.Composites.Flock;
import Poultry.Composites.LeaderFlock;
import Factories.AbstractDuckFactory;
import Factories.CountAndEchoDuckFactory;
import Factories.CountingDuckFactory;
import Poultry.*;
import Poultry.Decorators.QuackCounter;
import Poultry.Decorators.QuackEcho;
import Poultry.Decorators.Quackable;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulateCompositeLeaderFlock();
    }

    void simulate (Quackable duck){
        duck.quack();
    }

    void simulateAdapterPattern(){
        Quackable mallardDuck = new MallardDuck();
        Quackable redheadDuck = new RedheadDuck();
        Quackable duckCall = new DuckCall();
        Quackable rubberDuck = new RubberDuck();
        Quackable goose = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        System.out.println("\nAdapter Pattern Ducks Simulator\n----------------------------");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(goose);
        simulate(pigeon);
    }

    void simulateDecoratorPattern(){
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable goose = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());
        Quackable duckEcho = new QuackEcho(new MallardDuck());

        System.out.println("\nDecorator Pattern Ducks Simulator\n----------------------------");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(goose);
        simulate(pigeon);
        simulate(duckEcho);
        System.out.println("\nThe ducks quacked " + QuackCounter.getQuacks() + " times\n");

        QuackCounter.setNumberOfQuacks(0); //รีจำนวนนับให้เท่ากับ 0
        Quackable duckCountEcho = new QuackCounter(new QuackEcho(new MallardDuck()));
        simulate(duckCountEcho);
        System.out.println("The duckCountEcho quacked " + QuackCounter.getQuacks() + " times\n");

        QuackCounter.setNumberOfQuacks(0); //รีจำนวนนับให้เท่ากับ 0
        Quackable duckEchoCount = new QuackEcho(new QuackCounter(new MallardDuck()));
        simulate(duckEchoCount);
        System.out.println("The duckEchoCount quacked " + QuackCounter.getQuacks() + " times\n");

    }

    void simulateAbstractFactoryPattern(){
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory duckCountFactory = new CountingDuckFactory();
        AbstractDuckFactory duckCountAndEchoFactory = new CountAndEchoDuckFactory();

        Quackable mallardDuck = ((DuckFactory) duckFactory).createMallardDuck();
        Quackable redheadDuck = duckCountFactory.createRedheadDuck();
        Quackable rubberDuck = duckCountAndEchoFactory.createRubberDuck();

        System.out.println("Abstract Factory Duck Simulator\n---------------");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(rubberDuck);
        System.out.println("The duck quacked " + QuackCounter.getQuacks() + " times\n");
    }

    void simulateCompositePattern(){
        DuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory duckCountFactory = new CountingDuckFactory();

        Flock flockOfDucks = new Flock();
        Flock flockOfMallards = new Flock();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckCountFactory.createDuckCall();
        Quackable rubberDuck = duckCountFactory.createRubberDuck();

        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redHeadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);

        Quackable mallardDuckOne = duckFactory.createMallardDuck();
        Quackable mallardDuckTwo = duckFactory.createMallardDuck();
        Quackable mallardDuckThree = duckFactory.createMallardDuck();
        Quackable mallardDuckFour = duckFactory.createMallardDuck();

        flockOfMallards.add(mallardDuckOne);
        flockOfMallards.add(mallardDuckTwo);
        flockOfMallards.add(mallardDuckThree);
        flockOfMallards.add(mallardDuckFour);

        flockOfDucks.add(flockOfMallards);

        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);
        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        simulate(flockOfMallards);

        System.out.println("\nThe ducks quacked " + QuackCounter.getQuacks() + " times.");

    }

    void simulateCompositeLeaderFlock(){
        DuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory duckCountFactory = new CountingDuckFactory();

        LeaderFlock flockOfDusks = new LeaderFlock();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckCountFactory.createDuckCall();
        Quackable rubberDuck = duckCountFactory.createRubberDuck();

        flockOfDusks.add(mallardDuck);
        flockOfDusks.add(redHeadDuck);
        flockOfDusks.add(duckCall);
        flockOfDusks.add(rubberDuck);

        simulate(flockOfDusks);
    }
}

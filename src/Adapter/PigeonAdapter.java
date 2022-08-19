package Adapter;

import Poultry.Pigeon;
import Poultry.Decorators.Quackable;

public class PigeonAdapter implements Quackable {
    Pigeon pigeon;
    int pigeonQuack;

    public PigeonAdapter(Pigeon pigeon){
        this.pigeon = pigeon;
    }

    @Override
    public void quack() {
        for (int i=0 ; i<2; i++){
            pigeon.coo();
        }

//        pigeon.coo();
//        pigeonQuack = pigeon.coo();

    }
}

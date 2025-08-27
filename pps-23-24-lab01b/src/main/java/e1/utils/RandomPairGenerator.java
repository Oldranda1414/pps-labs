package e1.utils;

import java.util.Random;

public class RandomPairGenerator {

    private Random random;
    private int bound;

    public RandomPairGenerator(final int bound){
        this.random = new Random();
        this.bound = bound;
    }

    public Pair<Integer, Integer> nextPair() {
        return new Pair<Integer,Integer>(this.random.nextInt(bound), this.random.nextInt(bound));
    }
    
}

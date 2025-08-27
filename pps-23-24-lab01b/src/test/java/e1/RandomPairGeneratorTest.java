package e1;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e1.utils.Pair;
import e1.utils.RandomPairGenerator;

public class RandomPairGeneratorTest {
    
    private RandomPairGenerator random;
    private final int BOUND = 9;

    @BeforeEach
    void BeforeEach(){
        random = new RandomPairGenerator(BOUND);
    }

    @Test
    void getPairTest(){
        final Pair<Integer, Integer> pair = new Pair<>(null, null);
        assertAll(
            () -> assertEquals(pair.getClass(), random.nextPair().getClass()),
            () -> assertEquals(pair.getClass(), random.nextPair().getClass()),
            () -> assertEquals(pair.getClass(), random.nextPair().getClass())
        );
    }

    @Test
    void boundTest(){
        final var FIRST_PAIR = random.nextPair();
        final var SECOND_PAIR = random.nextPair();
        final var THIRD_PAIR = random.nextPair();
        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
        list.add(FIRST_PAIR);
        list.add(SECOND_PAIR);
        list.add(THIRD_PAIR);
        for(var pair : list){
            final int pairX = pair.getX();
            final int pairY = pair.getY();
            assertTrue(checkCoordinatsInBounds(pairX, pairY));
        }
    }

    private boolean checkCoordinatsInBounds(final int x, final int y){
        if(x < BOUND && x >= 0 && y < BOUND && y >= 0) return true;
        return false;
    }
}

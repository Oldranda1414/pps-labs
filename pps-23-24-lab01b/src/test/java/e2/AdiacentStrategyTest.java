package e2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e2.utils.AdiacentStrategy;
import e2.utils.AdiacentStrategyImpl;
import e2.utils.Pair;

public class AdiacentStrategyTest {
    
    private AdiacentStrategy strategy;
    private List<Pair<Integer, Integer>> adiacentList = new ArrayList<Pair<Integer, Integer>>();;
    private final Pair<Integer, Integer> POSITION = new Pair<Integer,Integer>(1, 1);

    @BeforeEach
    void beforeEach(){
        strategy = new AdiacentStrategyImpl();
    }

    @Test
    void adiacentTest(){
        setupList();
        assertEquals(adiacentList, strategy.getAdiacentPositions(POSITION));
    }

    private void setupList(){
        final int X = POSITION.getX();
        final int Y = POSITION.getY();

        final int[] ADIACENT_X = {X, X - 1, X + 1};
        final int[] ADIACENT_Y = {Y, Y - 1, Y + 1};

        for(var x : ADIACENT_X){
            for(var y : ADIACENT_Y){
                if(x != X || y != Y){
                    adiacentList.add(new Pair<Integer,Integer>(x, y));
                }
            }
        }
    }
    
}

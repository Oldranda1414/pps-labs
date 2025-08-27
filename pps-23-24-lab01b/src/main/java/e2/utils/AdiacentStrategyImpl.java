package e2.utils;

import java.util.ArrayList;
import java.util.List;

public class AdiacentStrategyImpl implements AdiacentStrategy{

    @Override
    public List<Pair<Integer, Integer>> getAdiacentPositions(Pair<Integer, Integer> position) {
        final int X = position.getX();
        final int Y = position.getY();

        final int[] ADIACENT_X = {X, X - 1, X + 1};
        final int[] ADIACENT_Y = {Y, Y - 1, Y + 1};

        List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();

        for(var x : ADIACENT_X){
            for(var y : ADIACENT_Y){
                if(x != X || y != Y){
                    list.add(new Pair<Integer,Integer>(x, y));
                }
            }
        }

        return list;
    }
    
}

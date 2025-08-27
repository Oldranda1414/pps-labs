package e2.utils;

import java.util.List;

public interface AdiacentStrategy {
    
    public List<Pair<Integer, Integer>> getAdiacentPositions(Pair<Integer, Integer> position);
}

package tdd3;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;

public class CircularList3Impl implements CircularList3{

    private ArrayList<Integer> list = new ArrayList<Integer>();
    private int currentIndex = 0;

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        final int STEP = 1;
        return this.performStep(STEP, Optional.ofNullable(null));
    }

    @Override
    public Optional<Integer> previous() {
        final int STEP = -1;
        return this.performStep(STEP , Optional.ofNullable(null));
    }

    @Override
    public void reset() {
        this.currentIndex = 0;
    }

    @Override
    public Optional<Integer> filteredNext(Function<Integer, Boolean> filter) {
        final int STEP = 1;
        return this.performStep(STEP, Optional.of(filter));
    }

    private Optional<Integer> performStep(final int STEP, Optional<Function<Integer, Boolean>> filter){
        if(this.isEmpty()){
            return Optional.ofNullable(null);
        }
        else{

            int value;
    
            if(filter.isPresent()){
                value = this.findNextFiltered(filter.get());
            }
            else{
                value = this.list.get(this.currentIndex);
            }
            
            this.updateIndex(STEP);
            return Optional.of(value);
        }
    }

    private void fixIndex(){
        if(this.currentIndex >= this.size()){
            this.currentIndex = this.currentIndex - this.size();
        }
        else if(this.currentIndex < 0){
            this.currentIndex = this.currentIndex + this.size();
        }
    }

    private void updateIndex(int update){
        this.currentIndex = this.currentIndex + update;
        this.fixIndex();
    }

    private int findNextFiltered(Function<Integer, Boolean> filter){
        while(!filter.apply(this.list.get(this.currentIndex))){
            this.currentIndex++;
            this.fixIndex();
        }
        return this.list.get(this.currentIndex);
    }
    
}

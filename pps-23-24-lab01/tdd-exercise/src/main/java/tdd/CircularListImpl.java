package tdd;

import java.util.ArrayList;
import java.util.Optional;

public class CircularListImpl implements CircularList{

    private ArrayList<Integer> list = new ArrayList<Integer>();
    private int currentIndex = 0;

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public Optional<Integer> next() {
        if(this.isEmpty()){
            return Optional.ofNullable(null);
        }
        else{
            int result = this.list.get(this.currentIndex);
            this.currentIndex++;
            this.fixIndex();
            return Optional.ofNullable(result);
        }
    }

    @Override
    public Optional<Integer> previous() {
        if(this.isEmpty()){
            return Optional.ofNullable(null);
        }
        else{
            int result = this.list.get(this.currentIndex);
            this.currentIndex--;
            this.fixIndex();
            return Optional.ofNullable(result);
        }
    }

    @Override
    public void reset() {
        this.currentIndex = 0;
    }
    
    @Override
    public int size() {
        return this.list.size();
    }
    
    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
    
    private void fixIndex(){
        if(this.currentIndex >= this.size()){
            this.currentIndex = this.currentIndex - this.size();
        }
        else if(this.currentIndex < 0){
            this.currentIndex = this.currentIndex + this.size();
        }
    }
}
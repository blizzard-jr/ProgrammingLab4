package Things;

import Things.Inanimate;
import Things.Thing;

import java.util.ArrayList;

public class Basket extends Inanimate {
    private ArrayList<String> subject = new ArrayList<>();
    public Basket(int w, String c, String n) {
        super(w, c, n);
    }
    public void putSubject(String sub){
        subject.add(sub);
    }
    public String getSubject(int i){
        return subject.get(i);
    }
    public int getCapacity(){
        return subject.size();
    }
}

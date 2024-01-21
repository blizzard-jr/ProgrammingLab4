package Things;

import java.util.Objects;

public abstract class Inanimate {
    private final String name;
    private final double weight;
    private final String color;
    public Inanimate(double w, String c, String n){
        if(w<0.1){
            throw new IllegalWeightException("Вес не может быть отрицательным");
        }
        else{
            this.weight = w;
        }
        this.color = c;
        this.name = n;
    }
    @Override
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass()){
            return false;
        }
        if(o == this){
            return true;
        }
        Inanimate x = (Inanimate) o;
        return (this.weight == x.weight) && (Objects.equals(this.color, x.color)) && (Objects.equals(this.name, x.name));

    }
    @Override
    public int hashCode(){
        return Objects.hash(this.weight, this.color, this.name);
    }
    @Override
    public String toString(){
        return this.name + ", весом в " + this.weight + " грамм, " + " цвет: " + this.color;
    }
    String getName(){
        return name;
    }

}

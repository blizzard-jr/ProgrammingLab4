package Things;

import Things.Inanimate;
import Things.ThingStatus;

public class Boat extends Inanimate {
    public final int maxSize;
    private ThingStatus stat;
    final private Bow bow = new Bow("Киперский");
    final private Sail sail = new Sail("Белый", true);
    final private Board board = new Board("Дерево");
    public Boat(int maxS, double w, String c, String n){
        super(w, c, n);
        maxSize = maxS;

    }
    public void rush(){
        System.out.println("С туго натянутым парусом " + toString() + " стрелой неслась к горизонту");
    }
    @Override
    public String toString(){
        return "Лодка по имени: " + getName() + ", с парусом цвета: " + sail.color + ", бортом из материала: " + board.material + ", и носовой часть типа: " + bow.model;
    }
    public void setBoatStat(ThingStatus stat){
        this.stat = stat;
    }
    private class Bow{
        String model;
        private Bow(String model){
            this.model = model;
        }
    }
    private class Sail{
        String color;
        boolean tension;
        private Sail(String color, boolean tension){
            this.color = color;
            this.tension = tension;
        }
    }
    private class Board{
        String material;
        private Board(String material){
            this.material = material;
        }
    }


}

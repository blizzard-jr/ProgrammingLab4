package mumiytroll;

import Main.IlligalInputException;

import java.util.Objects;

public abstract class Trolls {
    private final String name;
    private int coordinateX;
    private int coordinateY;
    public Trolls(int x, int y, String name) {
        this.coordinateX = x;
        this.coordinateY = y;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    /*public void setName(String name){
        this.name = name;
    }*/
    public int getCoordinateX(){
        return coordinateX;
    }
    public void setCoordinateX(int x){
        this.coordinateX = x;
    }
    public int getCoordinateY(){
        return coordinateY;
    }
    public void setCoordinateY(int y){
        this.coordinateY = y;
    }

    public abstract void goTravel();

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        else if(o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Trolls x = (Trolls) o;
        return (x.coordinateX == this.coordinateX && x.coordinateY == this.coordinateY) && (Objects.equals(x.name, this.name));
    }

    @Override
    public String toString(){
        return "Я " + this.getName() + ". Мои координаты: (" + this.getCoordinateX() + ", " + this.getCoordinateY() + ")";
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.coordinateX, this.coordinateY, this.name);
    }

}

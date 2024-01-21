package Things;

public class Jar extends Inanimate {
    private ThingStatus stat;
    public Jar(double w, String c, String n){
        super(w, c, n);
    }

    public void setJarStat(ThingStatus stat){
        this.stat = stat;
    }
    public ThingStatus getJarStat(){
        return stat;
    }
}

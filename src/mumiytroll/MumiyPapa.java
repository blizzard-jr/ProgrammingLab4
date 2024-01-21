package mumiytroll;

import Main.IlligalInputException;

import java.util.ArrayList;
import java.util.Scanner;

public class MumiyPapa extends Trolls implements Main_characters {
    TrollsEmotion emotion;
    public MumiyPapa(int x, int y, String name) throws IlligalInputException {

        super(x, y, name);
    }
    /*
    public void setStatus(TrollsEmotion stat){
        emotion = stat;
    }
    public TrollsEmotion getStatus(){
        return emotion;
    }
     */
    public void steer(){
        System.out.println(this.getName() + " рулил");
    }
    public void swear(){
        this.emotion = TrollsEmotion.STRICTNESS;
        System.out.println("А ведь я спрашивал, не забыла ли ты чего! — строго сказал " + this.getName());
    }

    @Override
    public void goTravel(){
        System.out.println(this.getName() + " отправился в петешествие");
    }

    public void take_sip() {
        System.out.println(this.getName() + " отпил глаток");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Как считаете, ему понравлся напиток?: \n\"Enter - Да, Another - Нет\"");
        if(scanner.nextLine() != ""){
            setGeneralMood(TrollsEmotion.SADNESS);
        }
        else{
            this.emotion = TrollsEmotion.PLEASURE;
            setGeneralMood(TrollsEmotion.ENTHUSIASM);
        }

    }
    @Override
    public void setGeneralMood(TrollsEmotion stat){
        Friend.generalEmotion = stat;
    }
    @Override
    public TrollsEmotion getGeneralMood(){
        return Friend.generalEmotion;
    }
    @Override
    public void callEveryone(ArrayList<Friend> fr){
        for (int i = 0; i < fr.size(); i++) {
            fr.get(i).setCoordinateX(this.getCoordinateX());
            fr.get(i).setCoordinateY(this.getCoordinateY());
        }
        System.out.println(this.getName() + " подозвал всех");
    }
}

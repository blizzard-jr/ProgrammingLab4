package mumiytroll;

import Things.Basket;

import java.util.ArrayList;

public class MumiyMama extends Trolls implements Main_characters {

    TrollsEmotion emotion;

    public MumiyMama(int x, int y, String name){
        super(x, y, name);
    }

    public void recited() {
        this.emotion = TrollsEmotion.PRIDE;
        System.out.println(this.getName() + " городо продекламировала \"Сим крещу тебя на вечные времена, и имя тебе \"Приключение\" (такова формула крещения у всех муми-троллей)");

    }
    public void sleep(){
        System.out.println(this.getName() + " дремала");
    }

    public boolean CheckBasket(ArrayList<Basket> baskets){
        boolean flag = false;
        for (int i = 0; i < baskets.size(); i++) {
            for (int j = 0; j < baskets.get(i).getCapacity(); j++) {
                if(baskets.get(i).getSubject(j).equals("Фруктовый сок")){
                    flag = true;
                }
            }
        }
        System.out.println(this.getName() + " обшарила корзины");
        if (!flag){
            System.out.println("Фруктовый сок не найден");
            System.out.println("Какая жалость! — воскликнула " + this.getName() + " она. — Похоже, я забыла дома фруктовый сок!");
        }
        else{
            System.out.println("Фруктовый сок найден");
        }
        return flag;
    }

    @Override
    public void goTravel(){
        System.out.println(this.getName() + " отправилась в путешествие");
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
        System.out.println(this.getName() + " подозвала всех");

    }
}

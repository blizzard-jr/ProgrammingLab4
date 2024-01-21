package Main;

import Things.*;
import mumiytroll.*;
import java.util.ArrayList;
import java.util.Scanner;


/*                                                    Текст
Муми-мама обшарила все свои корзины.
— Какая жалость! — воскликнула она. — Похоже, я забыла дома фруктовый сок!
— А ведь я спрашивал, не забыла ли ты чего! — строго сказал Муми-папа.
Все ужасно расстроились. Плавание под парусами на новой лодке, не окрещенной по всем правилам, может закончиться плачевно.
И тут Муми-тролля осенило.
— Давай мне кастрюли, — сказал он, наполнил кастрюли морской водой и отправился в грот.
 Вернувшись, он подал папе кастрюлю и сказал: — Ну-ка попробуй!
Муми-папа отпил глоток и просиял от удовольствия.
Они наполнили волшебной водой банку из-под варенья и разбили ее об нос лодки.
 Муми-мама гордо продекламировала: «Сим крещу тебя на вечные времена, и имя тебе „Приключение“
  (такова формула крещения у всех муми-троллей), и все закричали „ура!“.
 Затем корзины, одеяла, зонтики, удочки, подушки, кастрюли и плавки погрузили на борт,
  и Муми-семейство с друзьями поплыли по пустынному зеленому морю.
Погода стояла чудесная, хотя и не совсем ясная, потому что солнце было затянуто легкой золотистой дымкой.
 С туго натянутым парусом «Приключение» стрелой неслось к горизонту.
  Волны звучно плескались в его борта, в снастях свистел ветер, а вокруг носа плясали русалки.
Снифф связал шнурком свои игрушечные суденышки одно за другим, так что в кильватере у них плыла целая флотилия.
 Муми-папа рулил, Муми-мама дремала. Ведь очень редко случалось, чтобы вокруг нее было так спокойно.
  В вышине над ними кружили большие белые птицы.

 */



public class Main {
    public static void main(String[] args) throws IlligalInputException {
        Main main = new Main();
        main.history_course();

    }

    public void moreHistoryCourse(MumiyPapa papa){
        papa.swear();
        papa.setGeneralMood(TrollsEmotion.SADNESS);
        ArrayList<Pot> pots = new ArrayList<>();
        pots.add(new Pot(0.5, "Серебрянный", "Кастрюля"));
        pots.add(new Pot(0.7, "Серебрянный", "Кастрюля"));
        OneFriendPart(papa, pots);
    }
    public void moreHistoryCourse(Boat boat){
        boat.rush();
        new Entourage.Waves().splash();
        new Entourage.Wind().whistled();
        new Entourage.Mermaids().dance();

    }
    public void history_course() throws IlligalInputException {
        MumiyPapa papa = makeMumiyPapa();
        MumiyMama mama = makeMumiyMama();
        if(Math.abs(mama.getCoordinateX() - papa.getCoordinateX()) < 10 && Math.abs(mama.getCoordinateY() - papa.getCoordinateY()) < 10){
            System.out.println("Главные герои успешно созданы");
        }
        else{
            System.out.println("У нас патриархат, вы что, мама не может быть так далеко от отца, подумайте над этим и возвращайтесь");
            return;
        }
        ArrayList<Friend> friends = makeFriends(papa, mama);
        if(friends.isEmpty()){
            System.out.println("Упс, друзей не оказалось ни рядом с МумиПапой, ни рядом с МумиМамой, какое же путешествие без друзей(");
            return;
        }
        Boat boat = new Boat(5, 1000, "Жёлтый", "Приключение");
        Jar jar = new Jar(3.5, "Прозрачный", "Банка");
        ArrayList<Basket> baskets = new ArrayList<>();
        //Basket b = new Basket(1, "Чёрная", "Корзина");
        //b.putSubject("Фруктовый сок");
        //baskets.add(b);
        baskets.add(new Basket(5, "Коричневая", "Корзина"));
        baskets.add(new Basket(2, "Коричневая", "Корзина"));
        if(story_check(mama.CheckBasket(baskets))){
            moreHistoryCourse(papa);
        }
        papa.take_sip();
        if(!(story_check(papa))){
            return;
        }
        friends.get(0).initiatorOfFill(jar);
        friends.get(0).initiatorOfBreak(jar);
        mama.callEveryone(friends);
        mama.recited();
        friends.get(0).initiatorOfScream();
        papa.callEveryone(friends);
        second_part(boat);
        for (int i = 0; i < friends.size(); i++) {
            friends.get(i).goTravel();
        }
        mama.goTravel();
        papa.goTravel();
        moreHistoryCourse(boat);
        secondOneFriendPart();
        papa.steer();
        mama.sleep();
        lastPart();
    }
    public MumiyPapa makeMumiyPapa() throws IlligalInputException {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        try {
            System.out.println("Вам выпала честь дать имя отцу семейства: ");
            name = scanner.nextLine();
            processInput(name);
        }catch (IlligalInputException e){
            System.out.println(e.getMessage());
            System.out.println("Повторите попытку");
            history_course();
        }
        System.out.println("Теперь определите его местоположение: ");
        System.out.println("Координата x: ");
        int x = scanner.nextInt();
        System.out.println("Координата y: ");
        int y = scanner.nextInt();
        return new MumiyPapa(x, y, name);
    }
    public void processInput(String name) throws IlligalInputException {
        if(name.isEmpty()){
            throw new IlligalInputException("Ошибка пустого ввода");
        }
        else{
            System.out.println("Имя прошло проверку");
        }
    }
    public void OneFriendPart(MumiyPapa papa, ArrayList<Pot> pots) {
        class Grotto {
            final int coordinateX = papa.getCoordinateX() + 50;
            final int coordinateY = papa.getCoordinateY() + 74;

        }
        var friend = new Friend(papa.getCoordinateY(), papa.getCoordinateY(), "Муми-тролль") {
            TrollsEmotion emotion = TrollsEmotion.ILLUMINATION;
            void fillPots(ArrayList<Pot> pots) {
                System.out.println("И тут Муми-тролля осенило. Давай мне кастрюли, — сказал он");
                for (int i = 0; i < pots.size(); i++) {
                    System.out.println("Кастрююля №" + i + " наполнена морской водой");
                }
            }

            void GoToGrotto(Grotto grotto) {
                this.setCoordinateX(grotto.coordinateX);
                this.setCoordinateY(grotto.coordinateY);
                System.out.println(getName() + " отправился в грот");
            }

            void goBack() {
                this.setCoordinateX(papa.getCoordinateX());
                this.setCoordinateY(papa.getCoordinateY());
                System.out.println("Вернувшись, он подал папе кастрюлю и сказал: — Ну-ка попробуй!");
            }
        };
        friend.fillPots(pots);
        friend.GoToGrotto(new Grotto());
        friend.goBack();
    }
    public void secondOneFriendPart(){
        class Sniff{
            private void play(){
                System.out.println("Снифф связал шнурком свои игрушечные суденышки одно за другим, так что в кильватере у них плыла целая флотилия.");
            }
        }
        new Sniff().play();
    }
    public void lastPart(){
        class Birds{
            public void circle(){
                System.out.println("В вышине кружиле большие белые птицы");
            }
        }
        new Birds().circle();
    }
    public MumiyMama makeMumiyMama(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Не менее почётная задача, дайте имя маме семейства: ");
        String name = scanner.nextLine();
        System.out.println("Теперь определите её местоположение: ");
        System.out.println("Координата x: ");
        int x = scanner.nextInt();
        System.out.println("Координата y: ");
        int y = scanner.nextInt();
        return new MumiyMama(x, y, name);
    }
    public boolean story_check(MumiyPapa papa){
        if(papa.getGeneralMood() == TrollsEmotion.SADNESS){
            System.out.println("Друзья расстроились и разьехались по домам, на этом история закончилась");
            return false;
        }
        else{
            System.out.println(papa.getName() +  " просиял от удовольствия");
            return true;
        }
    }
    public boolean story_check(boolean check){
        if(check){
            return false;
        }
        else{
            return true;
        }
    }
    public ArrayList<Friend> makeFriends(MumiyPapa papa, MumiyMama mama){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Теперь нужно создать в нашем абстрактном мирке друзей: Tap Enter please");
        ArrayList<Friend> friends = new ArrayList<>();
        while(scanner.nextLine() == ""){
            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            System.out.println("Теперь определимся с местоположением: ");
            System.out.println("Координата x: ");
            int x = scanner.nextInt();
            System.out.println("Координата y: ");
            int y = scanner.nextInt();
            friends.add(new Friend(x, y, name));
            System.out.println("\"Продолжить\" - Enter, \"Достаточно\" - Another");
            scanner.nextLine();

        }
        for (int i = 0; i < friends.size(); i++) {
            if((Math.abs(papa.getCoordinateX() - friends.get(i).getCoordinateX()) > 10 || Math.abs(papa.getCoordinateY() - friends.get(i).getCoordinateY()) > 10) && (Math.abs(mama.getCoordinateX() - friends.get(i).getCoordinateX()) > 10 || Math.abs(mama.getCoordinateY() - friends.get(i).getCoordinateY()) > 10)){
                friends.remove(i);
            }
        }
        System.out.println("Итак, в истории будут принимать участие " + friends.size() + " друзей");
        return friends;
    }

    public void second_part(Boat boat){
        System.out.println("Настало время погрузки\nВыберите вещь, которую собираетесь погузить: \n0 - Удочка, 1 - Плавки, 2 - Подушка, 3 - Одеяло, 4 - Зонтик, 5 - Корзина, 6 - Кастрюля, 7 - завершить погрузку");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        ArrayList<Inanimate> things = new ArrayList<>();
        while(m != 7){
            if(boat.maxSize == things.size()){
                boat.setBoatStat(ThingStatus.UPLOADED);
                System.out.println("Лодка полностью загружена");
                break;
            }
            else{
                switch (m) {
                    case 0 -> things.add(new Rod(2, "Коричневый", "Удочка"));
                    case 1 -> things.add(new Trunks(0.12, "Белый", "Плавки"));
                    case 2 -> things.add(new Pillow(5, "Жёлтый", "Подушка"));
                    case 3 -> things.add(new Blanket(1.32, "Белый", "Одеяло"));
                    case 4 -> things.add(new Umbrella(1, "Чёрный", "Зонтик"));
                    case 5 -> things.add(new Basket(5, "Бежевый", "Корзина"));
                    case 6 -> things.add(new Pot(1, "Серебряный", "Кастрюля"));
                }
                System.out.println("Шмоточка успешно погружена\nВыберите вещь, которую собираетесь погузить: \n0 - Удочка, 1 - Плавки, 2 - Подушка, 3 - Одеяло, 4 - Зонтик, 5 - Корзина, 6 - Кастрюля, 7 - завершить погрузку");
                m = scanner.nextInt();
            }
        }
        System.out.println("Погрузка звершена");
        System.out.println("Итак, вы погрузили: ");
        for (int i = 0; i < things.size(); i++) {
            System.out.println(things.get(i).toString());
        }

    }
}
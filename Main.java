import Exceptions.WrongHairColor;
import Spaces.Building;
import Spaces.Flat;
import Spaces.Space;
import Caracters.FrekenBok;
import Caracters.Human;
import Caracters.Karlson;
import Caracters.UncleJulius;
import Caracters.Enums.Color;
import Caracters.Enums.Food;
import Caracters.Enums.Mood;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws WrongHairColor, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Space Universe = new Space("Цена за эту силу слишком высока. — Я готов ее заплатить!");

        Karlson KARLSON = new Karlson("Карлсон", 3);
        Karlson.HairColor = Color.ORANGE;
        if (Karlson.HairColor != Color.ORANGE){
            throw new WrongHairColor("У Карлсона должны быть ружие волосы!");
        }
        FrekenBok FREKENBOK = new FrekenBok("Фрекен бок", 5);
        UncleJulius UNCLEJULIUS = new UncleJulius("Дядя Юлиус", 0);
        Human GERR_SVANTESON = new Human("Герр Свантесон");
        Human FRU_SVANTESON = new Human("Фру Свантксон");
        Human BOSSE = new Human("Боссе");
        Human BETAN = new Human("Бетан");
        Human BABY = new Human("Сванте");

        Building KarlsonHouse = new Building("roof of the Baby's flat"){
            private int CountJamBarsStored = 10;
            public void SecretelyEatStoredJam(Karlson person){
                if (CountJamBarsStored > 0){
                    person.toEat(Food.JAM);
                    CountJamBarsStored --;
                } else {
                    System.out.println("К сожадению, все варенье закончилось(");
                }
            }
        };
        Flat BabyHouse = new Flat("Ordinary house on the ordinary street", new String[]{"Коридор", "Кухня",
                "Комната малыша", "Комната родителей","Гостевая комната"}, GERR_SVANTESON, FRU_SVANTESON, BOSSE, BETAN, BABY);

       BABY.go_to(BabyHouse.get_rooms().get("Коридор"));
       KARLSON.go_to((Space) BabyHouse.get_rooms().get("Коридор"));
       UNCLEJULIUS.go_to((Space) BabyHouse.get_rooms().get("Коридор"));
       FREKENBOK.go_to((Space) BabyHouse.get_rooms().get("Коридор"));
       UNCLEJULIUS.go_to((Space) BabyHouse.get_rooms().get("Гостевая комната"));
       FREKENBOK.go_to((Space) BabyHouse.get_rooms().get("Гостевая комната"));
       FREKENBOK.saySmth("этот толстый мальчишка - школьный товарищ Малыша, всякий раз он придумывает бог знает какие дикие шалости");
       UNCLEJULIUS.saySmth("И матрац был жесток, и кровать коротка, и одеяло слишком тонкое...");

       UNCLEJULIUS.go_to((Space) BabyHouse.get_rooms().get("Кухня"));
       FREKENBOK.go_to((Space) BabyHouse.get_rooms().get("Кухня"));
       BABY.go_to((Space) BabyHouse.get_rooms().get("Кухня"));
       KARLSON.go_to((Space) BabyHouse.get_rooms().get("Кухня"));
       UNCLEJULIUS.toEat(Food.CHICKEN);
       FREKENBOK.lookOn(UNCLEJULIUS);
       BABY.lookOn(UNCLEJULIUS);
       KARLSON.lookOn(UNCLEJULIUS);
       UNCLEJULIUS.setMood(Mood.ARROGANT);
       KARLSON.saySmth("Дядя Юлиус,скажи, тебе когда-нибудь кто-нибудь говорил, что ты красивый, умный и в меру упитанный мужчина в самом расцвете сил?");
       UNCLEJULIUS.saySmth("Нет, этого мне никто ещё не говорил.");
       KARLSON.saySmth("Не говорил, значит?");
       BABY.saySmth("Карлсон, перестань…");

        KARLSON.setMood(Mood.OFFENDED);
        if (! UNCLEJULIUS.equals(KARLSON)) {
            UNCLEJULIUS.lookOn(KARLSON);
        }
        UNCLEJULIUS.toEat(Food.CHICKEN);
        FREKENBOK.offerDishToSomeone(Food.CHICKEN, KARLSON);

        System.out.println();

        Class KarlsonClassObject = Karlson.class;
        Method KarlsonsMethod = KarlsonClassObject.getDeclaredMethod("sayFunnyFrase", null);
        KarlsonsMethod.setAccessible(true);
        KarlsonsMethod.invoke(KARLSON);
    }
}

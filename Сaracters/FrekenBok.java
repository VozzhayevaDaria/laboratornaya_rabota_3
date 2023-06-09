package Caracters;

import Caracters.Enums.Food;
import Caracters.Enums.Mood;
import Caracters.Interfaces.Welcoming;

public class FrekenBok extends Human implements Welcoming {
    private int countCoockedDishes;

    public  FrekenBok(String name){
        super(name);
        this.age = 50;
        this.countCoockedDishes = 0;
    }
    public FrekenBok(String name, int count){
        super(name);
        this.age = 50;
        if (count < 0){
            this.countCoockedDishes = 0;
        } else {
            this.countCoockedDishes = count;
        }
    }
    public void cookSomeFood(Food food){
        this.countCoockedDishes ++;
    }
    @Override
    public void offerDishToSomeone(Food food, Human person){
        if (person.isHungry() && countCoockedDishes > 0){
            person.setHunger(false);
            this.countCoockedDishes --;
            System.out.println("Фрекен Бок: Дорогой " + person.getName() + ", пожалуйста, угощайтесь!");
        } else if (countCoockedDishes <= 0){
            System.out.println("Фрекен Бок: К сожалению, я еще ничего не приготовила(");
        } else {
            System.out.println("Фрекен Бок: Дорогой " + person.getName() + ", пожалуйста, угощайтесь!");
            System.out.println(person.getName() + ": Выглядит очень вкусно, но я не голоден");
        }
    }
    @Override
    public void setGoodMood(){
        this.setMood(Mood.HAPPY);
    }
}

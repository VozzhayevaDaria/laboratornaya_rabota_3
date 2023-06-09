package Caracters;

import Caracters.Enums.*;

public class Human extends Creature{
    private boolean hunger;
    private String favoriteDish;
    private Mood mood;
    public static Color HairColor;
    public boolean equals(Human hum) {
        return this.getName() == hum.getName() &&
                this.getAge() == hum.getAge() &&
                this.getFavoriteDish() == hum.getFavoriteDish();
    }
    public int hashCode(){
        return name.length() + favoriteDish.length() + age;
    };
    public String toString(){
        return this.name;
    }

    public Human(String name){
        this.name = name;
        this.mood = Mood.CALM;
        this.hunger = true;
    }
    public Human(String name, int age){
        if (age <= 0){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        this.mood = Mood.CALM;
        this.hunger = true;
    }
    public String  getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public boolean isHungry(){
        return hunger;
    }
    public void setHunger(boolean mod){
        this.hunger = mod;
    }
    public void toEat(Food food){
        if (! this.hunger) {
            System.out.println(name + ": Я не голоден(");
        } else {
            this.setHunger(false);
            System.out.println(name + ": Какой вкусный " + food + "!");
        }
    }
    public String  getFavoriteDish(){
        return this.favoriteDish;
    }

    public boolean isFavoriteDish(Food dish){
        return (name.length() + age + dish.toString().length()) == this.hashCode();
    }

    public void setFavoriteDish(String dish){
        this.favoriteDish = dish;
        System.out.println(name + ": Мне так нравится " + dish);
    }

    public Mood getMood(){
        return this.mood;
    }
    public void setMood(Mood mood){
        this.mood = mood;
        System.out.println(name + ": Что-то я сегодня " + mood);
    }
    public void saySmth(String frase){
        System.out.println(name + ": " + frase);
    }
    public void lookOn(Human hum){System.out.println(this.name + " посмотрел на " + hum.getName());
    }
}

package Caracters;

import Spaces.Space;
import Caracters.Enums.Food;

public abstract class Creature {
    protected String name;
    protected int age;
    protected Space place;
    public abstract String  getName();
    public abstract int getAge();
    public abstract void toEat(Food food);
    public abstract void saySmth(String frase);
    public void go_to(Space place){
        this.place = place;
    }
}

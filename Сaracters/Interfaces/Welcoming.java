package Caracters.Interfaces;

import Caracters.Enums.Food;
import Caracters.Human;

public interface Welcoming {
    public void offerDishToSomeone(Food food, Human person);
    public void setGoodMood();
}

package Caracters;

import Caracters.Interfaces.FlyingObject;
import Caracters.Enums.FlyingTool;
import Caracters.Enums.Food;

public class Karlson extends Human implements FlyingObject {
    private FlyingTool flyingTool;
    private int eatedJamBars;
    private boolean inAir;
    private static class KarlsonsPropeller{
        int blade_count = 3;
        int energy_bar = 10;
        Boolean is_working = false;
        public void turnOn(Karlson KARLSON){
            if (is_working){
                System.out.println("Пропеллер итак уже включен");
            } else if (energy_bar != 0){
                is_working = true;
                energy_bar --;
                KARLSON.toFly();
            } else {
                System.out.println("Пропеллер Карлсона разрядился, включть его не получится(");
            }
        }
        public void turnOf(Karlson KARLSON){
            if (! is_working) {
                System.out.println("Пропеллер итак уже выключен");
            } else {
                is_working = false;
                KARLSON.toLand();
            }
        }
    }

    public Karlson(){
        super("Карлсон", 45);
        this.flyingTool = FlyingTool.PROPELLER;
    }
    public Karlson(String name) {
        super(name);
        this.flyingTool = FlyingTool.PROPELLER;
    }
    public Karlson(String name, int age){
        super(name, age);
        this.flyingTool = FlyingTool.PROPELLER;
    }
    public Karlson(String name, int age, FlyingTool tool){
        super(name, age);
        this.flyingTool = FlyingTool.PROPELLER;
        if (tool != FlyingTool.PROPELLER){
            System.out.println("Как же Карлсон без пропеллера...(");
        }
    }
    @Override
    public boolean isFlying(){
        return inAir;
    }
    @Override
    public void toFly(){
        if (inAir){
            System.err.println("Карлсон: Бесконечность, конечно, не предел, но я уже летаю");
        } else {
            this.inAir = true;
            System.out.println("Карлсон: Включаю пропеллер, полетели!");
        }
    }
    @Override
    public void toLand(){
        if (inAir){
            this.inAir = false;
            System.out.println("Карлсон: Выключаю пропеллер, иду на посадку");
        } else {
            System.err.println("Карлсон: Я и так стою на земле");
        }
    }
    public FlyingTool getFlyingTool(){
        return this.flyingTool;
    }
    public int getEatedJamBars(){
        return eatedJamBars;
    }
    public void toEat(Food food){
        if (food == Food.JAM){
            System.out.println("Карлсон: Мммм, мое любимое варенье)");
        } else if (! this.isHungry()) {
            System.out.println("Карлсон: Я не голоден(");
        } else {
            this.setHunger(false);
            System.out.println("Карлсон: Какой вкусный " + food + "!");
        }
    }

    public boolean equals(Karlson hum) {
        if (this.getClass() != hum.getClass()){
            return false;
        }else if (this.getName() == hum.getName() &&
                this.flyingTool == hum.getFlyingTool() &&
                this.getEatedJamBars() == hum.getEatedJamBars() &&
                this.getAge() == hum.getAge()) {
            return true;
        } else {
            return false;
        }
    }

    private void sayFunnyFrase() {
        System.out.println("Карлсон: Ты знаешь, моя бабушка - чемпион мира по обниманиям! Как налетит, как обнимет!");
    }
}

package Caracters;

public class UncleJulius extends Human {
    private int countTalledBykarlson;
    public UncleJulius(String name){
        super(name);
        this.age = 45;
        this.countTalledBykarlson = 0;
    }
    public UncleJulius(String name, int count){
        super(name);
        this.age = 45;
        if (count <= 0){
            this.countTalledBykarlson = 0;
        }else {
            this.countTalledBykarlson = count;
        }
    }
    public int getCountTalledBykarlson(){
        return this.countTalledBykarlson;
    }
    public void tellStoryBySomeone(Human person){
        if (person.getClass() == Karlson.class) {
            this.countTalledBykarlson ++;
            System.out.println("Дядя Юлиус: Какаие у тебя, Карлсон, интересные сказки!");
        } else {
            System.out.println("Дядя Юлиус: Извините, я слушаю сказки только от Карлсона(");
        }
    }
}

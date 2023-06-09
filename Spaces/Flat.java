package Spaces;

import Exceptions.WrongResidentxception;
import Spaces.InterfacesAndEnums.K_rauta;
import Spaces.InterfacesAndEnums.LivingSpace;
import Caracters.Human;
import Caracters.Karlson;
import Caracters.Enums.Food;

import java.util.*;

public class Flat extends Building implements LivingSpace {
    private Human[] residents;
    private int resident_count = 0;
    private Hashtable<String, Room> rooms = new Hashtable();
    protected class Room extends Space{
        private K_rauta.WallsMaterial RoomWallsAppearance = K_rauta.WallsMaterial.CONCRETE;
        private K_rauta.Color RoomWallsColor = K_rauta.Color.GREY;
        private K_rauta.FloorMaterial RoomFloorApparance = K_rauta.FloorMaterial.CONCRETE;
        private K_rauta.Color RoomFloorColor = K_rauta.Color.GREY;

        public void RoomWallsRepair(K_rauta.WallsMaterial material, K_rauta.Color color){
            RoomWallsAppearance = material;
            RoomWallsColor = color;
        }
        public void RoomFloorRepair(K_rauta.FloorMaterial material, K_rauta.Color color){
            RoomFloorApparance = material;
            RoomFloorColor = color;
        }

        public void RoomRepair(Human repairer, K_rauta.WallsMaterial wall_material, K_rauta.Color wall_color,
                               K_rauta.FloorMaterial floor_material, K_rauta.Color floor_color){
            if (Arrays.asList(residents).contains(repairer)){
                this.RoomWallsRepair(K_rauta.WallsMaterial.CONCRETE, K_rauta.Color.GREY);
                this.RoomFloorRepair(K_rauta.FloorMaterial.CONCRETE, K_rauta.Color.GREY);
                System.out.println("К сожалению, ремонт никогда не будет окончен...");
            }
            else {
                this.RoomWallsRepair(wall_material, wall_color);
                this.RoomFloorRepair(floor_material, floor_color);
                System.out.println("Прекрасно, ремонт завершен!");
            }
        }
    }
    private Flat(){
        super("");
    }
    public Flat(String adress, String[] room_callings, Human... residents){
        super(adress);
        Karlson TrueKarlson = new Karlson();
        for (int i=0; i < residents.length; i++){
            if (residents[i].getClass() == TrueKarlson.getClass()){
                throw new WrongResidentxception("Карлсон не может жить в обычной квартире!");
            }
        }
        this.residents = residents;
        for (int i=0; i < room_callings.length; i++){
            rooms.put(room_callings[i], new Room());

        }
    }
    public Hashtable<String, Room> get_rooms(){
        return rooms;
    }

    public void fallAsleep(Human person){
        if (Arrays.asList(residents).contains(person)){
            if (person.isHungry()){
                System.out.println("К сожалению, " + person.getName() + " голоден и не может уснуть");
            }else{
                System.out.println(person.getName() + " наелся и спит)");
            }
        }else{
            System.out.println(person.getName() + " живет не здесь и не может тут спать");
        }
    }
    public void celebrateNY(Human cooker, Human... persons){
        class HolidayTable{
            private Food[] dishes;
            public HolidayTable(Human cooker, Food... dishes){
                this.dishes = dishes;
                System.out.println(cooker.getName() + "накрыл(а) на стол, устал(а) и уснул(а)");
            }
            public Food getRandomDish(){
                return dishes[new Random().nextInt(dishes.length)];
            }
        }

        HolidayTable table = new HolidayTable(cooker, Food.OLIVIE, Food.CRAB_SALAD, Food.CAVIAR_SANDWICHES,
                Food.SLICED_CHEESE, Food.SLICED_MEAT);

        for (int i = 0; i < persons.length; i++){
            if (persons[i] != cooker){
            persons[i].toEat(table.getRandomDish());}
        }
        for (int i = 0; i < persons.length; i++){
            if (persons[i] != cooker){
            this.fallAsleep(persons[i]);}
        }
    }


}

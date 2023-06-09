package Spaces;

import Spaces.InterfacesAndEnums.K_rauta;

public class Building extends Space{

    private String adress;
    private K_rauta.WallsMaterial WallsAppearance = K_rauta.WallsMaterial.CONCRETE;
    private K_rauta.Color WallsCollor = K_rauta.Color.GREY;
    private K_rauta.FloorMaterial FloorAppearance = K_rauta.FloorMaterial.CONCRETE;
    private K_rauta.Color FloorColor = K_rauta.Color.GREY;
    public Building(String adress){
        super();
        this.adress = adress;
    }

    public void glueWallpaper(K_rauta.WallsMaterial material, K_rauta.Color color){
        WallsAppearance = material;
        WallsCollor = color;
    }
    public void repaintFloors(K_rauta.FloorMaterial material, K_rauta.Color color){
        FloorAppearance = material;
        FloorColor = color;
    }
}

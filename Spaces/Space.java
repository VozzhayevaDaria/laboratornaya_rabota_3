package Spaces;

import Exceptions.SecondUniverseException;

public class Space {
     public static final double universe_age = 13.75 * Math.pow(10, 9);
     public static int count = 0;
     protected Space(){}
     public Space(String creation_frase){
         super();
         count ++;
         if (count == 2){
             throw new SecondUniverseException("Вы создали мультивселенную!");
         }
         System.out.println(creation_frase);
     }
}

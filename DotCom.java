package sinkADotCom;

import java.util.*;

public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> locs){
        locationCells = locs;
    }

    public void setName(String n){
        name = n;
    }

    public String checkYourself(String userInput){
        String result = "miss";

        int index = locationCells.indexOf(userInput);
        if(index >= 0){
            locationCells.remove(index);

            if(locationCells.isEmpty()){
                result = "kill";
                System.out.println("ouch! you hit my "+name+" :( ");
            }else{
                result = "hit";
            }
        }
        return result;
    }
}

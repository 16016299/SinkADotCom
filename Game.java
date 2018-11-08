package sinkADotCom;

import java.util.*;

public class Game {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    public void setUpGame(){
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Your goal is to sink three dot coms");
        System.out.println("Pets.com, eToys.com and go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");

        for(DotCom dotComToSet : dotComsList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    public void startPlaying(){
        while(!dotComsList.isEmpty()){
            String userGuess = helper.getUserInput("enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    public void checkUserGuess(String userGuess){
        numOfGuesses++;
        for(int x = 0 ; x < dotComsList.size; x++){
            result = dotComsList.get(x).checkYourself(userGuess);

            if(result.equals("hit")){
                break;
            }
            if(result.equals("kill")){
                dotComsList.remove(x);
                break;
            }
        }
        System.out.printin(result);
    }

    public void finishGame(){
        System.out.println("All Dot Coms are dead! your stock is now worthless");
        if(numOfGuesses < 18){
            System.out.println("it only took you "+numOfGuesses+" guesses");
            System.out.println("your options are safe");
        }
        else{
            System.out.println("it took you long enough: "+numOfGuesses+" guesses");
            System.out.println("your options are sleeping with the fishes");
        }
    }
}

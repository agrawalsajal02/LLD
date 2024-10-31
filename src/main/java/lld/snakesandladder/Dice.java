package lld.snakesandladder;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    Integer diceCount;
    Integer max = 1;
    Integer min = 6 ;

    public Dice(Integer count){
        this.diceCount=count;
    }

    public Integer rollDice(){
        Random random = new Random();
//        return 1+ random.nextInt(6);

        Integer count=0;
        Integer sum=0;
        while(count<diceCount){
//            sum+= ThreadLocalRandom.current().nextInt(1,6+1);
            Integer diceCount =ThreadLocalRandom.current().nextInt(6)+1 ;
              while(diceCount==6){
                  sum+=diceCount;
              }
                sum+=diceCount;
            count++;
        }

        return sum;
    }
}


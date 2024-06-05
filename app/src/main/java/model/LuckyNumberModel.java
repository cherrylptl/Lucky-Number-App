package model;

import java.util.Random;

public class LuckyNumberModel {
    public static int luckyNumber;

    public static void generateLuckyNumber(){
        Random random = new Random();
        luckyNumber =  100 + random.nextInt(900);
    }
}

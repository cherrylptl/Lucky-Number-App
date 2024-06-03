package com.example.luckynumberapp;

import java.util.Random;

public class LuckyNumberModel {
    static int luckyNumber = 100;

    public static void generateLuckyNumber(){
        Random random = new Random();
        luckyNumber = 100 + 100 + random.nextInt(900);
    }
}

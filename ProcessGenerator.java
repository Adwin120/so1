package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ProcessGenerator {
    private final Random gaussianRandom;
    private final Random doubleRandom;
    int index = 0;

    public ProcessGenerator(long seed) {
        this.gaussianRandom = new Random(seed);
        this.doubleRandom = new Random(seed);
    }
    public Process generateProcess(int momentZgloszenia) {
        int czasTrwania = 0;
        while(czasTrwania <= 0) czasTrwania = (int) (10*gaussianRandom.nextGaussian() + 5);
        return new Process(
                index++,
                czasTrwania,
                momentZgloszenia
        );
    }
    public ArrayList<Process> generateProcessesList(int amount, double initialChance, double chanceStep) {
        ArrayList<Process> list = new ArrayList<>();
        int time = 0;
        double currentChance = initialChance;
        while(list.size() <= amount) {
            if(doubleRandom.nextDouble() < currentChance) {
                list.add(generateProcess(time));
                currentChance = initialChance;
            } else {
                currentChance+=chanceStep;
            }
            time++;
        }
        return list;
    }
}

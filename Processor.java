package com.company;

import com.company.AlgorytmyPlanowania.AlgorytmPlanowania;

import java.util.ArrayList;
import java.util.Iterator;

public class Processor {
    AlgorytmPlanowania algorytm;
    int currentTime = 0;

    public Processor(AlgorytmPlanowania algorytm) {
        algorytm.setProcessor(this);
        this.algorytm = algorytm;
    }

    public ArrayList<Process> simulate(ArrayList<Process> processes) {
        Iterator<Process> processIterator = processes.iterator();
        Process nextProcess = processIterator.next();
        while(algorytm.getProcessesDone() < processes.size()) {
            if(nextProcess != null) {
                if (currentTime >= nextProcess.getMomentZgloszenia()) {
                    algorytm.report(nextProcess);
                    if(processIterator.hasNext())nextProcess = processIterator.next();
                    else nextProcess = null;
                }
            }
            tick();
        }
        return processes;
    }

    public ArrayList<Process> simulate(int amount, long seed, double initialChance, double chanceStep) {
        ArrayList<Process> processes = (new ProcessGenerator(seed)).generateProcessesList(amount, initialChance, chanceStep);
        return simulate(processes);
    }

    public void tick() {
        currentTime++;
        algorytm.tick();
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }
}

package com.company.AlgorytmyPlanowania;

import com.company.Process;
import com.company.Processor;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class SJF extends AlgorytmPlanowania{

    public SJF() {
        super(new PriorityQueue<>(11, new SJFComparator()));
    }

    public static class SJFComparator implements Comparator<Process> {
        @Override
        public int compare(Process o1, Process o2) {
            int timeLeftDifference = o1.getPozostalyCzas() - o2.getPozostalyCzas();
            return (timeLeftDifference == 0) ? o1.getMomentZgloszenia() - o2.getMomentZgloszenia() : timeLeftDifference;
        }
    }
}
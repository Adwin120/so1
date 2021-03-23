package com.company.AlgorytmyPlanowania;


import com.company.Process;
import com.company.Processor;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class RoundRobin extends AlgorytmPlanowania {

    private final float kwantCzasu;
    private float kwantLeft;

    public RoundRobin(float kwantCzasu) {
        super(new LinkedList<>());
        this.kwantCzasu = kwantCzasu;
    }

    @Override
    public void tick() {
        super.tick();
        if(currentProcess != null) {
            kwantLeft--;
            if(kwantLeft == 0) {
                processQueue.offer(currentProcess);
                getNextNonDeadProcess();
            }
        }
    }
    @Override
    protected void getNextNonDeadProcess() {
        super.getNextNonDeadProcess();
        kwantLeft = kwantCzasu;
    }
}
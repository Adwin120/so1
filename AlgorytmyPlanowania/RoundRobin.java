package com.company.AlgorytmyPlanowania;


import com.company.Process;
import com.company.Processor;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class RoundRobin implements AlgorytmPlanowania {

    private final float kwantCzasu;
    private final Queue<Process> processQueue = new LinkedList<>();
    private Process currentProcess = null;
    private int processesDone = 0;
    float kwantLeft;

    public RoundRobin(float kwantCzasu) {
        this.kwantCzasu = kwantCzasu;
    }

    @Override
    public void report(Process process) {
        processQueue.offer(process);
    }

    @Override
    public void tick() {
        if(currentProcess==null && !processQueue.isEmpty()) {
            currentProcess = processQueue.poll();
            kwantLeft = kwantCzasu;
        }
        for(Process x : processQueue) {
            x.wait(1);
        }
        if(currentProcess != null) {
            currentProcess.run(1);
            kwantLeft--;
            if(currentProcess.isDone()) {
                processesDone++;
                kwantLeft = kwantCzasu;
                while(!processQueue.isEmpty() &&Objects.requireNonNull(currentProcess = processQueue.poll()).getCzasOczekiwania() > 100) {
                    currentProcess.setZaglodzony(true);
                    processesDone++;
                }
            }
            if(kwantLeft == 0) {
                kwantLeft = kwantCzasu;
                processQueue.offer(currentProcess);
                while(!processQueue.isEmpty() && Objects.requireNonNull(currentProcess = processQueue.poll()).getCzasOczekiwania() > 100) {
                    currentProcess.setZaglodzony(true);
                    processesDone++;
                }
            }
        }
    }

    @Override
    public int getProcessesDone() {
        return processesDone;
    }

    @Override
    public void setProcessor(Processor processor) {
    }

    @Override
    public Processor getProcessor() {
        return null;
    }
}

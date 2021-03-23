package com.company.AlgorytmyPlanowania;

import com.company.Process;
import com.company.Processor;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class SJF implements AlgorytmPlanowania{

    protected final Queue<Process> processQueue = new PriorityQueue<>(11, new SJFComparator());
    protected int processesDone = 0;
    protected Process currentProcess = null;

    public SJF() {
    }

    @Override
    public void report(Process process) {
        processQueue.offer(process);
    }

    @Override
    public int getProcessesDone() {
        return processesDone;
    }

    @Override
    public void tick() {
        if(currentProcess == null && !processQueue.isEmpty()) {
            currentProcess = processQueue.poll();
        }
        for(Process x : processQueue) {
            x.wait(1);
        }
        if(currentProcess != null) {
            currentProcess.run(1);
            if(currentProcess.isDone()) {
                processesDone++;
                while(!processQueue.isEmpty() && Objects.requireNonNull(currentProcess = processQueue.poll()).getCzasOczekiwania() > 100) {
                    currentProcess.setZaglodzony(true);
                    processesDone++;
                }
            }
        }
    }

    @Override
    public void setProcessor(Processor processor) {

    }

    @Override
    public Processor getProcessor() {
        return null;
    }

    public static class SJFComparator implements Comparator<Process> {
        @Override
        public int compare(Process o1, Process o2) {
            int timeLeftDifference = o1.getPozostalyCzas() - o2.getPozostalyCzas();
            return (timeLeftDifference == 0) ? o1.getMomentZgloszenia() - o2.getMomentZgloszenia() : timeLeftDifference;
        }
    }
}
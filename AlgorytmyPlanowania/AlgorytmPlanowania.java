package com.company.AlgorytmyPlanowania;

import com.company.Process;
import com.company.Processor;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public abstract class AlgorytmPlanowania {

    protected final Queue<Process> processQueue;
    protected Process currentProcess = null;
    protected int processesDone = 0;

    public AlgorytmPlanowania(Queue<Process> processQueue) {
        this.processQueue = processQueue;
    }

    public void report(Process process) {
        processQueue.offer(process);
    }

    public int getProcessesDone() {
        return processesDone;
    }

    public void tick() {
        if(currentProcess==null) {
            getNextNonDeadProcess();
        }
        for(Process x : processQueue) {
            x.wait(1);
        }
        if(currentProcess != null) {
            currentProcess.run(1);
            if(currentProcess.isDone()) {
                processesDone++;
                getNextNonDeadProcess();
            }
        }
    }

    protected void getNextNonDeadProcess() {
        while(!processQueue.isEmpty() && Objects.requireNonNull(currentProcess = processQueue.poll()).getCzasOczekiwania() > 100) {
            currentProcess.setZaglodzony(true);
            processesDone++;
        }
    }
}
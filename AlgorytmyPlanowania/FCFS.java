package com.company.AlgorytmyPlanowania;

import com.company.Process;
import com.company.Processor;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class FCFS implements AlgorytmPlanowania {

    private final Queue<Process> processQueue = new LinkedList<>();
    private Process currentProcess = null;
    private Processor processor;
    private int processesDone = 0;

    public FCFS() {
    }

    @Override
    public void report(Process process) {
        processQueue.offer(process);
    }

    @Override
    public void tick() {
        if(currentProcess==null && !processQueue.isEmpty()) {
            currentProcess = processQueue.poll();
        }
        for(Process x : processQueue) {
            x.wait(1);
        }
        if(currentProcess != null) {
            currentProcess.run(1);
            if(currentProcess.isDone()) {
                processesDone++;
                //currentProcess.finish(processor.getCurrentTime());
                while(!processQueue.isEmpty() &&Objects.requireNonNull(currentProcess = processQueue.poll()).getCzasOczekiwania() > 100) {
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
    public Processor getProcessor() {
        return processor;
    }
    @Override
    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
}

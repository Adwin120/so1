package com.company.AlgorytmyPlanowania;

import com.company.Process;
import com.company.Processor;

public class SJFWywlaszczajacy extends SJF {

    @Override
    public void report(Process process) {
        if(currentProcess.getPozostalyCzas() > process.getPozostalyCzas()) {
            processQueue.offer(currentProcess);
            currentProcess = process;
        } else {
            processQueue.offer(process);
        }
    }
}
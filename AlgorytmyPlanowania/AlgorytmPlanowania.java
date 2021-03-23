package com.company.AlgorytmyPlanowania;

import com.company.Process;
import com.company.Processor;

public interface AlgorytmPlanowania {
    void report(Process process);
    void tick();
    int getProcessesDone();
    void setProcessor(Processor processor);
    Processor getProcessor();
}

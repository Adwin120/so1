package com.company;

import com.company.AlgorytmyPlanowania.FCFS;
import com.company.AlgorytmyPlanowania.RoundRobin;
import com.company.AlgorytmyPlanowania.SJF;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Processor FCFSProcessor = new Processor(new FCFS());
        ArrayList<Process> processes = FCFSProcessor.simulate(20, 2137, 0.3,0.05);
        for(Process x : processes) {
            System.out.println(x);
        }
        System.out.println("----------------------------------");
        Processor SJFProcessor = new Processor(new SJF());
        processes = SJFProcessor.simulate(20, 2137, 0.3,0.05);
        for(Process x : processes) {
            System.out.println(x);
        }
        System.out.println("---------------------------------");
        processes = (new Processor(new RoundRobin(5))).simulate(20, 2137, 0.3,0.05);
        for(Process x : processes) {
            System.out.println(x);
        }
        //dlugości: 11,7,7,30,29,...,15,14,3,3,19,3,7
        //momenty zgłoszenia: 2,3,8,9,14,15,16,17,...,32,25,28,40,43,49,57
    }
}

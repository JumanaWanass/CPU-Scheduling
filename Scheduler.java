package com.mycompany.mlfs;

import java.util.Arrays;
import java.util.Random;

public class Scheduler {

    private RoundRobinQueue rrQueue1;   // level 1
    private RoundRobinQueue rrQueue2;   // level 2
    private FCFSQueue fcfsQueue;        // level 3
    private int[] finishedProcesses;  // tracks which processes are finished
    private int fpIdx; // index of finished processes

    public Scheduler(int rrQueue1Size, int rrQueue2Size, int fcfsQueueSize) {
        this.rrQueue1 = new RoundRobinQueue(rrQueue1Size, 8);
        this.rrQueue2 = new RoundRobinQueue(rrQueue2Size, 16);
        this.fcfsQueue = new FCFSQueue(fcfsQueueSize);
        this.finishedProcesses = new int[100];
        this.fpIdx = 0;
    }
                    
    public void scheduleProcesses(Process[] processes) {
        // Level 1 - Round Robin
        rrQueue1.enqueueAll(processes);     // insert all input processes

        ProcessQueue nextQueue = new ProcessQueue(20);
        fpIdx = rrQueue1.execute(finishedProcesses, fpIdx, rrQueue2);
       

        // Decide where to send unfinished processes from level 2
        if (new Random().nextBoolean()) 
        {
            // 50% chance to send to level 1
            fpIdx = rrQueue2.execute(finishedProcesses, fpIdx, rrQueue1);
        } else 
        {
            // 50% chance to send to level 3
            fpIdx = rrQueue2.execute(finishedProcesses, fpIdx, fcfsQueue);
        }

        // Level 3 - FCFS
        fpIdx = fcfsQueue.execute(finishedProcesses, fpIdx);

        System.out.println("\nFinished processes after all queues:");
        // Output finished processes
        Arrays.stream(finishedProcesses).forEach(id -> System.out.print(id + " "));
    }
                
}

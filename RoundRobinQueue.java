package com.mycompany.mlfs;
import java.util.Queue;

public class RoundRobinQueue extends ProcessQueue {
    private int quanta;

    public RoundRobinQueue(int size, int quanta) 
    {
        super(size);
        this.quanta = quanta;
    }
    
    

    // Implements the RR scheduling policy
    public int execute(int[] finishedProcesses, int fpIdx, ProcessQueue nextQueue) 
    {
        while (!isEmpty()) 
        {
            Process p = dequeue();

            if (p.getBurstTime() <= quanta) 
            {
                if (p.getBurstTime() != 0) 
                {
                    p.setBurstTime(0);
                    finishedProcesses[fpIdx++] = p.getProcessID();
                }
            } 
            else 
            {
                p.setBurstTime(p.getBurstTime() - quanta);
                nextQueue.enqueue(p); // Enqueue to the specified next queue

            }
        }
        return fpIdx;
    }

  
}

package com.mycompany.mlfs;

public class FCFSQueue extends ProcessQueue
{
     public FCFSQueue(int size) 
    {
        super(size);
    }
    public int execute(int[] finishedProcesses, int fpIdx) 
{
    while (!isEmpty()) 
    {
        Process p = dequeue();
        if(p.getBurstTime() != 0)
        {
            p.setBurstTime(0);
            finishedProcesses[fpIdx++] = p.getProcessID();
        }      
    }
    return fpIdx;
}
      
}

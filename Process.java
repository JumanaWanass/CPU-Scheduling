package com.mycompany.mlfs;
import java.util.Random;

public class Process 
{
    public int process_id;
    public int burst_time;
    
    public int getProcessID() 
    {
        return process_id;
    }

    public void setProcessID(int process_id) {
        this.process_id = process_id;
    }

    public int getBurstTime() {
        return burst_time;
    }

    public void setBurstTime(int burst_time) {
        this.burst_time = burst_time;
    }

    
    public Process(int process_id, int burst_time) 
    {
        this.process_id = process_id;
        this.burst_time = burst_time;
    }
    
    static public void returnRandomProcesses(Process[] processes)
    {
        Random random = new Random();

        for (int i = 0; i < 100; i++) 
            processes[i] = new Process(i + 1, random.nextInt(101) ); 
        
    }
        
}

package com.mycompany.mlfs;
import java.util.Random;


public class MLFS 
{
    public static Process[] initializeProcesses()
    {
        Random random = new Random();
        Process[] processes = new Process[100];
        for (int i = 0; i < 100; i++) 
        {
            processes[i] = new Process(i + 1,random.nextInt(101) ); // Create a new Process object for each element in the array
        }

    
        return processes;
    }
    public static void main(String[] args) 
    {
        Process[] processes = initializeProcesses();
        Scheduler scheduler = new Scheduler(20, 20, 30); // Adjust the queue sizes as needed
        scheduler.scheduleProcesses(processes);
        
    }
}

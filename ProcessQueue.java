package com.mycompany.mlfs;

import java.util.LinkedList;
import java.util.Queue;

public class ProcessQueue 
{

    private int size;
    private Queue<Process> processes; // the current running processes
    private Queue<Process> waitingProcesses;

    // Constructor
    public ProcessQueue(int size) 
    {
        this.size = size;
        this.processes = new LinkedList<>();
        this.waitingProcesses = new LinkedList<>();

    }

    public int getSize() {
        return size;
    }

    // Check if the queue is full
    public boolean isFull() {
        return processes.size() >= size;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return processes.isEmpty();
    }

    // Return the last process in queue without dequeuing
    public Process peek() {
        return processes.peek();
    }

    // Get the number of processes in the queue
    public int getProcessCount() {
        return processes.size();
    }

    public void printQueue() {
        System.out.print("Queue contents: ");
        processes.forEach(process -> System.out.print(process.getProcessID() + " "));
        System.out.println();
    }
    
    // Add a process to the queue
    public boolean enqueue(Process process) 
    {
        if (!isFull()) 
        {
            processes.add(process);
            return true; // Successfully enqueued
        } 
        else 
        {
            waitingProcesses.add(process);
            return false; // Enqueue failed
        }
    }

    public void enqueueAll(Process[] processArray) 
    {
        for (Process process : processArray)      
            enqueue(process);           
        
    } 

    // Remove a process from the queue
    public Process dequeue() 
    {
        Process p = processes.remove();

        // Enqueue the first waiting process, if any
        if (!waitingProcesses.isEmpty()) 
        {
            processes.add(waitingProcesses.remove());
        }

        return p;
    }

    
}

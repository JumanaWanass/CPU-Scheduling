# Multilevel Feedback Queue Scheduler

This project implements a multilevel feedback queue (MLFS) scheduler for process scheduling. The scheduler uses three queues with different scheduling algorithms: two round-robin queues and one first-come-first-serve (FCFS) queue.

## Classes

- `Process`: Represents a process with a unique ID and burst time.
- `ProcessQueue`: A queue of processes with a maximum size. It includes methods to enqueue and dequeue processes.
- `FCFSQueue`: A subclass of `ProcessQueue` that implements a FCFS scheduling algorithm.
- `RoundRobinQueue`: A subclass of `ProcessQueue` that implements a round-robin scheduling algorithm.
- `Scheduler`: Handles the scheduling of processes across the three queues.

## Usage

To use the scheduler, create an array of `Process` objects and pass it to the `scheduleProcesses` method of a `Scheduler` object. The scheduler will then schedule the processes across the three queues and print the IDs of the processes in the order they finished.

```java
Process[] processes = MLFS.initializeProcesses();
Scheduler scheduler = new Scheduler(20, 20, 30); // Adjust the queue sizes as needed
scheduler.scheduleProcesses(processes);

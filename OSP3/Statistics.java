/**
 * This class contains a lot of public variables that can be updated
 * by other classes during a simulation, to collect information about
 * the run.
 */
public class Statistics
{
	/** The number of processes that have exited the system */
	public long nofCompletedProcesses = 0;
	/** The number of processes that have entered the system */
	public long nofCreatedProcesses = 0;
	/** The total time that all completed processes have spent waiting for memory */
	public long totalTimeSpentWaitingForMemory = 0;
	/** The time-weighted length of the memory queue, divide this number by the total time to get average queue length */
	public long memoryQueueLengthTime = 0;
	/** The largest memory queue length that has occured */
	public long memoryQueueLargestLength = 0;
	// Number of processhifts from expired round
	public long processTimeExpired = 0;
	//Number of IO operations
	public long ioOperationsProcessed = 0;
    // Total time cpu has been running
	public long totalCpuTime = 0;
	public long ioQueueLengthTime;
	public int ioQueueLargestLength;
	public long cpuQueueLengthTime;
	public long cpuQueueLargestLength;
	public long timesInCpuQueue;
	public long timesInIoQueue;
	public long totalTimeInSytem;
	public long totalTimeSpentWaitingForCpu;
	public long totalTimeSpentInCpu;
	public long totalTimeSpentWaitingForIo;
	public long totalTimeSpentInIo;
	
	
	/**
	 * Prints out a report summarizing all collected data about the simulation.
	 * @param simulationLength	The number of milliseconds that the simulation covered.
	 */
	public void updateTimesInCpu(long times){
		this.timesInCpuQueue = (this.timesInCpuQueue+times)/2;
		
	}
	public void updateTimesInIO(long times){
		this.timesInIoQueue = (this.timesInIoQueue+times)/2;
		
	}
	
	public void printReport(long simulationLength) {
		System.out.println();
		System.out.println("Simulation statistics:");
		System.out.println();
		System.out.println("Number of completed processes:                                "+nofCompletedProcesses);
		System.out.println("Number of created processes:                                  "+nofCreatedProcesses);
		System.out.println();
		System.out.println("Total CPU time:                                               "+totalCpuTime);
		System.out.println("Total free CPU time:                                          "+(simulationLength-totalCpuTime));
		System.out.println("Percent of time spent processing:                             "+((totalCpuTime/simulationLength)));
		System.out.println("Percent of time CPU spent idle                                "+(float)(((simulationLength-totalCpuTime)/simulationLength)));
		System.out.println();
		System.out.println("Largest occuring memory queue length:                         "+memoryQueueLargestLength);
		System.out.println("Average memory queue length:                                  "+(float)memoryQueueLengthTime/simulationLength);
		System.out.println("Largest occuring IO queue length:                         "+ioQueueLargestLength);
		System.out.println("Average IO queue length:                                  "+(float)ioQueueLengthTime/simulationLength);
		System.out.println("Largest occuring cpu queue length:                         "+cpuQueueLargestLength);
		System.out.println("Average cpu queue length:                                  "+(float)cpuQueueLengthTime/simulationLength);
		System.out.println("Average number of times in cpu:                                  " + timesInCpuQueue);
		System.out.println("Average number of times in IO:                                  " + timesInIoQueue);
		System.out.println("  ");
		System.out.println("Average time in system:                                  " + totalTimeInSytem);
		if(nofCompletedProcesses > 0) {
			System.out.println("Average # of times a process has been placed in memory queue: "+1);
			System.out.println("Average time spent waiting for memory per process:            "+
				totalTimeSpentWaitingForMemory/nofCompletedProcesses+" ms");
			System.out.println("Average time spent waiting for CPU per process:            "+
					totalTimeSpentWaitingForCpu/nofCompletedProcesses+" ms");
			System.out.println("Average time spent in for CPU per process:            "+
					totalTimeSpentInCpu/nofCompletedProcesses+" ms");
			System.out.println("Average time spent waiting for IO per process:            "+
					totalTimeSpentWaitingForIo/nofCompletedProcesses+" ms");
			System.out.println("Average time spent in for IO per process:            "+
					totalTimeSpentInIo/nofCompletedProcesses+" ms");
			System.out.println("Average number of processes completed per second: "+ (float) nofCompletedProcesses/simulationLength);
		}
	}
}

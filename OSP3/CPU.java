
public class CPU {
	
	private Queue cpuQueue;
	private Statistics statistics;
	private long maxCpuTime;
	private Process processInCpu = null;
	
	public CPU(Queue cpuQueue, Statistics statistics, long maxCpuTime) {
		super();
		this.cpuQueue = cpuQueue;
		this.statistics = statistics;
		this.maxCpuTime = maxCpuTime;
	}
	
	public void insertProcess(Process p) {
		if (processInCpu == null) {
			processInCpu = p;
		} else {
			cpuQueue.insert(p);
		}
	}
	
	public Process getRunningProcess() {
		return processInCpu; 
		
	}
	
	public void putAtTheBack() {
		cpuQueue.insert(processInCpu);
		processInCpu = (Process) cpuQueue.removeNext();
		
	}
	
	public Process removeNext() {
		Process finished = processInCpu;
		
		if(cpuQueue.isEmpty()) {
			processInCpu = null;
		} else {
			processInCpu = (Process) cpuQueue.removeNext();
		}
		return finished;
	}
	
	public boolean isIdle() {
		return processInCpu == null;
	}
	
	public void timePassed(long timePassed) {
		statistics.cpuQueueLengthTime += cpuQueue.getQueueLength()*timePassed;
		if (cpuQueue.getQueueLength() > statistics.cpuQueueLargestLength) {
			statistics.ioQueueLargestLength = cpuQueue.getQueueLength(); 
		}
    }

}

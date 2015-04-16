
public class CPU {
	
	private Queue cpuQueue;
	private Statistics statistics;
	private long maxCpuTime;
	
	public CPU(Queue cpuQueue, Statistics statistics, long maxCpuTime) {
		super();
		this.cpuQueue = cpuQueue;
		this.statistics = statistics;
		this.maxCpuTime = maxCpuTime;
	}
	
	public void insertProcess(Process p) {
		cpuQueue.insert(p);
	}
	
	public Process getRunningProcess() {
		if(!cpuQueue.isEmpty()){
			return (Process) cpuQueue.getNext();
		}
		return null; 
		
	}
	
	public void putAtTheBack() {
		if(!cpuQueue.isEmpty()){
		cpuQueue.insert(cpuQueue.removeNext());
		}
		
	}
	
	public Process removeNext() {
		return (Process) cpuQueue.removeNext();
	}
	
	public boolean isIdle() {
		return cpuQueue.isEmpty();
	}
	
	public void timePassed(long timePassed) {
		statistics.cpuQueueLengthTime += cpuQueue.getQueueLength()*timePassed;
		if (cpuQueue.getQueueLength() > statistics.cpuQueueLargestLength) {
			statistics.ioQueueLargestLength = cpuQueue.getQueueLength(); 
		}
    }

}

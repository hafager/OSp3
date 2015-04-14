
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
		return (Process) cpuQueue.getNext();
	}
	
	public void putAtTheBack() {
		cpuQueue.insert(cpuQueue.removeNext());
	}
	
	public Process removeNext() {
		return (Process) cpuQueue.removeNext();
	}
	
	public boolean isIdle() {
		return cpuQueue.isEmpty();
	}

}

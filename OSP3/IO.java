
public class IO {
	
	private Queue ioQueue;
	private Statistics statistics;
	public long avgIoTime;
	
	private Process ioRunning = null;
	
	public IO(Queue ioQueue, Statistics statistics, long avgIoTime) {
		this.ioQueue = ioQueue;
		this.statistics = statistics;
		this.avgIoTime = avgIoTime;
	}
	
	public void insertProcess(Process p) {
		ioQueue.insert(p);
	}
	
	public boolean moveInto() {
		if (ioRunning == null) {
			ioRunning = (Process) ioQueue.removeNext();
			return true;
		} else {
			return false;
		}
	}
	
	public Process removeRunning() {
		Process ioFinished = ioRunning;
		ioRunning = null;
		return ioFinished;
	}
	
	public Process removeNext() {
		return (Process) ioQueue.removeNext();
	}
	
	public boolean queueIsEmpty() {
		return ioQueue.isEmpty();
	}
	
	public Process getRunning() {
		return ioRunning;
	}
	

}

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;


public class Writer implements Runnable{

	private final ReadWriteLock lock;
	private final String name;
	private final int time;
	
	public Writer(ReadWriteLock lock, String name, int time) {
		this.lock = lock;
		this.name = name;
		this.time = time;
	}
	
	@Override
	public void run() {
		while(true){
			try{
				Thread.sleep(time);
				lock.writeLock().lock();
				Random rand =  new Random();
				char val = (char) rand.nextInt(256);
				Setup.value+=val;
				System.out.println("Executing "+name+"...");
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				lock.writeLock().unlock();
			}
		}
	}

}
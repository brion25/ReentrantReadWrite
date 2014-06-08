import java.util.concurrent.locks.*;


public class Reader implements Runnable{

	private final ReadWriteLock lock;
	private final String name;
	private final int time;
	
	public Reader(ReadWriteLock lock, String name,int time) {
		this.lock = lock;
		this.name = name;
		this.time = time;
	}
	
	@Override
	public void run() {
		while(true){
			try{
				lock.readLock().lock();
				System.out.println("Executing "+name+"... Value : "+Setup.value);
				Thread.sleep(time);
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				lock.readLock().unlock();
			}			
		}
	}

}

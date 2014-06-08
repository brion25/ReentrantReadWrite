import java.util.concurrent.locks.*;


public class Setup {

	/**
	 * @param args
	 */
	
	static String value;
	
	public static void main(String[] args) {
		value="";
		ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
		Reader r1=new Reader(lock, "Reader 1",300);
		Reader r2=new Reader(lock, "Reader 2",700);
		
		Writer w1=new Writer(lock, "Writer 1",2000);
		Writer w2=new Writer(lock, "Writer 2",1500);
		
		new Thread(w1).start();
		new Thread(w2).start();
		
		new Thread(r1).start();
		new Thread(r2).start();
	}

}

package thread.creation;

public class ThreadCreation {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> { // Runnable Interface
			// Code that will run in new thread
			System.out.println("Execution thread:" + Thread.currentThread().getName());
			throw new RuntimeException("WTF!!");
		});
		thread.setName("First-Thread");
		System.out.println("Thread Name before starting:" + Thread.currentThread().getName());
		thread.start(); // creates new thread, instructs JVM to create new thread and pass it to the OS,
						// it does not happen instantly and takes some time and it happens asynchronously
		thread.sleep(10000);
		System.out.println("Thread Name after starting:" + Thread.currentThread().getName());
		
		// ExceptionHandler for an entire thread,to be caught when exception was thrown inside the thread and was not caught by anywhere
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Exception occured for thread " + t.getName() + ". The error is: " + e.getMessage());
				
			}
		});
	}

}

package thread.exception_handling;

public class ThreadExceptionHandling {

	public static void main(String args[]) {
		Thread th = new NewThread();
		th.start();

		// ExceptionHandler for an entire thread,to be caught when exception was thrown
		// inside the thread and was not caught by anywhere
		th.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Exception occured for thread " + t.getName() + ". The error is: " + e.getMessage());

			}
		});
	}

	public static class NewThread extends Thread {
		@Override
		public void run() {
			System.out.println("This is thread - " + this.getName());
			throw new RuntimeException("Something happened in the run method");
		}
	}
}

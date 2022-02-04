
/*class MyTask {
	
	void executeTask() {
		
		for(int doc = 1; doc <= 10; doc++) {
			System.out.println("@@ Printing Docs #" + doc + " - Printer 2");
		}
		
	}
	
}*/


//My task IS-a Thread
/*class MyTask extends Thread{
	@Override
	public void run() {
		
		for(int doc = 1; doc <= 10; doc++) {
			System.out.println("@@ Printing Docs #" + doc + " - Printer 2");
		}
		
	}
	
}*/

class CA{

	
	
}

//class MyTask extends Thread{ -> Error | Multiple inheritance is not supported in Java
class MyTask extends CA implements Runnable{
	@Override
	public void run() {
		
		for(int doc = 1; doc <= 10; doc++) {
			System.out.println("@@ Printing Docs #" + doc + " - Printer 2");
		}
		
	}
	
}

class YourTask extends CA implements Runnable{
	@Override
	public void run() {
		
		for(int doc = 1; doc <= 10; doc++) {
			System.out.println("** Printing Docs #" + doc + " - Printer 3");
		}
		
	}
	
}

public class App {
	//main thread
	//threads always execute jobs in a sequance
	public static void main(String[] args) {
		
		//Job 1
		System.out.println("App started");
		
		//Job 2
		//MyTask task = new MyTask();
		//task.executeTask();
		//task.start(); //task shall interanlly executes run method
		
		
		Runnable r = new MyTask();
		Thread task = new Thread(r);
		task.setDaemon(true); //will be executed by jvm when app starts, will be executed along side main thread
		task.start();
		
		
		/*
		 * Thread yourTask = new Thread(new YourTask()); yourTask.start();
		 */
		
		new Thread(new YourTask()).start();
		
		//Till job 2 is not finished, below jobs are waiting and not executed
		//In case job 2 is a long running application, i.e. several docs are supposed to be printed
		//In such a use case OS/JVM gives a message that app is not responding
		//Some sluggish behaviour in app can be observered - App seems to hang
		
		
		//Now, main and MyTask are executed both paralelly or continuently
		
		//Job 3
		for(int doc = 1; doc <= 10; doc++) {
			
			System.out.println("^^ Printing Docs #" +doc + "- Printer 1");
			
		}
		
		//Job 4
		System.out.println("App Finished");

	}

}

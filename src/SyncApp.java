class Printer{
	
	//synchronized 
	void printDocuments(int numOfCopies, String docName){
		
		for(int i = 1; i <=numOfCopies; i++) {
			/*
			 * try { Thread.sleep(500); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
			System.out.println(">> Printing Documents " +docName+ "" +i);
			
		}
		
	}
	
}

class MyThread extends Thread{
	
	
	Printer pRef;
	
	MyThread(Printer p){
		
		pRef = p;
		
	}
	
	@Override
	public void run() {
		synchronized(pRef) {
			
			pRef.printDocuments(10, "JohnProfile.pdf");
			
		}
		
		
	}
	
	
}


class YourThread extends Thread{
	
	
	Printer pRef;
	
	YourThread(Printer p){
		
		pRef = p;
		
	}
	
	@Override
	public void run() {
		synchronized(pRef) {
			pRef.printDocuments(10, "FionasProfile.pdf");
		}
		
		
	}
	
	
}

public class SyncApp {

	public static void main(String[] args) {
		
		//main represent main thread
		System.out.println("App started");
		
		
		//We have 1 single obj of printer
		Printer printer = new Printer();
		//printer.printDocuments(10, "Ms_Stuff.pdf");
		
		
		//Scenarion is that we have multiple threads working on the same Printer Object
		//If myltiple threads work on the same obj we need to sync them
		MyThread mRef = new MyThread(printer); 			//MyThread having a referance to the Printer Object
		YourThread yRef = new YourThread(printer);		//YourThread having a referance to the Printer Object
		
		
		
		mRef.start();
		/*
		 * try { mRef.join(); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		
		yRef.start();
		
		System.out.println("App Finished");

	}

}

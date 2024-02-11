package assig3_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please Type How Many Salads To Prepare:");
		Scanner scan = new Scanner(System.in);
		final int numOfSaladsToPrepare = scan.nextInt();
		System.out.println("Preparing " + numOfSaladsToPrepare + " Salads...");
		
		SlicerMachine machinOne = new SlicerMachine();
		CucumbersThread cucumbersThread = new CucumbersThread(machinOne);
		TomatoesThread tomatoesThread = new TomatoesThread(machinOne);
		SlicerThread slicerThread = new SlicerThread(machinOne,numOfSaladsToPrepare);
		
		cucumbersThread.start();
		tomatoesThread.start();
		slicerThread.start();
		
		while(machinOne.getNumOfPreparedSalads() < numOfSaladsToPrepare)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		slicerThread.interrupt();
		tomatoesThread.interrupt();
		cucumbersThread.interrupt();
		
		
		
		
		System.out.println("Done");
		scan.close();
	}

}

package assig3_3;

public class SlicerThread extends Thread {
	
	private SlicerMachine slicerMachine;
	private int numOfSaladsToPrepare;
	
	public SlicerThread(SlicerMachine slicerMachine, int numOfSaladsToPrepare )
	{
		this.slicerMachine = slicerMachine;
		this.numOfSaladsToPrepare = numOfSaladsToPrepare;
	}
	
	@Override
	public void run()
	{
			//The thread will run until it is interrupted or until the specified condition is met.
			while(!isInterrupted() && numOfSaladsToPrepare>slicerMachine.getNumOfPreparedSalads())
			{
				slicerMachine.sliceVegetables();
			}
			
	}
	
	

}

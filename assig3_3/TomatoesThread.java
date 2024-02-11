package assig3_3;

public class TomatoesThread extends Thread {
	
	private SlicerMachine slicerMachine;
	
	public TomatoesThread(SlicerMachine slicerMachine)
	{
		this.slicerMachine = slicerMachine;
	}
		
	@Override
	public void run() 
	{
		while(!isInterrupted())
		{
			
			slicerMachine.addOneTomato();
		}
	}
}

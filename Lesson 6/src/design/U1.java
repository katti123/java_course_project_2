package design;

import java.util.Random;

public class U1 extends Rocket{

	


	public U1() {
		maxWeightLimit=18000;
		rocketWeight=10000;
		cost=100;


	}	
	@Override
	public boolean launch()	
	{

		int randNo = (int)(Math.random() * 101);	
	//	System.out.println(randNo);
		double explosionChance = 5.0 *(currentRocketWeight-rocketWeight)/(maxWeightLimit-rocketWeight);
		//System.out.println(explosionChance);
	if(explosionChance>randNo)
		{	
			
			return false;
		}
		else
		{ 
			
			return true;
		}
}	

	@Override
	public boolean land()
	{
		int randNo = (int)(Math.random() * 1000);
		double crashingChance = 1.0 *(currentRocketWeight-rocketWeight)/(maxWeightLimit-rocketWeight);
		if(crashingChance>randNo)	
		{
			
			return false;

		}
		else
		{
			
			return true;
		}


	}

}

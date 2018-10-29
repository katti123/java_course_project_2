package design;

public class U2 extends Rocket
{



	public U2()
	{
		maxRocketWeight=29000;
		cost=120;
		rocketWeight=18000;
	}
	public boolean launch()
	{


		int randNo = (int)(Math.random() * 101);	
		//	System.out.println(randNo);
		double explosionChance = 4.0 *(currentRocketWeight-rocketWeight)/(maxRocketWeight-rocketWeight);
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
	public boolean land()
	{
		int randNo = (int)(Math.random() * 101);
		double crashingChance = 8.0 *(currentRocketWeight-rocketWeight)/(maxRocketWeight-rocketWeight);
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

package design;



public class U1 extends Rocket{




	public U1() {
		maxRocketWeight=18000;
		rocketWeight=10000;
		cost=100;
		this.currentRocketWeight=this.rocketWeight;

	}	
	@Override
	public boolean launch()	
	{

		int randNo = (int)(Math.random() * 101);	
		double explosionChance = 5.0 *(currentRocketWeight-rocketWeight)/(maxRocketWeight-rocketWeight);
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
		int randNo = (int)(Math.random() * 101);
		double crashingChance = 1.0 *(currentRocketWeight-rocketWeight)/(maxRocketWeight-rocketWeight);
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

package design;

public class U2 extends Rocket
{
	int maxrocketWeightWithcargo=29000;
	private static int  rocketWeight=18000;
     int randNo = (int)(Math.random() * 1000);

     public U2()
     {
    	 setMaxWeightLimit(maxrocketWeightWithcargo);
    	 cost=120;
     }
	public boolean launch()
	{

		 float explosionChance = (float) (0.05*(rocketWeight / maxrocketWeightWithcargo));
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
		float crashingChance = (float) (0.01*(rocketWeight / maxrocketWeightWithcargo ));
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

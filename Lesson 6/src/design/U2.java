package design;

public class U2 extends Rocket
{
	int maxrocketWeightWithcargo=29;
	private static int  rocketWeight=18;
     int cargoCarried=maxrocketWeightWithcargo-rocketWeight;

     public U2()
     {
    	 setMaxWeightLimit(maxrocketWeightWithcargo);
     }
	public boolean launch()
	{
		float explosionChance = 4%(cargoCarried / maxrocketWeightWithcargo);
		System.out.println(explosionChance);
		return true;
	}
	
	public boolean land()
	{
		float crashingChance = 8% (cargoCarried  / maxrocketWeightWithcargo );
		System.out.println(crashingChance);
		return true;
	}

}

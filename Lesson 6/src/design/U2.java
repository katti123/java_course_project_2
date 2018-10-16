package design;

public class U2 extends Rocket
{
	private static int cargoLimit=29;
	private static int  rocketWeight=18;
	private static int cargoCarried=cargoLimit-rocketWeight;

	public boolean launch()
	{
		float explosionChance = 4%(cargoCarried / cargoLimit);
		System.out.println(explosionChance);
		return true;
	}
	
	public boolean land()
	{
		float crashingChance = 8% (cargoCarried  / cargoLimit );
		System.out.println(crashingChance);
		return true;
	}

}

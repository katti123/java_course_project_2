package design;

public class U1 extends Rocket{

	private static int cargoLimit=18;
	private static int  rocketWeight=10;
	private static int cargoCarried;

	public boolean launch()
	{
	     cargoCarried=(int) (Math.random()*2);
		 float explosionChance = 5%(cargoCarried / cargoLimit);
		
		 return true;
	}

	public boolean land()
	{
		 cargoCarried=(int) (Math.random()*2);
		float crashingChance = 1% (cargoCarried  / cargoLimit );
		System.out.println(crashingChance);
		return true;
	}

}

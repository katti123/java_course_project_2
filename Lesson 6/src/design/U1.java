package design;

public class U1 extends Rocket{

	 int maxrocketWeightWithcargo=1800000;
	 int  rocketWeight=1000000;
	 int cargoCarried;
	 
	 
	 public U1() {
		 setMaxWeightLimit(maxrocketWeightWithcargo);

      }

	public boolean launch()
	{
	     cargoCarried=(int) (Math.random()*20);
		 float explosionChance = 5%(cargoCarried / maxrocketWeightWithcargo);
		
		 return true;
	}

	public boolean land()
	{
		cargoCarried=(int) (Math.random()*20);
		float crashingChance = 1% (cargoCarried  / maxrocketWeightWithcargo );
		System.out.println(crashingChance);
		return true;
	}

}

package design;

public  class Rocket implements Spaceship{

	public int currentRocketWeight;
	
	

	public int cost;
	int maxRocketWeight;
	int rocketWeight;
	
	
	

	@Override
	public boolean launch() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean land() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public int carry(Item item) {
		// TODO Auto-generated method stub
		this.currentRocketWeight+=item.weight;
//	System.out.println(cargoWeight);
		return this.currentRocketWeight;

	}

	@Override
	public boolean canCarry(Item item) {
		// TODO Auto-generated method stub

		if(item.weight+currentRocketWeight>maxRocketWeight)
		{

			return false;

		}
		else
		{

		return true;
		}
	}




}

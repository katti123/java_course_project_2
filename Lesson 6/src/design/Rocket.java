package design;

public  class Rocket implements Spaceship{

	private int currentRocketWeight;
	private int maxWeightWithCargo;
	private int cargoWeight;
	private int rocketWeight;
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
		this.currentRocketWeight=rocketWeight+cargoWeight;
		return this.currentRocketWeight;
	}

	@Override
	public boolean canCarry(Item item) {
		// TODO Auto-generated method stub
		if(this.currentRocketWeight>maxWeightWithCargo)
		{
			
		return false;
		}
		return true;
	}



}

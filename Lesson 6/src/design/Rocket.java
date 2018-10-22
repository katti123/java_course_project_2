package design;

public  class Rocket implements Spaceship{

	public int currentRocketWeight;
	public int cost;
	int maxWeightLimit;
	int maxWeight;

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
		return this.currentRocketWeight;

	}

	@Override
	public boolean canCarry(Item item) {
		// TODO Auto-generated method stub
		maxWeight=item.weight+currentRocketWeight;

		if(maxWeight>maxWeightLimit)
		{

			return false;

		}

		return true;
	}




}

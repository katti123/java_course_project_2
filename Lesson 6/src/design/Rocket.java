package design;

public  class Rocket implements Spaceship{

	private int currentRocketWeight;
	int maxWeightLimit;
	

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
		
		if((item.weight+currentRocketWeight)>maxWeightLimit)
		{
			
		return false;
		
		}
		return true;
	}

	public int getMaxWeightLimit() {
		return maxWeightLimit;
	}

	public void setMaxWeightLimit(int maxWeightLimit) {
		this.maxWeightLimit = maxWeightLimit;
	}



}

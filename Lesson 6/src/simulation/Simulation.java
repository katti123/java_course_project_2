package simulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import design.Item;
import design.Rocket;
import design.U1;
import design.U2;

public class Simulation {
	public ArrayList<Item> loadItems(String file) throws FileNotFoundException
	{
		ArrayList<Item> items=new ArrayList<>();
		File phase=new File(file);
		Scanner scanner=new Scanner(phase);

		while(scanner.hasNextLine())
		{
			String line=scanner.nextLine();
			String[] lineSplit=line.split("=");

			Item i=new Item(lineSplit[0], Integer.valueOf(lineSplit[1]));
			items.add(i);
		}

		return items;

	}

	public ArrayList<Rocket> loadU1 (ArrayList<Item> getItems)
	{  
		ArrayList<Rocket> list_rocketsU1=new ArrayList<>();

		U1 r1=new U1();
		list_rocketsU1.add(r1);

		for(Item item:getItems) 
		{

			if(r1.canCarry(item))
			{

				r1.carry(item);


			}
			else

			{

				r1 = new U1();
				list_rocketsU1.add(r1);
				r1.carry(item);		
			}


		}	

		return list_rocketsU1;

	}

	public ArrayList<Rocket> loadU2 (ArrayList <Item> getItems)
	{

		ArrayList<Rocket> list_rocketsU2=new ArrayList<>();
		Rocket r2=new U2();

		for(Item item:getItems) {

			if(r2.canCarry(item))
			{

				r2.carry(item);


			}
			else
			{

				list_rocketsU2.add(r2);
				r2=new U2();
				r2.carry(item);

			}

		}	
		list_rocketsU2.add(r2);

		return list_rocketsU2;

	}
	public int runSimulation(ArrayList <Rocket> rockets)
	{
		//int rocketsExploded=0;
		int  rocketSuccess=0;
		int rocketsCrashed=0;

		for(Rocket a1:rockets)
		{

			while(!a1.launch() || !a1.land())  
			{
				rocketsCrashed++;

			}
			rocketSuccess++;


		}
		//	System.out.println(rocketsExploded + " rockets were exploded"+ "," + rocketsCrashed + " rockets were crashed");
		System.out.println( rocketSuccess + " rockets were successfully launched and landed"); 
		int budget =rockets.get(0).cost* ( rocketSuccess+rocketsCrashed);
		System.out.println("So "+ rocketSuccess + " rockets and " + (+ rocketsCrashed )+ " extra rockets needed = "
				+ (rocketSuccess  + rocketsCrashed) + " in total");

		return budget;

	}

	public static void main(String[] args) throws FileNotFoundException {
		String phase1="phase1.txt";
		String phase2="phase2.txt";
		Simulation simulate=new Simulation();
		ArrayList<Item> firstPhase=simulate.loadItems(phase1);
		ArrayList<Item> secondPhase=simulate.loadItems(phase2);

		ArrayList<Rocket> U1RocketsListFirstPhase=simulate.loadU1(firstPhase);
		ArrayList<Rocket> U1RocketsListSecondPhase=simulate.loadU1(secondPhase);

		System.out.println("\n U1 fleet for Phase 1 contains " +  U1RocketsListFirstPhase.size()+ " rockets");
		System.out.println("\n U1 fleet for Phase 2 contains " +  U1RocketsListSecondPhase.size()+ " rockets");
		//System.out.println("For phase 1 : ");
		int budgetForPhase1U1 =simulate.runSimulation(U1RocketsListFirstPhase);
		System.out.println("Total budget for U1 rockets for phase 1 : "  + budgetForPhase1U1 +  "$(in millions) ");

		//		System.out.println("For phase 2 : ");
		//		int budgetForPhase2U1=  simulate.runSimulation(U1RocketsListSecondPhase);
		//System.out.println("Total budget for U1 rockets for phase 2 : "  + budgetForPhase2U1 +  "$(in millions) ");
		//System.out.println("Total budget for U1 rockets : " + (budgetForPhase1U1+budgetForPhase2U1) + "$(in millions)" );


		ArrayList<Rocket> U2RocketsListFirstPhase=simulate.loadU2(firstPhase);
		ArrayList<Rocket> U2RocketsListSecondPhase=simulate.loadU2(secondPhase);

		System.out.println("\n U2 fleet for Phase 1 contains " +  U2RocketsListFirstPhase.size()+ " rockets");
		System.out.println("\n U2 fleet for Phase 2 contains " +  U2RocketsListSecondPhase.size()+ " rockets");	
		//	System.out.println("\nFleet of U2 contains " +  (U2RocketsListFirstPhase.size()+U2RocketsListSecondPhase.size())+ " rockets");
		//		System.out.println("For phase 1 : ");
		//		int budgetForPhase1U2 =simulate.runSimulation(U2RocketsListFirstPhase);
		//		System.out.println("Total budget for U2 rockets for phase 1 : "  + budgetForPhase1U2 +  "$(in millions) ");
		//		
		//		System.out.println("For phase 2 : ");
		//		int budgetForPhase2U2=  simulate.runSimulation(U2RocketsListSecondPhase);
		//		System.out.println("Total budget for U2 rockets for phase 2 : "  + budgetForPhase2U2 +  "$(in millions) ");
		//		System.out.println("Total budget for U2 rockets : " + (budgetForPhase1U2+budgetForPhase2U2) + "$(in millions)" );

	}

}

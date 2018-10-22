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
		System.out.println(file +" contains " + items.size() + " items");
		return items;

	}

	public ArrayList<Rocket> loadU1 (ArrayList<Item> getItems)

	{  

		ArrayList<Rocket> list_rocketsU1=new ArrayList<>();
		Rocket r1=new U1();
		for(Item h:getItems) 
		{

			if(r1.canCarry(h))
			{

				
				r1.carry(h);


			}
			else
			{

				list_rocketsU1.add(r1);
				r1=new U1();
				
				
			}

		}	
		list_rocketsU1.add(r1);

		return list_rocketsU1;
	}

	public ArrayList<Rocket> loadU2 (ArrayList <Item> getItems)
	{

		ArrayList<Rocket> 	list_rocketsU2=new ArrayList<>();
		Rocket r2=new U2();

		for(Item h:getItems) {

			if(r2.canCarry(h))
			{
				//list_rocketsU2.add(r2);
				r2.carry(h);


			}
			else
			{

				list_rocketsU2.add(r2);
				r2=new U1();
			
				
			}

		}	
		list_rocketsU2.add(r2);

		return list_rocketsU2;

	}
	public int runSimulation(ArrayList <Rocket> rockets)

	{
		int rocketsExploded=0;
		int  rocketSuccess=0;
		int rocketsCrashed=0;

		for(Rocket a1:rockets)
		{
			while(a1.launch()== false)  
			{
				rocketsExploded++;
				System.out.println(rocketsExploded + " rockets were exploded");
				a1.launch();

				//System.out.println(" Extra rockets needed : " +  noOfRockets );

			}
			rocketSuccess++;


			while(a1.land()==false)
			{    

				a1.launch();
				rocketsCrashed++;
				System.out.println(rocketsCrashed + " rockets were crashed");
				//System.out.println("Extra rockets needed : " + noOfRockets );
			}
			System.out.println(rocketSuccess + " rockets were successfully launched and landed");
		}

		//System.out.println(rocketSuccess + " rockets was successfully landed");
		int budget =rockets.get(0).cost* ( rockets.size()+rocketsExploded+rocketsCrashed);
		System.out.println("So "+ rockets.size() + " rockets and " + (rocketsExploded + rocketsCrashed )+ " extra rockets needed = "
				+ (rockets.size() + rocketsExploded + rocketsCrashed) + " in total");

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
		
		System.out.println("\nFleet of U1 contains " +  (U1RocketsListFirstPhase.size()+U1RocketsListSecondPhase.size())+ " rockets");
		System.out.println("For phase 1 : ");
		int budgetForPhase1U1 =simulate.runSimulation(U1RocketsListFirstPhase);
		System.out.println("Total budget for U1 rockets for phase 1 : "  + budgetForPhase1U1 +  " (in millions) ");

		System.out.println("For phase 2 : ");
		int budgetForPhase2U1=  simulate.runSimulation(U1RocketsListSecondPhase);
		System.out.println("Total budget for U1 rockets for phase 2 : "  + budgetForPhase2U1 +  " (in millions) ");
		System.out.println("Total budget for U1 rockets : " + (budgetForPhase1U1+budgetForPhase2U1) + "(in millions)" );

		
		ArrayList<Rocket> U2RocketsListFirstPhase=simulate.loadU2(firstPhase);
		ArrayList<Rocket> U2RocketsListSecondPhase=simulate.loadU2(secondPhase);
		
		System.out.println("\nFleet of U2 contains " +  (U2RocketsListFirstPhase.size()+U2RocketsListSecondPhase.size())+ " rockets");
		System.out.println("For phase 1 : ");
		int budgetForPhase1U2 =simulate.runSimulation(U2RocketsListFirstPhase);
		System.out.println("Total budget for U2 rockets for phase 1 : "  + budgetForPhase1U2 +  " (in millions) ");
		
		System.out.println("For phase 2 : ");
		int budgetForPhase2U2=  simulate.runSimulation(U2RocketsListSecondPhase);
		System.out.println("Total budget for U2 rockets for phase 2 : "  + budgetForPhase2U2 +  " (in millions) ");
		System.out.println("Total budget for U2 rockets : " + (budgetForPhase1U2+budgetForPhase2U2) + "(in millions)" );

	}

}

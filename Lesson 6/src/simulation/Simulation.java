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
	
	
		int rocketCount=0;
	
	
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
		
		ArrayList<Rocket> U1Rockets=new ArrayList<>();
		Rocket r1=new U1();
		for(Item h:getItems) 
		{
	
		if(r1.canCarry(h))
		{
			
			r1.carry(h);
				

		}
		else
		{
		 
			U1Rockets.add(r1);
	     	r1=new U1();
		   r1.carry(h);
		}
		
		}	
		U1Rockets.add(r1);
		
		return U1Rockets;
	}
	
	public ArrayList<Rocket> loadU2 (ArrayList <Item> getItems)
	{
		
		ArrayList<Rocket> 	U2Rockets=new ArrayList<>();
		Rocket r2=new U2();
			
		for(Item h:getItems) {
		
			if(r2.canCarry(h))
			{
				
				r2.carry(h);
					

			}
			else
			{
			 
				U2Rockets.add(r2);
		     	r2=new U1();
			   r2.carry(h);
			}
			
			}	
			U2Rockets.add(r2);
		
	return U2Rockets;

		}
	public int runSimulation(ArrayList <Rocket> rockets)
	
	{
		int noOfRocketsExtra=0;
		int rocketSuccess=1;
		
		for(Rocket a1:rockets)
		{
			while(a1.launch()== false)  
			{
				a1.launch();
				noOfRocketsExtra++;
				//System.out.println(" Extra rockets needed : " +  noOfRockets );

			}
			//System.out.println(rocketSuccess + " rockets was successfully launched");
			
      while(a1.land()==false)
		{    a1.launch();
			noOfRocketsExtra++;
			//System.out.println("Extra rockets needed : " + noOfRockets );
				}
	
		}
		rocketSuccess++;
		//System.out.println(rocketSuccess + " rockets was successfully landed");
		int budget =rockets.get(0).cost* (rockets.size()+noOfRocketsExtra);
		System.out.println(rockets.size() + " rockets and " + noOfRocketsExtra + " extra rockets needed = "
                + (rockets.size() + noOfRocketsExtra) + " in total");
	
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
		
		 
		 
	     int budgetForPhase1U1 =simulate.runSimulation(U1RocketsListFirstPhase);
	 	System.out.println("Total budget for U1 rockets for phase 1 : "  + budgetForPhase1U1 +  " (in millions) ");
	 	 int budgetForPhase2U1=  simulate.runSimulation(U1RocketsListSecondPhase);
		  System.out.println("Total budget for U1 rockets for phase 2 : "  + budgetForPhase2U1 +  " (in millions) ");
		  System.out.println("Total budget for U1 rockets : " + (budgetForPhase1U1+budgetForPhase2U1) + "(in millions)" );
		 
		 
			
		  ArrayList<Rocket> U2RocketsListFirstPhase=simulate.loadU2(firstPhase);
			
			
			 ArrayList<Rocket> U2RocketsListSecondPhase=simulate.loadU2(secondPhase);
			 System.out.println("\nFleet of U2 contains " +  (U2RocketsListFirstPhase.size()+U2RocketsListSecondPhase.size())+ " rockets");
			
			 
			 
		     int budgetForPhase1U2 =simulate.runSimulation(U2RocketsListFirstPhase);
		 	System.out.println("Total budget for U2 rockets for phase 1 : "  + budgetForPhase1U2 +  " (in millions) ");
		 	 int budgetForPhase2U2=  simulate.runSimulation(U2RocketsListSecondPhase);
			  System.out.println("Total budget for U2 rockets for phase 2 : "  + budgetForPhase2U2 +  " (in millions) ");
			  System.out.println("Total budget for U2 rockets : " + (budgetForPhase1U2+budgetForPhase2U2) + "(in millions)" );
		
	}
	
}

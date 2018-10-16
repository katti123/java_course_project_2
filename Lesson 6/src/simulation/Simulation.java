package simulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import design.Item;
import design.Rocket;
import design.U1;
import design.U2;

public class Simulation {
	
	static ArrayList<Rocket> U1Rockets;
	static ArrayList<Rocket> U2Rockets;
	
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
		U1Rockets=new ArrayList<>();
		for(Item h:getItems) {
		U1 r1=new U1();
		if(r1.canCarry(h))
		{
			U1Rockets.add( r1);
			
		}
		else
		{
			U1 newr1=new U1();
			U1Rockets.add(newr1);
		}
		}

		return U1Rockets;
	}
	
	public ArrayList<Rocket> loadU2 (ArrayList <Item> getItems)
	{
		
		U2Rockets=new ArrayList<>();
		System.out.println(U2Rockets);
			
		for(Item h:getItems) {
		U2 r2=new U2();
		if(r2.canCarry(h))
		{
			U2Rockets.add(r2);
		}
		else
		{
			U2 newr2=new U2();
			U2Rockets.add(newr2);
		}
		}
		
	return U2Rockets;

		}
	public float runSimulation(ArrayList <Rocket> rockets)
	
	{
		for(Rocket a1:rockets)
		{
			if(a1.launch()|| a1.land()== false)
			{
				a1.launch();
				
			}		
			
		}
		
		return 0;
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String phase1="/home/veena/Desktop/phase1.txt";
		String phase2="/home/veena/Desktop/phase2.txt";
		Simulation simulate=new Simulation();
		 ArrayList<Item> firstPhase=simulate.loadItems(phase1);
		 ArrayList<Item> secondPhase=simulate.loadItems(phase2);
		 
		 ArrayList<Rocket> U1RocketsListFirstPhase=simulate.loadU1(firstPhase);
		 ArrayList<Rocket>  U2RocketsListSecondPhase=simulate.loadU2(secondPhase);
		 
		 
			
				
		
	}
	
}

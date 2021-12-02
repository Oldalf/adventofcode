package day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Dive {
  final static private String path = "inputs/2.txt";
 
  private LinkedList<Integer> forwardCommands = new LinkedList<Integer>();
  private LinkedList<Integer> downCommands = new LinkedList<Integer>();
  private LinkedList<Integer> upCommands = new LinkedList<Integer>();
  
  private int horizontal = 0;
  private int vertical = 0;
  
  public void runA() throws FileNotFoundException {
    FileInputStream inputStream = new FileInputStream(path);
    Scanner scan = new Scanner(inputStream);
    
    while(scan.hasNextLine()) {
      String input = scan.nextLine();
      String[] split = input.split("\\s");
      if(split.length >= 2) {
        if(split[0].contains("forward")) {
          forwardCommands.add(Integer.parseInt(split[1]));
        } else if (split[0].contains("down")) {
          downCommands.add(Integer.parseInt(split[1]));
        } else if (split[0].contains("up")) {
          upCommands.add(Integer.parseInt(split[1]));
        }
      }
    }
    
    scan.close();
    
    horizontal = forwardCommands
        .stream()
        .reduce(0, Integer::sum);
    
    Integer down = downCommands
        .stream()
        .reduce(0, Integer::sum);
    
    Integer up = upCommands
        .stream()
        .reduce(0, Integer::sum);
    
    vertical = down - up;
    
    System.out.println(vertical * horizontal); 
  }
  
  public void runB()  throws FileNotFoundException {
  	Integer aim = 0;
  	Integer horizontal = 0;
  	Integer vertical = 0;
  	
		FileInputStream inputStream = new FileInputStream(path);
		Scanner scan = new Scanner(inputStream);
		
		while(scan.hasNextLine()) {
			String input = scan.nextLine();
      String[] split = input.split("\\s");
      
      if(split.length >= 2) {
      	Integer value = Integer.parseInt(split[1]);
        if(split[0].contains("forward")) {
        	horizontal += value;
        	vertical += (value * aim);
        } else if (split[0].contains("down")) {
        	aim += value;
        } else if (split[0].contains("up")) {
        	aim -= value;
        }
      }      
		}
		
		System.out.println(horizontal * vertical); 			
		
		scan.close();
  }

}

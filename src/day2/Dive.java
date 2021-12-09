package day2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import adventofcode2021.AdventDay;

public class Dive implements AdventDay {
  final static private String path = "inputs/2.txt";
  private LinkedList<String> input = new LinkedList<String>();
  
  private int horizontal = 0;
  private int vertical = 0;
  
  public Dive() {
  	try {
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
			
			String line;
			while((line = inputStream.readLine()) != null) {
				input.add(line);				
			}
			
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
  }
  
  public void runA() {  
    LinkedList<Integer> forwardCommands = new LinkedList<Integer>();
    LinkedList<Integer> downCommands = new LinkedList<Integer>();
    LinkedList<Integer> upCommands = new LinkedList<Integer>();
    
    @SuppressWarnings("unchecked")
		LinkedList<String> clone = (LinkedList<String>) input.clone();
    
    clone.stream().forEach((value) -> {
    	String[] split = value.split("\\s");
	    if(split.length >= 2) {
	      if(split[0].contains("forward")) {
	        forwardCommands.add(Integer.parseInt(split[1]));
	      } else if (split[0].contains("down")) {
	        downCommands.add(Integer.parseInt(split[1]));
	      } else if (split[0].contains("up")) {
	        upCommands.add(Integer.parseInt(split[1]));
	      }
	    }
    });  
    
    
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
    
    System.out.println("Day2 A: "+ vertical * horizontal); 
  }
  
  public void runB() {
  	Integer aim = new Integer(0);
  	Integer horizontal = 0;
  	Integer vertical = 0;
  	
  	
  	@SuppressWarnings("unchecked")
		LinkedList<String> clone = (LinkedList<String>) input.clone();
  	
  	for(String value: clone) {
  		String[] split = value.split("\\s");
    	if(split.length >= 2) {
      	Integer val = Integer.parseInt(split[1]);
        if(split[0].contains("forward")) {
        	horizontal += val;
        	vertical += (val * aim);
        } else if (split[0].contains("down")) {
        	aim += val;
        } else if (split[0].contains("up")) {
        	aim -= val;
        }
      }  		
  	}

		System.out.println("day2 B: " + horizontal * vertical); 			
  }

}

package day14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import adventofcode2021.AdventDay;

public class Polymer implements AdventDay {
  final static private String path = "inputs/14.txt";
  private HashMap<String, Long> input = new HashMap<String, Long>();
  private HashMap<String, String[]> formula = new HashMap<String, String[]>();
  private String lastChar;
  
  public Polymer() {
    this.readInput();
  }
  
  public void readInput() {
    try {
      BufferedReader inputStream = new BufferedReader(
          new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
      
      String firstLine = inputStream.readLine();
      
      String[] template = firstLine.split("");
      for(int i = 1; i < template.length; i++) {
        String pair = template[i-1] + template[i];
        Long existing = input.get(pair);
        if(existing != null) {
          input.put(pair, ++existing);
        } else {
          input.put(pair, 1L);
        }
      }
      lastChar = template[template.length - 1];

      String line;
      while ((line = inputStream.readLine()) != null) {
        if(line.trim().length() > 0) {         
          String[] c = line.split("->");
          String key = c[0].trim();
          String value = c[1].trim();
          
          String[] amendedVal = new String[] {
              key.substring(0, 1) + value,
              value + key.substring(1,2),
          };
          
          formula.put(key, amendedVal);
        }
      }

      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }

  @SuppressWarnings("unchecked")
  public void runA() {
    HashMap<String, Long> polymer = (HashMap<String, Long>) input.clone();
    
    for(int i = 0; i < 10; i++) {
      HashMap<String, Long> newPolymer = new HashMap<String, Long>();
      
      
      Set<Entry<String, Long>> set = polymer.entrySet();
      for(Entry<String, Long> ent: set) {
        String[] newPoli = formula.get(ent.getKey());
        
        for(String poly: newPoli) {
          Long existing = newPolymer.get(poly);
          if(existing != null) {
            newPolymer.put(poly, existing + ent.getValue());
          } else {
            newPolymer.put(poly, ent.getValue());            
          }
        }
        
      }
      polymer = newPolymer;
    }
    
    HashMap<String, Long> usage = this.getElementUsage(polymer);
    
    Long min = Collections.min(usage.values());
    Long max = Collections.max(usage.values());
    
    System.out.println("Day14 A: " + (max-min));
  }

  @SuppressWarnings("unchecked")
  public void runB() {
    HashMap<String, Long> polymer = (HashMap<String, Long>) input.clone();
    
    for(int i = 0; i < 40; i++) {
      HashMap<String, Long> newPolymer = new HashMap<String, Long>();
      
      
      Set<Entry<String, Long>> set = polymer.entrySet();
      for(Entry<String, Long> ent: set) {
        String[] newPoli = formula.get(ent.getKey());
        
        for(String poly: newPoli) {
          Long existing = newPolymer.get(poly);
          if(existing != null) {
            newPolymer.put(poly, existing + ent.getValue());
          } else {
            newPolymer.put(poly, ent.getValue());            
          }
        }
        
      }
      polymer = newPolymer;
    }
    
    HashMap<String, Long> usage = this.getElementUsage(polymer);
    
    Long min = Collections.min(usage.values());
    Long max = Collections.max(usage.values());
    
    System.out.println("Day14 B: " + (max-min));
  }
  
  private HashMap<String, Long> getElementUsage(HashMap<String, Long> polymer) {
  	HashMap<String, Long> elements = new HashMap<String, Long>();
  	
  	for(Entry<String, Long> entry: polymer.entrySet()) {
  		String key = entry.getKey();
  		Long amount = entry.getValue();
  		
  		String part = key.substring(0,1);
  		
  		Long existing = elements.get(part);
      if(existing != null) {
        elements.put(part, existing + amount);
      } else {
        elements.put(part, amount);
      }
  	}
  	
  	Long a = elements.get(lastChar);
  	elements.put(lastChar, ++a);
  	
    return elements;
  }

}

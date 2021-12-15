package day14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import adventofcode2021.AdventDay;

public class Polymer implements AdventDay {
  final static private String path = "inputs/test.txt";
  private HashMap<String, Integer> input = new HashMap<String, Integer>();
  private HashMap<String, String[]> formula = new HashMap<String, String[]>();
  
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
        Integer existing = input.get(pair);
        if(existing != null) {
          input.put(pair, ++existing);
        } else {
          input.put(pair, 1);
        }
      }

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
    HashMap<String, Integer> polymer = (HashMap<String, Integer>) input.clone();
    
    // for each input value, go through and move the count onto the
    // 2 new pairs created and put in new structure.
    
    for(int i = 0; i < 10; i++) {
      HashMap<String, Integer> newPolymer = new HashMap<String, Integer>();
      
      
      Set<Entry<String, Integer>> set = polymer.entrySet();
      for(Entry<String, Integer> ent: set) {
        String[] newPoli = formula.get(ent.getKey());
        
        for(String poly: newPoli) {
          Integer existing = newPolymer.get(poly);
          if(existing != null) {
            newPolymer.put(poly, existing + ent.getValue());
          } else {
            newPolymer.put(poly, ent.getValue());            
          }
        }
        
      }
      polymer = newPolymer;
    }
    
    System.out.println("Day14 A: ");
  }

  public void runB() {

  }
  
  private HashMap<String, Integer> getElementUsage(HashMap<String, Integer> polymer) {
    return null;
  }

}

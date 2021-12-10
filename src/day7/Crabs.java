package day7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.OptionalInt;

import adventofcode2021.AdventDay;

public class Crabs implements AdventDay {
  final static private String path = "inputs/test.txt";
  private HashMap<Integer, Integer> inputs = new HashMap<Integer, Integer>();
  
  public Crabs() {
    try {
      BufferedReader inputStream = new BufferedReader(
          new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));

      String line = inputStream.readLine();
      
      Arrays.stream(line.split(",")).forEach(value -> {
        Integer v = Integer.parseInt(value);
        Integer existing = inputs.get(v);
        if(existing == null) {
          inputs.put(v, 1);
        } else {
          inputs.put(v, existing + 1);
        }
      });

      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    inputs.entrySet().forEach(entry -> {
      System.out.println(entry.getKey() + " " + entry.getValue());
  });
    
  }

  public void runA() {
    Integer max = Collections.max(inputs.keySet());
    
    // Map all inputs into a new object
    // object should know the max input and then calculate a list
    // of the costs it takes to go to each position between 0 and including max (its own position + abs[diff] * amount
    // then iterate through all objects to merge the lists and get the costs of
    // going to each position
  }

  public void runB() {

  }

}

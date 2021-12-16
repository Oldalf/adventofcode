package day15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

import adventofcode2021.AdventDay;

public class Chiton implements AdventDay {
  final static private String path = "inputs/test.txt";
  private ArrayList<ArrayList<Integer>> inputs = new ArrayList<ArrayList<Integer>>();
  
  public Chiton() {
    this.readInput();
  }
  
  public void readInput() {
    try {
      BufferedReader inputStream = new BufferedReader(
          new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
      
      String firstLine = inputStream.readLine();
      Arrays.stream(firstLine.split(""))
        .map(value -> Integer.parseInt(value))
        .forEachOrdered(node -> {
          ArrayList<Integer> list = new ArrayList<Integer>();
          list.add(node);
          inputs.add(list);          
        });

      String line;
      int counter = 1;
      while ((line = inputStream.readLine()) != null) {
        counter++;

        Integer[] in = Arrays.stream(line.split(""))
          .map(value -> Integer.parseInt(value))
          .toArray(Integer[]::new);
        
        for(int i = 0; i < in.length; i++) {
          
          
        }
        
      }

      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }

  public void runA() {

  }

  public void runB() {

  }

}

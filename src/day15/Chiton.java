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
      while ((line = inputStream.readLine()) != null) {

        Integer[] in = Arrays.stream(line.split(""))
          .map(value -> Integer.parseInt(value))
          .toArray(Integer[]::new);
        
        for(int i = 0; i < in.length; i++) {
          inputs.get(i).add(in[i]);          
        }
      }
      
      // print grid.
      int size = inputs.get(0).size();
      for(int j = 0; j < size; j++) {
        for(int i = 0; i < inputs.size(); i++) {
          System.out.print(inputs.get(i).get(j) + " ");
        }        
        System.out.println();
      }

      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }

  public void runA() {
    Integer finalX = inputs.size()-1;
    Integer finalY = inputs.get(finalX).size()-1;

  }

  public void runB() {

  }

}

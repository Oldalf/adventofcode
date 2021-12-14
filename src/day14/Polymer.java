package day14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

import adventofcode2021.AdventDay;
import day5.Vent;

public class Polymer implements AdventDay {
  final static private String path = "inputs/test.txt";
  private HashMap<String, Integer> input = new HashMap<String, Integer>();
  
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
        String pair = template[i-1] + template[i+1];
        Integer existing = input.get(pair);
        if(existing != null) {
          input.put(pair, ++existing);
        } else {
          input.put(pair, 1);
        }
      }
      
      // map template map so it goes pair -> the 2 new pairs that will be created
      // CN -> C will be in a map like this: CN -> [CC, CN] and so forth.

      String line;
      while ((line = inputStream.readLine()) != null) {
        String[] c = line.split("->");
        int[] firstPoint = Arrays.stream(c[0].split(",")).mapToInt(value -> Integer.parseInt(value.trim())).toArray();

        int[] secondPoint = Arrays.stream(c[1].split(",")).mapToInt(value -> Integer.parseInt(value.trim())).toArray();

        //input.add(new Vent(firstPoint[0], secondPoint[0], firstPoint[1], secondPoint[1]));
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
